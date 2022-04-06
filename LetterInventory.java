/*
2.6.19
Description:
You add a value into the inventories, and it
puts the output into alphabetical order without
spaces or anything that is not a character.
*/

class LetterInventory{

private int size;
private int[] charData;
private String original;

   public static void main(String[] args){
     	LetterInventory inventory = new LetterInventory("<Inventory-1>");
     	LetterInventory inventory2 = new LetterInventory("<Inventory-2>");
    	 
     	LetterInventory sum = inventory.add(inventory2);
     	LetterInventory min = inventory.subtract(inventory2);
    	 
     	System.out.println("First inventory:   	" + inventory);
     	System.out.println("Second inventory:  	" + inventory2);
     	System.out.println("Added inventories: 	" + sum);
     	System.out.println("Subtacted inventories: " + min);
   }
   // Makes an inventory in a string.
   private LetterInventory(String data){
     	charData = new int[26];
     	data = data.toLowerCase();
     	original = data;
     	for(int i = 0; i < data.length(); i++){
        	if(Character.isLetter(data.charAt(i))){
           	charData[data.charAt(i) - 'a']++;
           	if(data.charAt(i) == 'q'){
              	charData['u' - 'a']++;
           	}
           	size++;
        	}
     	}
   }
   // Gets the letters in the inventory.
   private int get(char letter){
     	if(!Character.isLetter(letter))
        	throw new IllegalArgumentException("letter: " + letter);
        	return charData[Character.toLowerCase(letter) - 'a'];
   }
   // Sets the count and letters in the inventory.
   private void set(char letter, int value){
     	if(!Character.isLetter(letter) || value < 0)
        	throw new IllegalArgumentException("letter: " + letter + ", value: " + value);
        	size += value - charData[Character.toLowerCase(letter) - 'a'];
        	charData[Character.toLowerCase(letter) - 'a'] = value;
   }
   // Returns the size of the inventory.
   private int size(){
  	   return size;
   }
   // Checks to see if the inventory is empty.
   private boolean isEmpty(){
  	   return size == 0;
   }
   // Returns the characters of the inventory.
   public String toString(){
  	   String result = "[";
     	for(int i = 0; i < 26; i++){
           	for(int j = 0; j < charData[i]; j++)
               	result += (char)('a' + i);
  	   }
  	   return result + "]";
   }
   // Adds the two inventories together.
   private LetterInventory add(LetterInventory other){
     	LetterInventory sum = new LetterInventory("");
     	for(int i = 0; i < 26; i++)
        	sum.charData[i] = this.charData[i] + other.charData[i];
        	sum.size = this.size + other.size;
        	return sum;
   }
   // Subtracts one inventory from another.
   private LetterInventory subtract(LetterInventory other){
     	LetterInventory result = new LetterInventory("");
     	for(int i = 0; i < 26; i++){
        	result.charData[i] = this.charData[i] - other.charData[i];
        	if(result.charData[i] < 0)
           	return null;
           	result.size += result.charData[i];
     	}
     	return result;
   }
}




