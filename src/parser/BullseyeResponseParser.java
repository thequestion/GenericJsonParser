package parser;

import java.util.StringTokenizer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author wenbyuan This helper class is used to get value from Json String
 *         given a element path eg. age lastViewedItems, 0 lastViewedItems, 2,
 *         categoryId
 */
public class BullseyeResponseParser {

	private JSONObject jsonObject;

	public BullseyeResponseParser(String rawJson) {
		try {
			jsonObject = new JSONObject(rawJson);
		} catch (JSONException ex) {
			System.out.println("Invalid JSON string: " + rawJson);
		}
	}

	public Object getValue(String... arguments) {
		return getValueRecursively(jsonObject, 0, arguments);
	}

	private Object getValueRecursively(JSONObject jsonObject, int startIndex,
			String[] arguments) {
		if (jsonObject == null || arguments == null)
			return null;
		if (startIndex >= arguments.length) { // argument on current index is
												// null
			return getLeafValue(jsonObject);
		}

		String attributeName = arguments[startIndex];
		if (!jsonObject.has(attributeName) || jsonObject.isNull(attributeName))
			return null; // attribute not in JSON or attribute's value is null
		if (startIndex + 1 >= arguments.length) { // argument on current index
													// is not null AND argument
													// on next index is null
			try {
				return getLeafValue(jsonObject.get(attributeName));
			} catch (JSONException e) {
				System.out.println("Unable to get attribute " + attributeName
						+ "from JSON object. " + e.getMessage());
			}
		}

		Object nextArgument = arguments[startIndex + 1];
		Object nextObject = null;
		int nextStartIndex = startIndex;
		if (isIndex(nextArgument)) {
			try {
				int index = Integer.parseInt(nextArgument.toString());
				JSONArray array = jsonObject.getJSONArray(attributeName);
				if (index >= 0 && index < array.length()) {
					nextObject = array.get(index);
					nextStartIndex += 2;
				}
			} catch (JSONException ex) {
				System.out.println("Arguments are invalid. Arguments: "
						+ getArguments(arguments)
						+ ". A JSON array is expected for this attribute: "
						+ attributeName);
			}

		} else if (isAttribute(nextArgument)) {
			try {
				nextObject = jsonObject.getJSONObject(attributeName);
				nextStartIndex += 1;
			} catch (JSONException ex) {
				System.out.println("Arguments are invalid. Arguments: "
						+ getArguments(arguments)
						+ ". A JSON object is expected for this attribute: "
						+ attributeName);
			}
		}

		if (nextObject instanceof JSONObject)
			return getValueRecursively((JSONObject) nextObject, nextStartIndex,
					arguments);
		else
			return getLeafValue(nextObject); // leaf value
	}

	private String getArguments(String[] arguments) {
		StringBuffer buffer = new StringBuffer();
		for (String s : arguments) {
			buffer.append(s + " ");
		}
		return buffer.toString();
	}

	private Object getLeafValue(Object rawValue) {
		if (rawValue == null || rawValue == JSONObject.NULL)
			return null;
		if (isLeafValue(rawValue)) {
			JSONObject value = (JSONObject) rawValue;
			return getLeafValueByDatatype(value);
		} else {
			return rawValue;
		}
	}

	private Object getLeafValueByDatatype(JSONObject value) {
		String[] datatypes = JSONObject.getNames(value);

		if (datatypes[0].equals("String")) {
			return value.getString(datatypes[0]);
		} else if (datatypes[0].equals("Long")) {
			return value.getLong(datatypes[0]);
		} else if (datatypes[0].equals("Integer")) {
			return value.getInt(datatypes[0]);
		} else if (datatypes[0].equals("Double")) {
			return value.getDouble(datatypes[0]);
		} else if (datatypes[0].equals("Boolean")) {
			return value.getBoolean(datatypes[0]);
		}
		return null;
	}

	/**
	 * A valid leaf value is {datatype : value} pair A value is treated as leaf
	 * value iff it is a JSON object and the value has one colon
	 * 
	 * @param rawValue
	 * @return
	 */
	private boolean isLeafValue(Object rawValue) {
		if (rawValue instanceof JSONArray)
			return false;
		else if (rawValue instanceof JSONObject) {
			String value = rawValue.toString();
			StringTokenizer tokens = new StringTokenizer(value, ":");
			return tokens.countTokens() == 2;
		}
		return false;
	}

	/**
	 * Return true iff this object represents an attribute name constructed by
	 * only letters
	 * 
	 * @param next
	 * @return
	 */
	private boolean isAttribute(Object next) {
		if (next == null)
			return false;
		String s = next.toString();
		if (s.length() <= 0)
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (!isLetter(s.charAt(i)))
				return false;
		}
		return true;
	}

	/**
	 * Return true iff this char is a letter
	 * 
	 * @param char
	 * @return
	 */
	private boolean isLetter(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}

	/**
	 * Return true iff this char is between 0 to 9, both inclusive
	 * 
	 * @param next
	 * @return
	 */
	private boolean isIndex(Object next) {
		if (next == null)
			return false;
		String s = next.toString();
		if (s.length() != 1)
			return false;
		return s.charAt(0) >= '0' && s.charAt(0) <= '9';
	}
}
