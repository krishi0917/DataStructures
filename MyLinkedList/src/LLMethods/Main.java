package LLMethods;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");	
		/*//clone list
		MyLinkedList<String> list2 = (MyLinkedList<String>)list.clone();
		list2.add("5");*/
		/*list2.add("1");
		list2.add("2");
		list2.add(0, "3");
		list2.add(2, "4")*/;	
		System.out.println(list.indexOf("3"));
		list.remove("2");
		/*System.out.println("list one and list 2 comparison "+ list.equals(list2));
		System.out.println("List2 contains " + list2.contains("5"));
		System.out.println("List1 contains " + list.contains("5"));*/
		
		/*Iterator<String> iter = list.iterator();
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.hasNext());
		System.out.println(iter.next());
		iter.remove();
		System.out.println(iter.next());
		System.out.println(iter.hasNext());
		*/
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		//System.out.println(list.get(3));
	//	System.out.println(list.get(4));
	}

}
