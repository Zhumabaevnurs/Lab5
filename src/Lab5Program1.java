import javax.swing.*;
/**
 * 
 * @author Nursultan Zhumabaev
 * @version 1
 * @lab 11E
 * @description: check if the user input is in the word array or not
 * 
 */

public class Lab5Program1 {
	static int counter = 0; // used to count the number of lines
	public static void main(String[] args) {
		//java wordArray[0]
		String[] wordArray=inputFromFile("lab5input.txt"); //read from file
		
		/*
		 * The following loop will repeatedly
		 * ask the user input the word
		 */
		String isOrIsNot, inputWord;
		while(true) { //infinite loop
			
		
		//this line asks the user for input by popping out a single window with text input
		inputWord =JOptionPane.showInputDialog(null, "Enter a word in all lower case:");
		if(inputWord.equalsIgnoreCase("STOP")) {
			System.exit(0); //terminate the program do not use "break"
		}
		
		//if the inputWord is contained within wordArray return true
		if(wordIsThere(inputWord, wordArray))
			isOrIsNot="is"; //set to is if the word is no the list
		else
			isOrIsNot="is not"; // set to is not if the word is not on the list
		
		//Output to a JOptionPane window whether the word is on the list or not
		JOptionPane.showMessageDialog(null, "The word "+inputWord+" "+isOrIsNot+" on the list.");
		}//while loop paranthese
	} //main 
	
	/**
	 * use TextFileInput class to read from file and fill in the array
	 * @param fileName: the input file, lab5input.txt
	 * @return return the filled in array
	 */
	
	public static String[] inputFromFile(String fileName) {
		//create an object of TextFileInput by calling the constructor 
		TextFileInput tfi= new TextFileInput(fileName);
		String line=tfi.readLine(); //return the first line
		String[] array = new String[20];
		int i=0;
		while(line!=null) { // keep reading from the file until the end
			array[i++]=line;// put the first word into the first position of the array
			line=tfi.readLine(); //Read the next line
			counter++;
		}
		return array;
	}
	
	/**
	 * check if the user input is in the arrray or not
	 * @param findMe: user input
	 * @param theList: word array
	 * @return: return true if the user input is in the array, otherwise return dalse
	 */
	
	public static boolean wordIsThere(String findMe, String[] theList) {
		for(int i=0; i<counter; i++) { //counter is the actual number of words in the array
			if(findMe.equals(theList[i])){
				return true;
			}
				
		}
		return false;
		
	} // wordIsThere
} // class Lab4 