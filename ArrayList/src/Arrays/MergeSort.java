package Arrays;

public class MergeSort {

	public void mergeSort(int A[],int p){
		int n = A.length;
		if (n<2) return;
		int mid = 0;
		int[] left; // array for holding left array values
		int[] right; // array for holding right array values
		mid = n/2;
		if (n%2 == 0){
		
		left = new int[mid]; 
		right = new int[mid];
		}
		else{
			left = new int[mid]; 
			right = new int[mid+1];
		}
		
		for (int i =0; i< mid; i++){
			left[i] = A[i];
		}
		for(int i = mid,j=0; i<=n-1; i++,j++){
			right[j] = A[i];
		}
		
		//{10,2,1,7,5,8,9,6,13};
		
		mergeSort(left,p);
		
		
		
		mergeSort(right,p);
		
		//System.out.println("Right array values "+ print(right));
		merge(left, right, A);
		if (A.length == p){
			for(int k=0;k<A.length;k++){
				System.out.println(A[k]);
				}
		}
		
	}
	
	public String print(int[] arr){
		String op = "";
		for(int i=0;i<arr.length;i++){
			op = op + " "+ arr[i];
		}
		return op;
	}
	
	public int[] merge(int left[], int right[], int A[]){
		int nl = left.length;
		int rl = right.length;
		int i=0,j=0,k=0;
		/**
		 * Iterate over both the small arrays and compare individual values
		 */
		while(i< nl && j< rl){
			if (left[i] <= right[j]){
				A[k] = left[i];
				i = i+1;
			}
			else{
				A[k] = right[j];
				j=j+1;
			}	
			k=k+1;
		}
		while(i<nl){
			A[k] = left[i];
			i = i+1;k=k+1;
		}
		while(j<rl){
			A[k] = right[j];
			j=j+1;k=k+1;
		}
		
	return A;
	
	}
	
}
