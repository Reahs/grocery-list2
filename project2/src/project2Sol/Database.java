package project2Sol;
import java.util.Iterator;
import java.util.StringTokenizer;

import project2Sol.TextFileInput;

public class Database {

	private static ProduceItemList pItems = new ProduceItemList(); // create a linked list of produceItem named pItems which store all the ProcudeItems in the linked list.
	
	/**
	 * Database constructor takes one argument fileName and call the method fillArray to store all the produceItems from a file
	 * @param fileName as parameter which is a source file to read
	 */

	public Database (String fileName) {
		fillArray(fileName);
	} 
	
	/**
	 * getName method will return the name of an item with a given code if found
	 * @param code as given code of the item
	 * @return the name of the item
	 */
	public String getName(String code) {
		ProduceItem item = getProduceItemByCode(code); // declare a ProduceItem item 
		if (code == null) return null; // if the given code is null, return null
		if (item == null) return null; // if the item is null, return null
		return item.getName(); // if found, return the name of the item
	
	}
	/**
	 * getPrice method will return the price of an item with a given code if found
	 * @param code as given code of the item
	 * @return the price of the item
	 * @throws Exception as Error message with No such item which code is a given code if item is null
	 */
	
	public float getPrice(String code) throws Exception {
		ProduceItem item = getProduceItemByCode(code);// declare a ProduceItem item
		if (item == null)  
			throw new Exception("No such item which code is " + code); // throws Exceptions with error message if item is null.
		return item.getPrice(); // return the price of the item if found
	}
	
	/**
	 * getType method will return the type of an item with a given code if found
	 * @param code as given code of the item
	 * @return the type of the item
	 */
	
	public String getType (String code){
		ProduceItem item = getProduceItemByCode(code);
		if (code == null) return null;
		if (item == null) return null;
		return item.getType();
	}
	
	/**
	 * getProduceItemByCode method will return ProduceItem type item with a given code if found
	 * @param code as given code of the item
	 * @return an item in a linked list of produceItemList with a given code if found otherwise return null
	 */
	private ProduceItem getProduceItemByCode(String code) {
		for (Iterator<ProduceItem> iterator = pItems.iterator(); iterator.hasNext();)
		{
			ProduceItem item = iterator.next();
			if (item.getCode().equals(code)){
				return item;
			}
		}
		return null;
	}
	
	/**
	 * fillArray method is used to store all ProduceItem item in linked list named pItems which we created in above
	 * @param myFile as reading source file
	 */
	private void fillArray(String myFile) {
		TextFileInput reader = new TextFileInput(myFile); //open the file for reading with TextFileInput
		String readline = null;
		while ((readline = reader.readLine()) != null) { // as long as the readline still have things to read, continue while loop, otherwise finish reading and jump out while loop
			StringTokenizer tokenizer = new StringTokenizer(readline, ",");//tokenize line based on "," as delimiter (separator)
			String type = tokenizer.nextToken();
			String code = tokenizer.nextToken(); // the first Token of the line is code and save this token as code

			String name = tokenizer.nextToken(); // the next token of the line is item's name and save this token as item's name
			String strPrice = tokenizer.nextToken(); // the third token of the lien is item's price, but since token is String type, we need convert String type to float type, 	                                         
			float price = Float.parseFloat(strPrice);//so we using parseFloat and convert the token from String type into float type and save as item's price
 
			if (type.equalsIgnoreCase("F")){ // if the type of item is "F" , then create a new fruit which has item's type, code, name,and price from the readline. 
			   Fruit p = new Fruit (type, code, name,price);
			    pItems.append(p); // then add the item of fruit to the linked list of pItems.
			}else {
		    	if (type.equalsIgnoreCase("V")) { // if the type of item is "V", then create a new vegetable item which has this item's type, code, name and price from the readline. 
		    		Vegetable v = new Vegetable(type,code, name,price);
		    		pItems.append(v);// then add the item of vegetable to the linked list of pItems.
		    	}
		    } 
			
		} // while loop
	} // fillArray method

} // DataBase class
