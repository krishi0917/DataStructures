package Arrays;

import java.lang.reflect.Array;
import java.util.HashSet;

import javax.xml.soap.SAAJMetaFactory;

public class GeeksForGeeks {
	
	public int[] generateRandomArray(int arraySize){
		int[] theArray = new int[arraySize];
		for(int i=0; i<arraySize; i++){
			theArray[i] = (int)(Math.random()*10)+10;
		}
		return theArray;
	}
	
public void bubbleSort(int[] a){
		
		for(int i=a.length -1; i>1;i--){
			
			for(int j=0; j<i; j++){
				if (a[j] > a[j+1]){
					swap(a, j,j+1);
				}
			//printHorzArray(i, j);
				
			}
			print(a);
		}
	}
	
	public String[][] generateRandomMultiArray(int i, int j){
		String[][] arr = new String[i][j];
		//int func = 37;
		
		for(int p=0; p<i; p++){
			for (int q=0; q<j; q++){
				if (((int)(Math.random()*10)+10)%3 == 0 ){
					arr[p][q] = "O";
				}
				else{
					arr[p][q] = "X";
				}
			}
		}
		
		return arr;
	}
	
	public int[][] generateRandomMultiArrayInt(int i, int j){
		int[][] arr = new int[i][j];
		//int func = 37;
		
		for(int p=0; p<i; p++){
			for (int q=0; q<j; q++){
				if (((int)(Math.random()*10)+10)%3 == 0 ){
					arr[p][q] = 0;
				}
				else if(((int)(Math.random()*10)+10)%3 == 1){
					arr[p][q] = 1;
				}
				else{
					arr[p][q] = 2;
				}
			}
		}
		
		return arr;
	}
	
	
	public void print(int[] a){
		for (int i=0; i<a.length; i++){
			System.out.print(" " + a[i] + " |");
		}
	}
	public void print(String[] a){
		for (int i=0; i<a.length; i++){
			System.out.print(" " + a[i] + " |");
		}
	}
	
	public void print(String[][] a){
		for(int i=0; i < a.length; i++){
			for(int j=0; j<a[1].length; j++){
				if(j==0){
					System.out.print("|");
				}
				System.out.print(a[i][j] + " |");
			}
			System.out.println();
		}
	}
	
	public void print(int[][] a){
		for(int i=0; i < a.length; i++){
			for(int j=0; j<a[1].length; j++){
				if(j==0){
					System.out.print("|");
				}
				System.out.print(a[i][j] + " |");
			}
			System.out.println();
		}
	}
	/**
	 * Question1: 
	 * Given an unsorted array that may contain duplicates. Also given a number k which 
		is smaller than size of array. Write a function that returns true if array contains 
		duplicates within k distance.
		
		Solution:
		We are approaching with iterating till K  and adding the values to the set
		here the time complexity is O(K) and auxiliary space complexity is O(k)
	 */
	
	public boolean duplicateValue(int[] a, int k){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<k; i++){
			if(set.contains(a[i]))
				return true;
			else{
				set.add(a[i]);
			}
			
		}
		
		return false;
	}
	/**
	 * question2:
	 * Given a matrix where every element is either ‘O’ or ‘X’, replace ‘O’ with ‘X’ if surrounded by ‘X’. 
	 * A ‘O’ (or a set of ‘O’) is considered to be by 	 * surrounded by ‘X’ 
	 * if there are ‘X’ at locations just below, just above, just left and just right of it. 
	 * @param args
	 * Solution:
	 * 1. I first continue the loop if we are on the edges
	 * 2. Then i check if we have found O, if so i just have four pointer left, right, up and down.
	 * 3. Then i have an inner for loop which moves these pointers 
	 * in their respective direction till boundaries or till we have found the element "X"
	 * 4. If we find X for all the four pointers, i set their boolean value to true 
	 * and repllace the element "O" with "X"
	 * 
	 */
	public void replaceOwithX(String[][] sArr){
		
		for(int i =0; i<sArr.length; i++){
			for(int j = 0; j<sArr[1].length; j++){
				if(i==0 || j==0 || i==sArr.length-1 ||  j==sArr[1].length-1)
					continue;
				
				if(sArr[i][j].equals("O")){
					boolean bP=false, bQ=false, bR =false, bS =false;
					for(int p=j-1, q=j+1,r=i-1,s=i+1;p<=0 || q<sArr[1].length-j || r<=0 || s<sArr.length-i;p--,q++,r--,s++){
						
						if(p>=0 && sArr[i][p].equals("X")){
							bP = true;
						}
						if(q < sArr[1].length && sArr[i][q].equals("X")){
							bQ = true;
						}
						if(r>=0 && sArr[r][j].equals("X")){
							bR = true;
						}
						if(s<sArr.length && sArr[s][j].equals("X")){
							bS = true;
						}
						if(bP == true && bQ ==true && bR == true && bS ==true){
							sArr[i][j] = "X";
							break;
						}
					}
				}
			}
		}
	}
	
	/**
	 * Quesiton: 
	 * Given a binary string, count number of substrings that start and end with 1. For example, 
	 * if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
	 * 1. First we'll convert the string to array
	 * 2.create two for loops
	 */
	public String[] stringStartEndwith1(String s){
		int count = 0;
		String result1 = "";
		String result[] = new String[s.length()];
		String[] sArr = s.split("");
		for(int i=0; i< sArr.length; i++){
			
			if(sArr[i].equals("1")){
				result1 = result1 + sArr[i];
				for(int j=i+1; j<sArr.length; j++){
					String jVal = sArr[j];
					result1 = result1+jVal;
					if(jVal.equals("1")){
						result[count] = result1;
						count++;
						//result1 = "";
						break;
					}
				}
			}
			
		}
		return result;
	}
	//  "100100110"
	
	public void swap(int[] arr, int i, int j){
		arr[i] = arr[i] - arr[j];
		arr[j] = arr[i] + arr[j];
		arr[i] = arr[j] - arr[i];
	}
	
	/**
	 * Question 4:
	 * 
	 * Given an unsorted array of integers, sort the array into a wave like array. 
	 * An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
	 * 
	 * My approach:
	 * sort the array and swap two values in the pair of two i.e loop incrementing with i+2
	 * **Below is some different approach using XOR operator.
	 */
	public void waveArray(int[] arr){
		int[] result = new int[arr.length];
		int f = 0;
		for(int i=1; i<arr.length; i++){
		if(f==1){
			
				if(arr[i] < arr[i-1]){
					arr[i] = arr[i] - arr[i-1];
					arr[i-1] = arr[i] + arr[i-1];
					arr[i] = arr[i-1] - arr[i];
				}
		}
			else 
				{
				if(arr[i]>arr[i-1]){
					arr[i] = arr[i] - arr[i-1];
					arr[i-1] = arr[i] + arr[i-1];
					arr[i] = arr[i-1] - arr[i];
				
					}
				}
			f = f^1;
		}
		print(arr);
		
	}
	/**	 * 
	 * Quicksort
	 * This is a recursive algorithm avag complexity: O(nlogn) worst: O(n2)
	 * There are two approached for this algorithm Partition:
	 * 1. choose the end element as pivot
	 *    place the pIndex at start and start a loop from start to end-1
	 *    check if the value at i is <= pivot, swap i and pIndex
	 *    After the loop ends swap pIndex and pivot and this will have an array where 
	 *    elements less than pivot are at its left and greater at its right.
	 *    
	 * 2. Second approach is to choose any median value as pivot and place two pointers
	 *    one at the beginning and one at the end
	 *    run a for loop from start to end
	 *    run two while loops. one while i < pivot value i++ and one while j> pivot value j++
	 *    swap the values at i and j
	 *    end the loop when  i >= j
	 *    
	 */
	
	//Approach 1
	public int partition(int[] a, int start, int end){
		int pivot = a[end];
		int pIndex = start;
		int temp =0;
		for(int i=start; i<end; i++){
			if(a[i]<=pivot){
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		//Swapping pIndex and Pivot
	
		a[end] = a[pIndex];
		a[pIndex] = pivot;
		
		
		return pIndex;
		
	}
	
	
	
	public void quickSort(int[] a, int start, int end){
		if(start<end){
			int pIndex = partition(a, start, end);
			quickSort(a, start, pIndex-1);
			quickSort(a, pIndex+1, end);
		}
		//print(a);
	}
	
	
	
	/**
	 * Question 5:
	 * In MS-Paint, when we take the brush to a pixel and click, 
	 * the color of the region of that pixel is replaced with a new selected color. 
	 * Following is the problem statement to do this task.
	 * Given a 2D screen, location of a pixel in the screen and a color, 
	 * replace color of the given pixel and all adjacent same colored pixels with the given color
	 */
	//g.fillColor(arr, 3, 2, 5);
	public void fillColor(int[][] a, int x, int y, int c){
		int left = 0, right=0, up=0, down=0;
		if(x<0 || x>= a.length || y<0 || y > a[1].length)
			return;
		//System.out.println(a.length + "  " + a[1].length);
		a[x][y] = c;
		if (x<a.length-1){
			down = x+1;
			a[down][y] = c;
			
			System.out.println(down);
		}
		if(x>0){
			up = x-1;
			a[up][y] = c;
			System.out.println(up);
		}
		if(y>0){
			left = y-1;
			a[x][left] = c;
			System.out.println(left);
		}
		if(y<a[1].length-1){
			right = y+1;
			a[x][right] = c;
			System.out.println(right);
		}
		
		
	}
	/**
	 * Question 6:
	 * find the Kth largest element
	 */
	public void quickSelect(int[] a, int start , int end, int k){
		
		if(start<end){
			int pIndex = partition(a, start, end);
			if(pIndex == a.length-k){
				System.out.println("Kth element is " + a[pIndex]);
				return;
			}
			quickSort(a, start, pIndex-1);
			quickSort(a, pIndex+1, end);
		}
	}
	
	/**
	 * Question 7: Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get
	 *  longest continuous sequence of 1s. 
	 * Expected time complexity is O(n) and auxiliary space is O(1).
	 */
	
	public int positionOfZero(int[] arr){
		int beforePrev = -1;
		int prev = -1;
		int curr = 0;
		int max = 0;
		int maxindex = -1;
		int count = 0;
		
		for (int i=0; i< arr.length; i++){
			if (arr[i]==0){
				count++;
				if(count > 1){
					beforePrev = prev;
					prev = curr;
					curr = i;
					int diff = curr - beforePrev -1;
					if(diff > max){
						maxindex = prev;
						max = diff;
					}
					
				}
				else{
					curr = i;
				}
			}
			if(count <= 1 && i == arr.length-1){
				return curr;
			}
			else if(i == arr.length-1){
				beforePrev = prev;
				prev = curr;
				curr = i;
				int diff = curr - beforePrev;
				if(diff>max){
					maxindex = prev;
					max = diff;
				}
				
			}
		} 
		
		
		return maxindex;
	}
	

}
