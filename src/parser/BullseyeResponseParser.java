package parser;

import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author wenbyuan
 * This helper class is used to get value from Json String given a element path
 * eg. 	age
 * 		lastViewedItems, 0
 * 		lastViewedItems, 2, categoryId
 */
public class BullseyeResponseParser {

	private JSONObject jsonObject;
	
	public BullseyeResponseParser(String rawJson) {
		try{
			jsonObject = new JSONObject(rawJson); 
		}catch(JSONException ex){
			System.out.println("Invalid JSON string: " + rawJson );
		}
	}
	
	public Object getValue(String... arguments){
		return getValueRecursively(jsonObject, 0, arguments);
	}

	private Object getValueRecursively(JSONObject jsonObject, int startIndex, String[] arguments) {
		if(jsonObject == null || arguments == null)	return null;
		if(startIndex >= arguments.length){ //argument on current index is null
			return getLeafValue(jsonObject);	
		}
		
		String attributeName = arguments[startIndex];
		if(!jsonObject.has(attributeName) || jsonObject.isNull(attributeName))	return null;		//attribute not in JSON or attribute's value is null
		if(startIndex + 1 >= arguments.length){	//argument on current index is not null AND argument on next index is null
			try {
				return getLeafValue(jsonObject.get(attributeName));
			} catch (JSONException e) {
				System.out.println("Unable to get attribute " + attributeName + "from JSON object. " 
						+ e.getMessage());
			}	
		}

		Object nextArgument = arguments[startIndex + 1];
		Object nextObject = null;
		int nextStartIndex = startIndex;
		if(isIndex(nextArgument)){
			try{
				int index = Integer.parseInt(nextArgument.toString());
				JSONArray array = jsonObject.getJSONArray(attributeName);
				if(index >= 0 && index < array.length()){
					nextObject = array.get(index);
					nextStartIndex += 2;
				}				
			} catch (JSONException ex){
				System.out.println("Arguments are invalid. Arguments: " + getArguments(arguments)
						+ ". A JSON array is expected for this attribute: " + attributeName);
			}
 
		}
//		else if(isAttribute(nextArgument)){	
//			try{
//				nextObject = jsonObject.getJSONObject(attributeName);
//				nextStartIndex += 1;
//			}  catch (JSONException ex){
//				System.out.println("Arguments are invalid. Arguments: " + getArguments(arguments)
//						+ ". A JSON object is expected for this attribute: " + attributeName);
//			}
//		}
		
		if(nextObject instanceof JSONObject)
			return getValueRecursively((JSONObject)nextObject, nextStartIndex, arguments);
		else return getLeafValue(nextObject);		//leaf value
	}
 
	private String getArguments(String[] arguments) {
		StringBuffer buffer = new StringBuffer();
		for(String s:arguments){
			buffer.append(s + " ");
		}
		return buffer.toString();
	}

	private Object getLeafValue(Object rawValue) {
		if(rawValue == null || rawValue == JSONObject.NULL)	return null;
		String value = rawValue.toString();
		StringTokenizer tokens = new StringTokenizer(value, ":");
		
		if(tokens.countTokens() > 2) return rawValue; //Not leaf value
		
		Class<?> dataType = getClass(tokens.nextToken());
		String trueValue = getTrueValue(tokens.nextToken());
		try {
			return dataType.getConstructor(String.class).newInstance(trueValue);
		} catch (InstantiationException ex){
			System.out.println("Cannot initialize Object for value: " + trueValue);
			ex.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("Cannot initialize Object for value: " + trueValue);
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("Cannot initialize Object for value: " + trueValue);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("Cannot initialize Object for value: " + trueValue);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("Cannot initialize Object for value: " + trueValue);
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("Cannot initialize Object for value: " + trueValue);
			e.printStackTrace();
		}
		return null;
	}

	private String getTrueValue(String token) {
		if(token == null) return null;
		return token.trim().substring(1, token.length()-2);
	}

	private Class<?> getClass(String token) {
		if(token == null) return null;
		String dataTypeString =  token.trim().substring(2, token.length()-1);
		try {
			return Class.forName("java.lang."+dataTypeString);
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find Class for " + "java.lang." + dataTypeString);
		}
		return null;
	}

//	private boolean isAttribute(Object next) {
//		return !isIndex(next);
//	}

	private boolean isIndex(Object next) {
		try{
			Integer.parseInt(next.toString());
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
}

