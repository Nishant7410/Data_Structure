package Nishant_DS;
public class CircularlyLinkedList<E> 
{
  //---------------- nested Node class ----------------
  /**
   * Singly linked node, which stores a reference to its element and
   * to the subsequent node in the list.
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;     // an element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;  // a reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
    element=e;
    next=n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() {return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) {  next=n; }
  } //----------- end of nested Node class -----------

  // instance variables of the CircularlyLinkedList
  /** The designated cursor of the list */
  private Node<E> head;                  // we store tail (but not head)

  /** Number of nodes in the list */
  private int size = 0;                         // number of nodes in the list

  /** Constructs an initially empty list. */
  public CircularlyLinkedList() { head=null;}             // constructs an initially empty list

  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { 
  if(size==0)
  return true;
  else
  return false;
  }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first() {
  return (head.getNext()).getElement();// returns (but does not remove) the first element
  }

  /**
   * Returns (but does not remove) the last element of the list
   * @return element at the back of the list (or null if empty)
   */
  public E last() { 
  return head.getElement();
  // returns (but does not remove) the last element
   }

  // update methods
  /**
   * Rotate the first element to the back of the list.
   */
  public void rotate() {
    head=head.getNext();
    // rotate the first element to the back of the list
   }

  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {
    Node<E> temp=new Node<>(e,null);
    if(head==null)
    {
    head=temp;
    head.setNext(temp);
    size++;
    }
    else
    {
    temp.setNext(head.getNext());
    head.setNext(temp);
    size++;
    }// adds element e to the front of the list
   }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) {
  Node<E> temp=new Node<>(e,null);
  if(head==null)
  {
  head=temp;
  head.setNext(temp);
  size++;
  }
  else
  {
  Node<E>temp1=head.getNext();
  head.setNext(temp);
  head=temp;
  head.setNext(temp1);
  size++;
  }
  // adds element e to the end of the list
   }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {
  Node<E>temp=head.getNext();
  head.setNext((head.getNext()).getNext());
  size--;
  return temp.getElement();
  // removes and returns the first element
   }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
  Node<E>temp=head.getNext();
  String str=new String("");
  while(temp!=head)
  {
  str+=String.valueOf(temp.getElement())+"->";
  temp=temp.getNext();
  }
  str+=String.valueOf(temp.getElement());
  return str;
   }
}
