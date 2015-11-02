package LLMethods;

import java.awt.image.IndexColorModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * We'll be implementing singly linked list
 * 
 * @author badal
 *
 * @param <E>
 */
public class MyLinkedList<E> implements List<E> {
	
	
	/**
	 * create Node<E> type head and tail variable to be used over
	 * by the methods for list functions 
	 */
	private Node<E> head;
	private Node<E> tail;
	private int currentSize;
	
	/**
	 * create a constructor for MyLinkedList for initializing the list
	 */
	public MyLinkedList(){
		this.head = null;
		this.tail = null;
		this.currentSize = 0;
	}
	
	/**
	 * we'll create a class node to hold the data inside out list
	 * make it a generic type
	 * new Node<E>(); this will call this class, with whatever the type on list will be.
	 * 
	 */
	
	class Node<T>{
		private T data; // the data field in th elinked list
		private Node<T> next; //pointer to next node in the list
		
		/**
		 * constructor for initializing the values
		 */
		public Node(T data, Node<T> next){
			this.data =  data;
			this.next = next;
		}
		
		/**
		 * to get and set the data of the node
		 */
		public T getData(){
			return this.data;
		}
		public  void setData(T data){
			this.data = data;
		}
		/**
		 * the below two functions are for next pointers
		 */
		public Node<T> getNext(){
			return this.next;
		}
		public void setNext(Node<T> newNext){
			this.next = newNext;
		}
		
		
	}
	/**
	 * Creating an Iterator for our List
	 * 1. Create a new class that implements Iterator interface (List already implements Iterable)
	 * 2. We need to implement 3 methods next(), hasNext(), remove()
	 * 
	 * 
	 */
	class LinkedListIterator implements Iterator<E> {

		private Node<E> current;
		private Node<E> previous;
		private Node<E> beforePrevious;
		private boolean removeCalled;
		/**
		 * constructor to set current, previous and beforePrevious nodes
		 */
		public LinkedListIterator(){
			current = head;
			previous = null;
			beforePrevious = null;
			removeCalled = false;
		}
		/**
		 * 
		 */
		public boolean hasNext() {
			if (current != null){
				return true;
			}
			return false;
		}

		/**
		 * check if current element is not null.. and throw no element exception if it is
		 * assign previous to beforePrevious, current to previous and next element to current
		 * store the currnt calue in temp and return it as the next is called
		 * 
		 */
		public E next() {
			// TODO Auto-generated method stub
			if(current == null){
				throw new NoSuchElementException();
			}
			E temp = current.getData();
			beforePrevious = previous;
			previous = current;
			current = current.getNext();
			removeCalled = false;
			return temp;
		}
		/**
		 * Remove the element which is just returned by the next function i.e the element
		 * that will go into the previous variable.
		 */
		public void remove(){
			// If there is no current element or remove is already called for this element
			if(previous == null || removeCalled){
				throw new IllegalStateException();
			}
			//if the element to remove is the head element(actual first element in the list), just make the current element to head
			//as it it the element after previous and there is no beforePrevious element
			if(beforePrevious == null){
				head = current;
			}
			//if this is not the head element
			else{
				//eliminate the link of beforeprevious to previous and point in to current
				beforePrevious.setNext(current);
			}
			currentSize--;
			//check if remove is already called for this next i.e. donot call remove twice on same value
			//we will use a flag and set is to true here
			removeCalled = true;
		}
		
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return this.currentSize;
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size() == 0;
	}

	
	public boolean contains(Object o) {
		for (E element : this){
			if(o==null ? element== null : o.equals(element)){
				return true;
			}
		}
		return false;
	}

	
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}

	
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] arr = new Object[this.size()];
		int i =0;
		for(E element: this){
			arr[i] = element;
			i++;
		}
		return arr;
	}

	/**
	 * takes an array as an arguement and copies the lst values to the array
	 * .1 if the length is list is grater that the length of the array passed, a new array
	 * is created of the size of the list.
	 * 2. If the size of passed array is greater than the list t
	 */
	public <T> T[] toArray(T[] a) {
		Object[] arr = a;
		//check if the size of list is more than the size of array passed
		if(this.size() > a.length){
			arr =new Object[size()];
		}
		int i=0;
		//add the elemenst to the array
		for (E ele: this){
			arr[i] = ele;
		}
		//check if the array size is more than the size of the list
		//set the end of the array to null
		if(arr.length > i){
			arr[i] = null;
		}
		a = (T[])arr;
		return a;
	}

	/**
	 * Always returns true
	 * check: 1. if list is empty, set the head node to new node and tail = head
	 * 2. if it is not empty, set the tails's next to new node and newnode is not the tail
	 * 3. imcrement the current size
	 */
	public boolean add(E e) {
		// TODO Auto-generated method stub
		if(isEmpty()){
			head = new Node(e, null);
			tail = head;
		}
		else{
			tail.setNext(new Node(e, null));
			tail = tail.getNext();
		}
		currentSize++;
		return true;
	}

	
	public boolean remove(Object o) {
		Iterator<E> iter = this.iterator();
		
		while(iter.hasNext()){
		 E ele = iter.next();
		 if (o==null?ele==null:o.equals(ele)){
			 iter.remove();
			 return true;
		 }
		}
		return false;
	}

	
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * clear the list, remove all elements
	 */
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		tail = null;
		currentSize = 0;
		
	}
	/**
	 * returns an element at specified location
	 * 1. check if index is not out of boundsiter
	 * 2. iterate through the list till size -2 [since the last index will not have any next and will be inefficient]
	 * 3. return last element if code reaches there
	 */
	
	public E get(int index) {
		// TODO Auto-generated method stub
		//1.
		if(index <0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		//2.
		if(index < size()-1){
			Node<E> current = head;
			for (int i=0; i<index; i++){
				current = current.getNext();
			}
			return current.getData();
		}
		//3.
		return tail.getData();
	}

	
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * adding an element at specified index
	 * 1. check if the index is less than 0 or greater than size; throw outof bound exception
	 * 2. check if the i=size i.e same case as inserting at the last
	 * 3. check if i = 0, inserting at the beginning
	 * 4. inserting any where in the list
	 * 5. increment the size for step 3 and 4, because 2 will call add(e) which will increment the size
	 */
	public void add(int index, E element){
		// TODO Auto-generated method stub2, 
		//1.
		if(index < 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		//2.
		if(index == size()){
			add(element);
			return;
		}
		//3.
		if(index == 0){
			//System.out.println("Head is "+ head.getData());
			head = new Node(element, head);
			//System.out.println("Head changed to  "+ head.getData());
		}
		//4.
		else{
			Node<E> current = head;
			for(int i=0;i<index-1;i++){
				current = current.getNext();
				//System.out.println("current data "+ current.getData());
			}
			//now current is pointing to to the node after wchich we need to add a new node
			//current will point to new node and new node's next will point to current's next node
			current.setNext(new Node(element, current.getNext()));
 		}
		//5.
		currentSize++;
		
	}

	
	public E remove(int index) {
		if (index < 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		Iterator iter = this.iterator();
		for(int i =0; i< index; i++){
			iter.next();
		}
		//save the next value in the variable to be returned
		E e = (E)iter.next();
		iter.remove();
		return e;
	}

	//Returns the index of the object
	/**
	 * public boolean remove(Object o) {
		Iterator<E> iter = this.iterator();
		
		while(iter.hasNext()){
		 E ele = iter.next();
		 if (o==null?ele==null:o.equals(ele)){
			 iter.remove();
			 return true;
		 }
		}
		return false;
	}
	 */
	public int indexOf(Object o) {
		//E ele = (E)o;
		int i=0;
		Iterator<E> iter = this.iterator();
		while(iter.hasNext()){
			E ele2 = iter.next();
		//	System.out.println("Element  is "+ele);
			System.out.println("Element 2 is "+ele2 + "i is " + i);
			if(o.equals(ele2)){
				return i;
			}
			i++;
		}
		return 0;
	}

	
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//Returns hashcode for every the entire list by iterating over the elements
	public int hashCode() {
		int hashcode = 1;
		for(E ele: this)
			hashcode = hashcode*31 + (ele==null?0:ele.hashCode());
		return hashcode;
	}


	/**
	 * compares the two lists and checks if they have same number , order and values.
	 * checks for diff types of list till they are same , i.e an array, linked list etc.
	 */
	public boolean equals(Object obj) {
		if(obj instanceof List){
			//type case to tyope of list
			List listObj = (List)obj;
			// check if calling and compareable list are of same size
			if(this.size() == listObj.size()){
				Iterator list1 = this.iterator();
				Iterator list2 = listObj.iterator();
				//iterate till end of list, use any list, since both are of same size
				while(list1.hasNext()){
					Object o1 = list1.next();
					Object o2 = list2.next();
					//check if o1 is null and o2 is null OR o1 = o2--if not return false
					if(!(o1 == null ? o2 == null : o1.equals(o2))){
						return false;
					}
				}
				return true;
			}
		}
		
		return true;
	}


	
	public Object clone() {
		MyLinkedList<E> copy = new MyLinkedList<E>();
		for (E element: this){
			copy.add(element);
		}
		return copy;
		
	}


	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
