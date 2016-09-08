public class Jar {
  public String mItemType;
  public int mMaxItems;  //maximum items allowed in Jar
  public int mActualItemsNumber;  //actual random number filling the Jar
  
  //CONSTRUCTORS
  public Jar() {
    mItemType = "No type";
    mMaxItems = 5;
  }
  
  public Jar(String itemType, int maxItems) {
    mItemType = itemType;
    mMaxItems = maxItems;  
  }
  
  //SETTERS
  public void setItemType(String itemType) {
    mItemType = itemType;  
  }
  
  public void setMaxItems(int maxItems) {
    mMaxItems = maxItems;
  }
  
  public void setActualItemsNumber(int actualItemsNumber) {
    mActualItemsNumber = actualItemsNumber;
  }
  
  //GETTERS
  
  public String getItemType() {
    return mItemType;
  }
  
  public int getMaxItems() {
    return mMaxItems;
  }
  
  public int getActualItemsNumber() {
    return mActualItemsNumber;
  }
  
  //METHODS
  
  public boolean isSolved(int guess) {
    return mActualItemsNumber == guess;
  }





}