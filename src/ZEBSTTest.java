import java.util.*;
import java.io.*;

public class ZEBSTTest<T> {

  public static void main(String [] args) throws FileNotFoundException{
    ZEBSTADT myList = new ZEBSTADT();  //create the list
    PrintWriter out = new PrintWriter("ZEFINALOutput.txt"); //create printer for outputting
    Scanner kbd = new Scanner(System.in); //scanner for input
    String word; //variable for input
    int count= 0; //counter for test

    //instruction message
    System.out.println("Please enter 6 words and press enter after each word.");

    //while loop used for adding elements until 6 words are written
    while(count <6){
    	word= kbd.next();
    	myList.add(word);
        if(myList.contains(word)){
            System.out.println("Your list not contains the word " + word+ ".");
        }
    	out.println(word);
    	count++;
    }
    //close output
    out.close();

    //message
    System.out.println("The words you wrote were written to a file." +
    		"\nthat file will now be read from and display its contents");
    //try and catch used for reading from a file using BufferedReader(easiest way to me)
  try (BufferedReader readIt = new BufferedReader(new FileReader("ZEFINALOutput.txt")))
	{
		String line;
		while ((line = readIt.readLine()) != null) {
			System.out.println(line);
		}

	} catch (IOException e) {
		//prints my own message if an exception occurs
		System.out.println("Error while trying to read file.");
	}

    
  



    System.out.println("Great, now lets go ahead and print out the manual list in different orders.");
    System.out.println("Inorder:");
    myList.printInorder();
    System.out.println();
    System.out.println("Preorder:");
    myList.printPreorder();
    System.out.println();
    System.out.println("Postorder: ");
    myList.printPostorder();
    System.out.println();
    System.out.println("Thanks for using my program. Have a great day!");

  }
}