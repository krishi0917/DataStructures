package Arrays;

public class MyArray {
	
	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	public void generateRandomArray(){
		for(int i=0; i<arraySize; i++){
			theArray[i] = (int)(Math.random()*10)+10;
		}
	}
	
	public void printArray(){
		for(int i=0; i<arraySize; i++){
			System.out.println("----------");
			System.out.print("| "+ i + " | ");
			System.out.println(theArray[i]+ " |");
		}
	}
	
	public int getValueAtIndex(int index){
		
		return (index<arraySize) ? theArray[index] : 0;
	}
	
	public boolean isValuePresent(int value){
		boolean op = false;
		for(int i=0; i<arraySize; i++){
			if (theArray[i] == value)
				op =true;
		}
		return op;
	}
	
	public void deleteIndex(int index){
		if(index<arraySize){
			for (int i=index; i<arraySize-1; i++){
				theArray[i] = theArray[i+1];
			}
			arraySize--;
		}
	}
	
	public void insertValue(int value){
		if(arraySize<50){
			theArray[arraySize]= value;
			arraySize++;
		}
		
	}
	
	public String linerSearch(int value){
		boolean isValue = false;
		String valueLoc = "";
		for(int i=0; i<arraySize; i++){
			if(theArray[i] == value){
				isValue = true;
				valueLoc += i + " ";
			}
			printHorzArray(i, -1);

		}
		if(!isValue){
			System.out.println();
			valueLoc = "None";
		}
		System.out.println("Index(s) with value "+ value + "--" + valueLoc);
		return valueLoc;
	}
	
	public void printHorzArray(int i, int j){
        
        for(int n = 0; n < 51; n++)System.out.print("-");
         
        System.out.println();
         
        for(int n = 0; n < arraySize; n++){
             
            System.out.print("| " + n + "  ");
             
        }
         
        System.out.println("|");
         
        for(int n = 0; n < 51; n++)System.out.print("-");
         
        System.out.println();
         
        for(int n = 0; n < arraySize; n++){
             
            System.out.print("| " + theArray[n] + " ");
             
        }
         
        System.out.println("|");
         
        for(int n = 0; n < 51; n++)System.out.print("-");
         
        System.out.println();
         
        // END OF FIRST PART
         
         
        // ADDED FOR BUBBLE SORT
         
        if(j != -1){
         
            // ADD THE +2 TO FIX SPACING
             
            for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
             
            System.out.print(j);
             
        }
         
         
        // THEN ADD THIS CODE
         
        if(i != -1){
             
            // ADD THE -1 TO FIX SPACING
             
            for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");
             
            System.out.print(i);
             
        }
         
        System.out.println();
      }
	
	/**
	 * bubble sort just compares the next element and swaps it with the next
	 * and pushes the biggest element to the last at every rotation.
	 */
	public void bubbleSort(){
		
		for(int i=arraySize-1; i>1;i--){
			
			for(int j=0; j<i; j++){
				if (theArray[j] > theArray[j+1]){
					swapValue(j,j+1);
				}
			printHorzArray(i, j);
			}
		}
	}
	
	public void swapValue(int x, int y){
		int i = theArray[x];
		theArray[x] = theArray[y];
		theArray[y] = i;
		
	}
	/**
	 * The binary search works only on sorted array
	 * @param value
	 */
	
	public void binarySearch(int value){
		int lowIndex =0;
		int highIndex = arraySize-1;
		while(lowIndex<=highIndex){
			
			//get the middle index
			int middleIndex = (lowIndex + highIndex)/2;
			
			//i.e the value is in upper half
			if(theArray[middleIndex] < value) lowIndex = middleIndex +1;
			//i.e the value is in lower half
			else if(theArray[middleIndex] > value)highIndex = middleIndex -1;
			else{
				System.out.println("The value is present at " + middleIndex);
				lowIndex = highIndex +1; // to break the loop
			}
			
			printHorzArray(middleIndex, -1);
			
		}
		
		
	}
	
	public void selectionSort(){
		for(int i=0; i<arraySize; i++){
			int min =i;
			for(int j=i;j<arraySize;j++){
				if (theArray[j]<theArray[min]){
					min = j;
				}
			}
			swapValue(i, min);
			printHorzArray(i, -1);
		}
	}
	
	public void insertionSort(){
		for (int i=0; i<arraySize; i++){
			int element = theArray[i];
			int j = i;
			while((j>0) && (theArray[j-1]>element)){
				theArray[j] = theArray[j-1];
				j--;
				
				printHorzArray(i, j);
			}
			theArray[j] = element;
			
			printHorzArray(i, j);
			System.out.println("\ntheArray[i] = "+ theArray[i] + "\ntheArray[j] = "+ theArray[j]
					+ "\nInsert element = "+ element);
			
		}
	}
	
	/*public void qiuckSort(){
		
		int pivot = 
		
	}*/
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArray arr =  new MyArray();
		arr.generateRandomArray();
		/*//arr.printArray();
		System.out.println("value at 2 " +arr.getValueAtIndex(2));
		System.out.println("Is value present "+ arr.isValuePresent(18));
		arr.deleteIndex(3);
		//arr.printArray();
		arr.insertValue(20);
		//arr.printArray();
		arr.linerSearch(10);*/
		arr.bubbleSort();
		//arr.insertionSort();
		arr.binarySearch(15);
	
	}

}
