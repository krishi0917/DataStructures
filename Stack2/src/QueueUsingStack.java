import java.util.Queue;
import java.util.Stack;

/**
 * The question is to use stacks to insert data but pop the elements in a queue manner i.e 
 * FIFO.
 * 
 * Solution: We'll use two stack, push the top of stack 1 to stack 2 and then the top element of stack 2
 * will be the first element inserted i.e FIFO
 * @author badal
 *
 */

public class QueueUsingStack {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	/**
	 * Insert elements to stack
	 */
	public void enqueue(int item){ 
		s1.push(item);
	}
	
	public int dequeue(){
		//Check if both the stacks are empty, i.e there are no elements
		if(s1.isEmpty() && s2.isEmpty())
			return -1;
		
		//if Stacjk 2 is empty and stack 1 has elements, empty the stack 1 in to stack 2
		else if (s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
			return s2.pop();
		}
		//If there are some elements in the stack, just pop the top element.
		else
			return s2.pop();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueUsingStack qs = new QueueUsingStack();
		qs.enqueue(1);
		qs.enqueue(2);
		qs.enqueue(3);
		qs.enqueue(4);
		qs.enqueue(5);
		
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		

	}

}
