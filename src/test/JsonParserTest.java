package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import parser.BullseyeResponseParser;
/**
 * 
 */

/**
 * @author wenbyuan
 * 
 */
public class JsonParserTest {
	private static final String VALID_JSON_STRING_4 = "{   \"UserId\": {\"Long\": \"220004196612\"},   \"ModelId\": {\"Integer\":\"Value\"},   \"MaritalStatus\": { \"String\": \"Single\" },   \"ChildrenNumber\": { \"Integer\": \"Value\" },   \"EstimatedIncome \": { \"String\": \"Value\" },   \" Gender \": { \"String\": \"Value\" },   \" Occupation \": { \"String\": \"Value\" },   \" VBSSegment \": { \"String\": \"Value\" },   \" Age\": { \"Integer\": \"Value\" },   \" Zipcode \": { \"String\": \"Value\" },   \" LastCategoriesAccessed \":   [     { 	  \"timestamp\": {\"Long\":\"Value\"},       \"categoryId\":{\"Integer\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     { 	  \"timestamp\": {\"Long\":\"Value\"},       \"categoryId\":{\"Integer\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     { 	  \"timestamp\": {\"Long\":\"Value\"},       \"categoryId\":{\"Integer\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     { 	  \"timestamp\": {\"Long\":\"Value\"},	       \"categoryId\":{\"Integer\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     { 	  \"timestamp\": {\"Long\":\"Value\"},	       \"categoryId\":{\"Integer\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     { 	  \"timestamp\": {\"Long\":\"Value\"},       \"categoryId\":{\"Integer\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     { 	  \"timestamp\": {\"Long\":\"Value\"},       \"categoryId\":{\"Integer\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     { 	  \"timestamp\": {\"Long\":\"Value\"},       \"categoryId\":{\"Integer\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     { 	  \"timestamp\": {\"Long\":\"Value\"},       \"categoryId\":{\"Integer\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     { 	  \"timestamp\": {\"Long\":\"Value\"},       \"categoryId\":{\"Integer\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     }       ],   \"LastQueriesUsed\":   [     { 	  \"timestamp\": {\"Long\":\"Value\"},	       \"aisle\":{\"String\":\"Value\"},       \"aspects\": [         {           \"aspect\":{\"String\":\"Value\"},           \"values\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}           ]         }       ],       \"categoryId\": {\"Integer\":\"Value\"},       \"department\": {\"String\":\"Value\"},       \"keywords\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}       ],       \"productType\": {\"String\":\"Value\"}     },     { 	  \"timestamp\": {\"Long\":\"Value\"},	       \"aisle\":{\"String\":\"Value\"},       \"aspects\": [         {           \"aspect\":{\"String\":\"Value\"},           \"values\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}           ]         }       ],       \"categoryId\": {\"Integer\":\"Value\"},       \"department\": {\"String\":\"Value\"},       \"keywords\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}       ],       \"productType\": {\"String\":\"Value\"}     }, 	{ 	  \"timestamp\": {\"Long\":\"Value\"},	       \"aisle\":{\"String\":\"Value\"},       \"aspects\": [         {           \"aspect\":{\"String\":\"Value\"},           \"values\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}           ]         }       ],       \"categoryId\": {\"Integer\":\"Value\"},       \"department\": {\"String\":\"Value\"},       \"keywords\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}       ],       \"productType\": {\"String\":\"Value\"}     }, 	{ 	  \"timestamp\": {\"Long\":\"Value\"},	       \"aisle\":{\"String\":\"Value\"},       \"aspects\": [         {           \"aspect\":{\"String\":\"Value\"},           \"values\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}           ]         }       ],       \"categoryId\": {\"Integer\":\"Value\"},       \"department\": {\"String\":\"Value\"},       \"keywords\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}       ],       \"productType\": {\"String\":\"Value\"}     }, 	{ 	  \"timestamp\": {\"Long\":\"Value\"},	       \"aisle\":{\"String\":\"Value\"},       \"aspects\": [         {           \"aspect\":{\"String\":\"Value\"},           \"values\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}           ]         }       ],       \"categoryId\": {\"Integer\":\"Value\"},       \"department\": {\"String\":\"Value\"},       \"keywords\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}       ],       \"productType\": {\"String\":\"Value\"}     }, 	{ 	  \"timestamp\": {\"Long\":\"Value\"},	       \"aisle\":{\"String\":\"Value\"},       \"aspects\": [         {           \"aspect\":{\"String\":\"Value\"},           \"values\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}           ]         }       ],       \"categoryId\": {\"Integer\":\"Value\"},       \"department\": {\"String\":\"Value\"},       \"keywords\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}       ],       \"productType\": {\"String\":\"Value\"}     }, 	{ 	  \"timestamp\": {\"Long\":\"Value\"},	       \"aisle\":{\"String\":\"Value\"},       \"aspects\": [         {           \"aspect\":{\"String\":\"Value\"},           \"values\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}           ]         }       ],       \"categoryId\": {\"Integer\":\"Value\"},       \"department\": {\"String\":\"Value\"},       \"keywords\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}       ],       \"productType\": {\"String\":\"Value\"}     }, 	{ 	  \"timestamp\": {\"Long\":\"Value\"},	       \"aisle\":{\"String\":\"Value\"},       \"aspects\": [         {           \"aspect\":{\"String\":\"Value\"},           \"values\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}           ]         }       ],       \"categoryId\": {\"Integer\":\"Value\"},       \"department\": {\"String\":\"Value\"},       \"keywords\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}       ],       \"productType\": {\"String\":\"Value\"}     }, 	{ 	  \"timestamp\": {\"Long\":\"Value\"},	       \"aisle\":{\"String\":\"Value\"},       \"aspects\": [         {           \"aspect\":{\"String\":\"Value\"},           \"values\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}           ]         }       ],       \"categoryId\": {\"Integer\":\"Value\"},       \"department\": {\"String\":\"Value\"},       \"keywords\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}       ],       \"productType\": {\"String\":\"Value\"}     }, 	{ 	  \"timestamp\": {\"Long\":\"Value\"},	       \"aisle\":{\"String\":\"Value\"},       \"aspects\": [         {           \"aspect\":{\"String\":\"Value\"},           \"values\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}           ]         }       ],       \"categoryId\": {\"Integer\":\"Value\"},       \"department\": {\"String\":\"Value\"},       \"keywords\": [             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"},             {\"String\": \"Value\"}       ],       \"productType\": {\"String\":\"Value\"}     }   ],   \" LastSellersViewed \":   [     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	} 	   ],   \" LastSellersPurchasedFrom \":   [    { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	}   ],   \" LastSellersBidOn \":   [     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	},     { 		\"timestamp\": {\"Long\":\"Value\"}, 		\"sellerId\": {\"Long\":\"Value\"} 	}   ],   \"LastItemsPurchased\":   [     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timestamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timestamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timestamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timestamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timestamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timestamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timestamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timestamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timestamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timestamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     }   ],   \" LastItemsViewedDetails \":   [     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     }   ],   \" LastItemsWatched \":   [     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     }   ],   \" LastItemsBidOn \":   [     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     },     {       \"categoryId\":{\"Integer\":\"Value\"},       \"timeStamp\":{\"Long\":\"Value\"},       \"itemId\":{\"Long\":\"Value\"},       \"siteId\":{\"Integer\":\"Value\"}     }   ] } ";	
	private static final String VALID_JSON_STRING_2 = "{\"UserId\":{\"String\":\"1255968146\"},\"ModelId\":{\"Integer\":330},\"Age\":null,\"ChildrenNumber\":null,\"MaritalStatus\":null,\"Gender\":null,\"Zipcode\":null,\"EstimatedIncome\":null,\"Occupation\":null,\"VBSSegment\":null,\"LastItemsViewed\":[],\"LastItemsWatched\":[],\"LastItemsBidOn\":[{\"categoryId\":null,\"siteId\":null,\"itemId\":{\"Long\":130006898762},\"timestamp\":{\"Long\":1405981641000}},null,null],\"LastItemsPurchased\":[{\"categoryId\":null,\"siteId\":null,\"itemId\":{\"Long\":130006898762},\"timestamp\":{\"Long\":1405981641000}}],\"LastSellersBidOn\":[{\"sellerId\":{\"Long\":1255968141},\"timestamp\":{\"Long\":1405981641000}}],\"LastSellersPurchasedFrom\":[{\"sellerId\":{\"Long\":1255968141},\"timestamp\":{\"Long\":1405981641000}}],\"LastSellersViewed\":[],\"LastCategoriesAccessed\":[],\"LastQueriesUsed\":[]}";
	private static final String VALID_JSON_STRING_1 = "{\"UserId\":{\"String\":\"1255968146\"},\"ModelId\":{\"Integer\":330},\"Age\":null,\"ChildrenNumber\":null,\"MaritalStatus\":null,\"Gender\":null,\"Zipcode\":null,\"EstimatedIncome\":null,\"Occupation\":null,\"VBSSegment\":null,\"LastItemsViewed\":null,\"LastItemsWatched\":null,\"LastItemsBidOn\":[{\"categoryId\":null,\"siteId\":null,\"itemId\":{\"Long\":130006898762},\"timestamp\":{\"Long\":1405981641000}}],\"LastItemsPurchased\":[{\"categoryId\":null,\"siteId\":null,\"itemId\":{\"Long\":130006898762},\"timestamp\":{\"Long\":1405981641000}}],\"LastSellersBidOn\":[{\"sellerId\":{\"Long\":1255968141},\"timestamp\":{\"Long\":1405981641000}}],\"LastSellersPurchasedFrom\":[{\"sellerId\":{\"Long\":1255968141},\"timestamp\":{\"Long\":1405981641000}}],\"LastSellersViewed\":null,\"LastCategoriesAccessed\":null,\"LastQueriesUsed\":null}";
	private static final String[] INVALID_JSON_STRINGS = 
	{
		"",
		"ASDF",
	};
	private static final String[][] INVALID_ARGUMENTS = 
	{
		{null},
		{""},
		{","},
		{"ASDF"},
		{"node","1","1","1","2","label"},
		{"catHistogram","cat","map","15709"},
		{"LastQueriesUsed","aspects"},
		{"LastQueriesUsed","2","3"},
		{"LastQueriesUsed","2","department","2"},
	};
	
	private static final String[][] VALID_ARGUMENTS = {
		{"UserId"},
		{"MaritalStatus"},
		{"LastItemsBidOn","0"},
		{"LastItemsBidOn","1", "anything"},
		{"LastQueriesUsed"},
		{"LastQueriesUsed","2"},
		{"LastQueriesUsed","2", "aspects"},
		{"LastQueriesUsed","2","aspects","0","values"},
		{"LastQueriesUsed","2","aspects","0","values","3"},
		{"LastQueriesUsed","2", "department"}
	};
	
	BullseyeResponseParser helper1;
	BullseyeResponseParser helper2;
	BullseyeResponseParser helper4;
	
	@Before
	public void setUp() throws JSONException{
		helper1 = new BullseyeResponseParser(VALID_JSON_STRING_1);
		helper2 = new BullseyeResponseParser(VALID_JSON_STRING_2);
		helper4 = new BullseyeResponseParser(VALID_JSON_STRING_4);
	} 
	
	@Test
	public void testGetValue() {
		for(int i = 0; i < VALID_ARGUMENTS.length; i++) {
			System.out.println( helper1.getValue(VALID_ARGUMENTS[i]) );
		}
	}
	
//	@Test
	public void testGetValue2() {
			String[] arguments = {"UserId"};
			assertEquals("1255968146", helper2.getValue(arguments));
			
			String[] arguments_1 = {"MaritalStatus"};
			assertNull(helper2.getValue(arguments_1));
			
			String[] arguments_7 = {"LastItemsBidOn","3", "anthing"};
			assertNull(helper2.getValue(arguments_7));
			
			String[] arguments_10 = {"LastQueriesUsed"};
			assertNull(helper2.getValue(arguments_10));

			String[] arguments_2 = {"LastQueriesUsed","2"};
			System.out.println(helper2.getValue(arguments_2));
			
			String[] arguments_3 = {"LastQueriesUsed","2", "aspects"};
			System.out.println(helper2.getValue(arguments_3));
			
			String[] arguments_4 = {"LastQueriesUsed","2","aspects","0","values"};
			System.out.println(helper2.getValue(arguments_4));
			
			String[] arguments_5 = {"LastQueriesUsed","2","aspects","0","values","3"};
			System.out.println(helper2.getValue(arguments_5));
			
			String[] arguments_6 = {"LastQueriesUsed","2", "department"};
			System.out.println(helper2.getValue(arguments_6));
	}
	
//	@Test
	public void testGetValue4() {
			String[] arguments = {"UserId"};
			assertEquals(220004196612L, helper4.getValue(arguments));
			
			String[] arguments_1 = {"MaritalStatus"};
			assertEquals("Single", helper4.getValue(arguments_1));
			
			String[] arguments_10 = {"LastQueriesUsed"};
			assertNotNull(helper4.getValue(arguments_10));
			
			String[] arguments_2 = {"LastQueriesUsed","2"};
			System.out.println(helper4.getValue(arguments_2));
			
			String[] arguments_3 = {"LastQueriesUsed","2", "aspects"};
			System.out.println(helper4.getValue(arguments_3));
			
			String[] arguments_4 = {"LastQueriesUsed","2","aspects","0","values"};
			System.out.println(helper4.getValue(arguments_4));
			
			String[] arguments_5 = {"LastQueriesUsed","2","aspects","0","values","3"};
			System.out.println(helper4.getValue(arguments_5));
			
			String[] arguments_6 = {"LastQueriesUsed","2", "department"};
			System.out.println(helper4.getValue(arguments_6));
	}
	
//	@Test
	public void testInitializationInvaidInput() throws JSONException{
		ArrayList<BullseyeResponseParser> list = 
		new ArrayList<BullseyeResponseParser>();
		for(int i = 0; i < INVALID_JSON_STRINGS.length; i++){
			list.add( new BullseyeResponseParser(INVALID_JSON_STRINGS[i]) );
		}
	}
	
//	@Test
	public void testGetValueInvalidArguments(){
		for(int i = 0; i < INVALID_ARGUMENTS.length; i++){
			assertNull(helper4.getValue(INVALID_ARGUMENTS[i]));
		}
	}
}

