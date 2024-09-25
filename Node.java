
/**
 * This is a Node class.
 * It stores variables data of abstract type T and next of Node of type T.
 */
public class Node <T> {
	//initial variables
	private T data;
	private Node<T> next;
	//Constructor method to initialize the variables
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	//getting data of type T
	public T getData() {
		return data;
	}
	//getting next of type Node of type T
	public Node<T> getNext() {
		return next;
	}
	//setting next
	public void setNext(Node<T> next) {
		this.next = next;
	} 
}
