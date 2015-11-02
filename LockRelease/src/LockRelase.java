import java.util.Stack;


public class LockRelase {
	
			public static boolean relaseLock(String[] list){
				int len = list.length;
				if (len %2 != 0)
					return false;
				Stack<String> stk = new Stack<String>();
				String[] arr = new String[2];
				for(int i=0; i<len; i++){
					arr = list[i].split(" ");
					if(arr[0].equals("ACQUIRE"))
						stk.push(arr[1]);
					else{
						if(stk.peek().equals(arr[1]))
							stk.pop();
						else
							return false;
					}
				}
				if(!stk.isEmpty())
					return false;
				
				return true;
			}
	
	public static void main(String[] args) {
		String[] list = {"ACQUIRE 364", "ACQUIRE 86", "RELEASE 86", "RELEASE 364"};
		
		System.out.println(LockRelase.relaseLock(list));

	}

}
