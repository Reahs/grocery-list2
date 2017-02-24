package project2Sol;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReceiptGUI {
	
    public ReceiptGUI (String title, int height, int width, String re, float p){ // ReceitptGUI has four arguments,which are Jframe's title, height, width and re. re is the text which will add to text area
    	// Create and set up the windows
		JFrame frame = new JFrame(title); // set JFrame's title as title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Set close operation 
		frame.setSize(height, width); // set JFrame's size with "height" height and "width" width.
		frame.setLocation(400,200);
		frame.setLayout(new GridLayout(2,1));
		JTextArea textArea = new JTextArea(); 
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);
        JLabel label = new JLabel("            TOTAL Price: " + p ); 
        frame.getContentPane().add(label);
        textArea.setText(re);
        
    	// display the windows
    	frame.pack(); 
    	frame.setVisible(true);
     		
	}
	
}
