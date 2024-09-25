/**
 * This is an OrderedLinkedList class.
 * It stores data into the linked list using Node class
 * Ordered linked list class extends Comparable T to be able to sort data by comparing it
 */
public class OrderedLinkedList<T extends Comparable<T>> {
	//initial variables head of type Node of type T which represents a linked list and size which represents size of the list
    private Node<T> head;
    private int size;
    //constructor method initializing an empty variables
    public OrderedLinkedList() {
        head = null;
        size = 0;
    }
    //insert method type void which inserts data of abstract type T to the ordered linked list
    public void insert(T data) {
    		//
    	    Node<T> newNode = new Node<>(data, null);
    	    //size will be adding one after inserting data
    	    size++;
    	    //if a previous node/head is empty or data you are storing is bigger than data in the head you will put data at the beginning of the linked list
    	    if (head == null || data.compareTo(head.getData()) > 0)  {
    	        newNode.setNext(head);
    	        head = newNode;
    	        return;
    	    }
    	    Node<T> current = head;
    	    int dN = 0;
    	    //we are using while loop to find the right place for data in a ordered linked list
    	    //integer dN is used to calculate numbers of data we deleted to store a new data
    	    while (current != null && data.compareTo(current.getData()) < 0) {
    	        current = current.getNext();
    	        dN += 1;
    	    }
    	    
    	    newNode.setNext(current);
    	    T nData = null;
    	    Node<T> pNode = head;
    	    //we are using double for loop to store data which was deleted in a previous loop
    	    for (int i = 0; i < dN; i++) {
    	    	for (int j = 0; j < dN - i; j++) {
    	    		nData = pNode.getData();
    	    		pNode = pNode.getNext();
    	    	}
    	    	pNode = head;
    	    	Node<T> nNode = new Node<> (nData,newNode);
    	    	newNode = nNode;
    	    }

    	    //making an updated linked list
    	        head = newNode;
    }
    // get method returns data in the particular index
    public T get(int index) {
    	//if index does not exist it throws Index Out Of Bonds Exception
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        Node<T> cNode = head;
        //finding the node in which data in the given index is first
        for (int i = 0; i < index; i++) {
            cNode = cNode.getNext();
        }
        return cNode.getData();
    }
    //get size method returns a size
    public int getSize() {
        return size;
    }
}