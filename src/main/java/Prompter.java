import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Prompter {
  private Jar mJar;
  
  //CONSTRUCTORS
  
  public Prompter(Jar jar) {
    mJar = jar; 
  }
  
  //METHODS
  
  public void administratorSetup() {
  String itemType = ""; 
  int actualRandomItemsNumber;
    
  System.out.println("\nADMINISTRATOR SET UP");
  System.out.println("********************\n");

    //set actual name of items
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    do {      
      try {
        System.out.printf("Name of items in the Jar: ");
        itemType = in.readLine();
      } catch (IOException err) {
        System.out.println("Can not input from console");
      }
         
      if(itemType.equals("")) {
        System.out.println("An actual item name needs some characters, isn't it? Try again please...");
      }    
    } while(itemType.equals(""));
    
    mJar.setItemType(itemType);
    
    //set maximum number of items allowed in the jar
    String prompt = "Maximum number of " + itemType + " in the Jar: ";
    int maxItems = promptForInteger(prompt);
    mJar.setMaxItems(maxItems);    
    
    //set a random number between 1 and the maximum number allowed
    Random random = new Random();
    actualRandomItemsNumber = random.nextInt(maxItems) + 1;
    mJar.fill(actualRandomItemsNumber);
    
  }
  
  
  public void playerSetup() {     
    System.out.println("\nPLAYER");
    System.out.println("**********\n");
    System.out.printf("Your goal is to guess how many %s are in the jar\n",mJar.getItemType());
    System.out.printf("Your guess should be between 1 and %d\n",mJar.getMaxItems());
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
    try {
      System.out.printf("Ready? (press ENTER to start guessing)");
      in.readLine();
    } catch (IOException err) {
      System.out.println("Can not input from console");
    }
    System.out.printf("\n");
  }
  
 
  public void play() {      
    int guess;
    int tryNumber = 0;
    
    do {
      tryNumber++;
      guess = promptForInteger("Guess: ");           
    } while(!mJar.isSolved(guess));
  
    System.out.printf("\nCongratulations. You guessed that there are %d %s in the jar.\n",
                      mJar.getActualItemsNumber(),
                      mJar.getItemType());
    System.out.printf("It took you %d guess(es) to get it right.\n\n",tryNumber);
    
  }
   
            
            
  public int promptForInteger(String prompt) {    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int theNumber = 1;                //maxItems
    String theStringPrompted = "";        
    boolean isNotNumber;
    do {
      isNotNumber = false;
            
      try {
        System.out.printf(prompt);
        theStringPrompted = in.readLine();
      } catch (IOException err) {
        System.out.println("Can not input from console");
      }
                     
      try {
        theNumber = Integer.parseInt(theStringPrompted);
      } catch (NumberFormatException err) {
        System.out.printf("Enter a positive integer number...Try again\n");
        isNotNumber = true;
      }
      
    } while(isNotNumber);
  
  return theNumber;
  }




}