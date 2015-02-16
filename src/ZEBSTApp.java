import java.util.*;
import java.io.*;

public class ZEBSTApp{
  public static void main(String [] args) throws FileNotFoundException{
  Scanner kbd = new Scanner(System.in);
  int choice =0;
  int x,y,z;

  ZEBSTADT theList= new ZEBSTADT();
  
//greeting message read from txt file that I created
  try (BufferedReader readIt = new BufferedReader(new FileReader("finalIntro.txt")))
	{
		String line;
		while ((line = readIt.readLine()) != null) {
			System.out.println(line);
		}

	} catch (IOException e) {
		System.out.println("Error while trying to read file. Are you sure you uploaded the file?");
	} 
  //making space
  System.out.println();

  do{
  System.out.println("Please enter the number which correlates to the action you wish to perform" +
  "\n1.add"+
  "\n2.remove"+
  "\n3.get the size of the list"+
  "\n9. to exit and move on");
  choice = kbd.nextInt();
  if(choice ==1){
          System.out.println("Please enter the word you wish to enter:");
          String name = kbd.next();
          try{
          theList.add(name);
          System.out.println("Thanks, the name has been entered.");
        }
          catch(QueueOverflowException e){
            System.out.println("The list is full and can no longer be added to.");
          }
  }
  if(choice ==2){
          System.out.println("Please enter the name you wish to remove:");
          String name = kbd.next();
          try{
          theList.remove(name);
        }
          catch(QueueUnderflowException e){
            System.out.print("The list is empty and nothing can be removed");
          }
  }
  if(choice ==3){
          System.out.println("Okay, let's check the size." +
            "\nThe size of the list is: " + theList.size());
  }
  if(choice ==9){
    System.out.println("Exiting now!");
  }
  }while(choice !=9);

  System.out.println("Okay, let's move on!");
  do{
  System.out.println("Please enter the number which correlates to the action you wish to perform" +
  "\n1.find"+
  "\n2.find next name"+
  "\n3.reset"+
  "\n9. to exit and move on");
  choice = kbd.nextInt();
  if(choice ==1){
          System.out.println("Please enter the word you wish to find:");
          String name = kbd.next();
          System.out.println(theList.get(name));
  }
  if(choice ==2){
          System.out.println("Please enter the key number of the BST you'd like to search");
          int num = kbd.nextInt();
          try{
            System.out.println(theList.getNext(num));
          }
          catch(NullPointerException e){
            System.out.println("Sorry the tree is empty and has nothing to return.");
          }
  }
  if(choice ==3){
          System.out.println("Please choose from the following:" +
            "\n-1 for inorder" +
            "\n0 for preorder" +
            "\n1 for postorder");
          int numchoice= kbd.nextInt();
          theList.reset(numchoice);
  }

  }while(choice !=9);
 

  System.out.println("Great, now lets go ahead and print out the BST in different orders.");
  System.out.println("Inorder:");
  theList.printInorder();
  System.out.println();
  System.out.println("Preorder:");
  theList.printPreorder();
  System.out.println();
  System.out.println("Postorder: ");
  theList.printPostorder();
  System.out.println();
  System.out.println("Thanks for using my program. Have a great day!");

  }
}