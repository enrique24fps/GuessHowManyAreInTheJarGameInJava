import java.io.Console;
import java.util.Random;

public class Prompter {
  private Jar mJar;
  
  //CONSTRUCTORS
  
  public Prompter(Jar jar) {
    mJar = jar; 
  }
  
  //METHODS
  
  public void administratorSetup() {
  Console console = System.console();
  String itemType; 
  int actualRandomItemsNumber;
    
  System.out.println("\nADMINISTRATOR SET UP");
  System.out.println("********************\n");

    //set actual name of items
    do {
      itemType = console.readLine("Name of items in the Jar: ");    
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
    mJar.setActualItemsNumber(actualRandomItemsNumber);
    
  }
  
  
  public void playerSetup() {
    Console console = System.console();    
    System.out.println("\nPLAYER");
    System.out.println("**********\n");
    System.out.printf("Your goal is to guess how many %s are in the jar\n",mJar.getItemType());
    System.out.printf("Your guess should be between 1 and %d\n",mJar.getMaxItems());
    console.readLine("Ready? (press ENTER to start guessing)"); 
    System.out.printf("\n");
  }
  
 
  public void play() {
    Console console = System.console();    
    int guess;
    int tryNumber = 0;
    
    do {
      tryNumber++;
      guess = promptForInteger("Guess: ");           
    } while(!mJar.isSolved(guess));
  
    System.out.printf("Congratulations. You guessed that there are %d %s in the jar.\n",
                      mJar.getActualItemsNumber(),
                      mJar.getItemType());
    System.out.printf("It took you %d guess(es) to get it right.\n",tryNumber);
    
  }
   
            
            
  public int promptForInteger(String prompt) {
    Console console = System.console(); 
    int theNumber = 1;                //maxItems
    String theStringPrompted;        
    boolean isNotNumber;
    do {
      isNotNumber = false;
      theStringPrompted = console.readLine(prompt);          
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