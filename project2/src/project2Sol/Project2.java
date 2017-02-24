package project2Sol;

import java.util.StringTokenizer;

import project2Sol.TextFileInput;
public class Project2 {
	       // main application
	public static void main(String[] args) {
		
	    Database db = new Database("database2.txt"); // read database.txt file and save in Database class
		TextFileInput trans = new TextFileInput("transactions2.txt");// open transaction file for reading TextFileInput
		String readline = null;
		String receipt = "RECEIPT for transactions\n"; // declare a variable receipt as RECEIPT for transactions
		receipt += " Name\t" + "Unit Price\t" + "Weight\t"+"Price\n"; // continue the variable receipt as Name followed by Unit Price followed by weight and followed by price
		float totalPrice = 0.0f; // declare the totalPrice variable as float type
		while ((readline = trans.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(readline, ",");
			String code = tokenizer.nextToken();// in transaction file, the first token is item's code and save as item's code
			// String type = db.getType(code); // using this code to get type of this item and save as item's type
			String name = db.getName(code); // using this code to get name of this item and save as item's name
			if (name == null) { // using the name is null by searing this code, then print a message saying No found produce item with this code, Otherwise continue 
				System.out.println("No found produce item with this " + code);
				continue;
			}
			float price = 0.0f;
			try { // throws exceptions
				price = db.getPrice(code);
			} catch (Exception e) {
				// should not reach here because it already is checked by name
				System.out.println("No found! " + e.getMessage());
				continue;
			}
			 String strWeight = tokenizer.nextToken(); // the next token in transaction file of each line is item's weight, since token is String type and weight needs Float type,
			 float weight = Float.parseFloat(strWeight); // using parseFloat convert token from String type into float type and save as item's weight
			 float subPrice = weight * price; // the item's price = weight times price
			 float itemPrice = Math.round(subPrice*100)/100.0f; // round the itemPrice to 2 decimals.
			 totalPrice += itemPrice; // the total costs of items = the sum of all the item's price
			 receipt += name +"\t"+ price + "\t " + strWeight + "\t " + itemPrice + "\n"; // continue receipt which is used to display in GUI, as one per line, the name, price, weight and total cost of each item.
		}
	
		new ReceiptGUI("ItemReceitpt", 600, 400, receipt, totalPrice); //receipt GUI
	   
		
	}

}