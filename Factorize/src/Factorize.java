
import java.math.*;
public class Factorize {
	
	public static void printfact(int num, int orig, String val){
        int temp=0;
        for(int i=1;i<=num/2;i++){
            if(num % i == 0){
            	temp = num/i;
            	if (isPrime(i)){
            		int output = 1;
            		String[] arr = (val + temp + "X" + i).split("X");
            		
            		for (int j =0; j<arr.length; j++){
            			//System.out.println(arr[j]);
            			output = output * Integer.parseInt(arr[j]);
            		}
            		if(output == orig)
            		System.out.println(val + temp + "X" + i);
            		//System.out.println( val + temp + "X" + i);
            		
            	}
            	else{
            		val = Integer.toString(temp) + "X";
            		printfact(i, orig, val);
            		
            	}
            }
         //   System.out.println();
            
        }
               
}
	 
	
	static boolean isPrime(int n){
         for(int i=2;i<n;i++) {
             if(n%i==0)
                 return false;
         }
         return true;
     }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printFactors2(12,"",12);
		Factorize.printfact(32, 32, "");
		//Factorize.printPrimeNumbers(12);

	}

}
