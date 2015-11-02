
public class Base10 {
	public static int checkBase10(int num){
		int i = 1;
		int temp;
		String nm;
		int j;
		while(true){ //Every number will have such value so out loop will return a value at some point.
			temp = num*i;
			nm = String.valueOf(temp);
			
			for(j=0; j<nm.length(); j++){
				//System.out.println(nm.charAt(j));
				//parse the multiplied op and check if all the digits are 0 or 1
				if(nm.charAt(j) != '0' && nm.charAt(j) != '1')
					break;
				if(j == nm.length()-1)
					return temp;
			}
			i++;
			
		}
	}
	
	public static long sol2(long num){
		//int bin = Integer.parseInt(Integer.toBinaryString(num));
		long bin2 = Long.parseLong(Long.toBinaryString(num));
		for(long i = 1; i <= bin2; i++){
			String binary = Long.toBinaryString(i);
			System.out.println(Long.parseLong("-"+binary));
			if (Long.parseUnsignedLong(binary) % num == 0)
				return Long.parseLong(binary);
			
			
		}
		
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Base10.checkBase10(6));
		System.out.println(Base10.sol2(6));

	}

}
