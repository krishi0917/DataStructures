
public class NormalStack {

	int stackSize = 20;
	int [] stack;
	int top;
	int min = -1;
	
	public NormalStack() {
		stack = new int[20];
		top = -1;
	}
	
	public void push(int data){
		if(min == -1)
				min = data;
		if(top >= 19){
			System.out.println("The stack is full, cannot insert items");
		}
		else{
				min = (min<data)?min:data;
				stack[++top] = data;
			}
	}
	
	public int pop(){
		if(top == -1){
			System.out.println("Stack is already empty");
		}
		else{
			int value = stack[top];
			stack[top] = 0;
			top -=1;
			return value;
		}
		return 0;
	}
	public int min(){
		return this.min;
	}
	
	public void display(){
		for(int i = top; i>=0; i--){
			System.out.println(stack[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		
		NormalStack s = new NormalStack();
		s.push(5);
		s.push(2);
		s.push(3);
		s.push(4);
		s.display();
		System.out.println(s.min());

	}

}
