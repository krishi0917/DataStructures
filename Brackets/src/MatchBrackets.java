import java.util.Stack;

public class MatchBrackets {

	public String match(String input){
		String op = "NO";
		Stack<Character> stk = new Stack<Character>();
		char temp;
		int t,i;
		for (i=0; i<input.length(); i++){
			temp = input.charAt(i);
				if(!stk.empty()){
				t= (int)stk.peek();
					if(t==(int)temp-1 || t == (int)temp-2){
						stk.pop();
					}
					else{
						stk.push(temp);
					}
				}
				else
					stk.push(temp);
				}
		if(stk.isEmpty() && i==input.length())
			op = "YES";
		
		return op;
	}
	
	public static void main(String ... args){
		MatchBrackets m = new MatchBrackets();
		System.out.println(m.match("{}[]()[{()}]({})"));
	}
	
}
