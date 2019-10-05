package Nishant_DS;

public class SinglyLinkedList<E extends Comparable<E>> 
{
  //---------------- nested Node class ----------------
  /**
   * Node of a singly linked list, which stores a reference to its
   * element and to the subsequent node in the list (or null if this
   * is the last node).
   */
  private static class Node<E extends Comparable<E>>
  {
    /** The element stored at this node */
    private E element;            // reference to the element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;         // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) 
    {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() 
    { 
      return element; 
    }

    public void setElement(E element)
    {
      this.element=element;
    }
    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------


  // instance variables of the SinglyLinkedList
  /** The head node of the list */

  private Node<E> head = null;               // head node of the list (or null if empty)


  /** The last node of the list */
  private Node<E> tail = null;               // last node of the list (or null if empty)


  /** Number of nodes in the list */
  private int size = 0;                      // number of nodes in the list
  private Node<E> pal=null;

  /** Constructs an initially empty list. */
  public SinglyLinkedList() { }              // constructs an initially empty list


  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }
  public void setSize(int s)
  {
  size=s;
  }


  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first() {             // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return head.getElement();
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() {              // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {                // adds element e to the front of the list
   Node<E> temp=new Node<>(e,head);
  if(tail==null)
  {
      tail=temp;
      head=temp;
      size++;
  }
    else
    {
        head=temp;
        size++;
    }
  }
  public void insertBetween(E e,int index)
  {
   if(index==0)
          addFirst(e);
        else if(index==size-1)
            addLast(e);
        else
        {
            Node<E> temp=head;
            int i=0;
            while(temp.getNext()!=null)
            {
                if(i==index-1)
                {
                 Node<E> node=new Node<>(e,temp.getNext());
                 temp.setNext(node);    
                }
                temp=temp.getNext();
                i++;
                
            }
            size++;
        }
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) {                 // adds element e to the end of the list
    Node<E> temp=new Node<>(e,null);
  if(head==null)
  {
      head=temp;
      tail=temp;
      size++;
  }
      else
      {
          tail.setNext(temp);
          tail=temp;
          size++;
      }
  }



  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {                   // removes and returns the first element
   if(isEmpty())
          return null;// removes and returns the first element
   Node<E> temp=head;
      head=temp.getNext();
      size--;
      return temp.getElement();
  }

  public void reverseiteratively()  //reverse iteratively
  {
    Node<E> temp=head;
    Node<E> prev=null;
    Node<E> current=head;
    Node<E> next=null;
    while(current!=null)
    {
      next=current.getNext();
      current.setNext(prev);
      prev=current;
      current=next;
    }
    head=prev;
    tail=temp;
  }
  
  public void reverserec(Node<E>slow,Node<E>fast)
  {
  //static Node<E> temp;
  if(fast==null)
  {
    pal=slow;
    return;
  }
  else if(fast.getNext()==null)
  {
    pal=slow.getNext();
    return;
  }
  
        reverserec(slow.getNext(),fast.getNext().getNext());
        int temp=slow.getElement();
        slow.setElement(pal.getElement());
        pal.setElement(temp);
        return;
  }
  public void reverserecursively()
{
    reverserec(head,head);
}
  public int midElement(Node<E>slow,Node<E>fast)
  {
  //static Node<E> temp;
  if(fast==null)
  {
    return slow.getElement();
  }
  else if(fast.getNext()==null)
  {
    return slow.getElement();
  }
  
        return midElement(slow.getNext(),fast.getNext().getNext());
        
  }
 int middleElement()
 {
 int m=midElement(head,head);
 return m;
 }
 public void addfirstlast(Node<E>slow,Node<E>fast)
 {
    if(fast==null)
  {
    pal=slow;
    return;
  }
  else if(fast.getNext()==null)
  {
    pal=slow.getNext();
    return;
  }
  
        addfirstlast(slow.getNext(),fast.getNext().getNext());
        int temp=slow.getElement()+pal.getElement();
        slow.setElement(temp);
        pal.setElement(temp);
        return;
 }
 public void add()
 {
 addfirstlast(head,head);
 }
 int NnodeFromEnd(int i)
 {
 int c=0;
 Node<E> temp=head;
 while(temp!=null)
 {
 c++;
 temp=temp.getNext();
 }
 c=c-i;
 i=0;
 temp=head;
 while(temp!=null)
 {
 if(i==c)
 break;
 i++;
 temp=temp.getNext();
 }
 return temp.getElement();
 }
 
 public removeloop(Node<E>head,Node<E>node)
 {
 Node<E> ptr1=head;
 Node<E> ptr2;
 int c=1;
 while(c==1)
 {
  ptr2=node;
  while(ptr2.getNext()!=node&&ptr2.getNext()!=ptr1)
  ptr2.getNext();
  if(ptr2.getNext()==ptr1)
  break;
  ptr1=ptr1.getNext();
 }
 ptr2.setNext(null);
 }
 
 public boolean RemoveandDetectLoop()
 {
  Node<E> p=head;
  int c=0;
  Node<E> q=head;
  while(p!=null&&q!=null&&p.getNext())
  {
     p=p.getNext().getNext();
     q=q.getNext();
     if(p==q)
     {
     break;
     }
  }
  if(p!=q)
  return false;
  q=head;
  while(p!=q)
  {
  q=q.getNext();
  p=p.getNext();
  }
  removeloop(head,p);
  return true;
 }
  public void sort()
  {
    Node<E> start=head;
    while(start!=null)
    {
      Node<E> next=start.getNext();
      while(next!=null)
      {
        E x=start.getElement();
        E y=next.getElement();
        if(x.compareTo(y)>0)
        {
          start.setElement(y);
          next.setElement(x);
        }
        next=next.getNext();
      }
      start=start.getNext();
    }
  }
  
  private Node<E> sortedMerge(Node<E> A,Node<E> B)
  {
        if(A == null) return B; 
        if(B == null) return A; 
          
        if(A.getElement().compareTo(B.getElement()) < 0 )  
        { 
            A.setNext(sortedMerge(A.getNext(), B)); 
            return A; 
        } 
        else 
        { 
            B.setNext(sortedMerge(A, B.getNext())); 
            return B; 
        } 
          
  }

  public void merge1(SinglyLinkedList<E> list)
  {
    sort();
    list.sort();

    head=sortedMerge(head,list.head);

    if(tail.getElement().compareTo(list.tail.getElement())<0)
    {
      tail=list.tail;
    }
    size+=list.size();

    list.setSize(0);

 }
 
 public void merge(SinglyLinkedList<E> s,SinglyLinkedList<E> b)
  {
      Node<E> first=s.head;
      Node<E> second=b.head;
      while(first!=null&&second!=null)
      {
          if(first.getElement().compareTo(second.getElement())<0)
          {
              Node<E> temp=new Node<>(first.getElement(),null);
              if(head==null)
              {
                  head=temp;
                  tail=temp;
              }
              else
              {
                  tail.setNext(temp);
                  tail=temp;
              }
              first=first.getNext();
          }
          else
          {
            Node<E> temp=new Node<>(second.getElement(),null);
              if(head==null)
              {
                  head=temp;
                  tail=temp;
              }
              else
              {
                  tail.setNext(temp);
                  tail=temp;
              }
              second=second.getNext();  
          }
          
      }
      if(first==null)
      {
          while(second!=null)
          {
          Node<E> temp=new Node<>(second.getElement(),null);
          tail.setNext(temp);
          tail=temp; 
          second=second.getNext();      
          }  
      }
      else if(second==null)
      {
         while(first!=null)
          {
          Node<E> temp=new Node<>(first.getElement(),null);
          tail.setNext(temp);
          tail=temp; 
          first=first.getNext();      
          }  
      }
      
  }
  
   public boolean check(Node<E>slow,Node<E>fast)
  {
  //static Node<E> temp;
  if(fast==null)
  {
    pal=slow;
    return true;
  }
  else if(fast.getNext()==null)
  {
    pal=slow.getNext();
    return true;
  }
  
        boolean result=check(slow.getNext(),fast.getNext().getNext());
        if(result==true)
        {
            if(slow.getElement()==pal.getElement())
            {
                pal=pal.getNext();
                return true;
            }
            else
            return false;
        }
        else
        return false;
  
  }
  public void checkpalindrome()
  {
  //int i=0,j=0,t=0;
  Node<E>temp=head;
//  while(temp!=null)
//  {
//  t++;
//  temp=temp->next;
//  }
  if(check(temp,temp))
  System.out.println("Palindrome");
  else
  System.out.print("Not Palindrome");
  
  }
  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() 
  {
      Node<E> temp=head;
      String str=new String("");
  while(temp.getNext()!=null)
  {
      str+=temp.getElement();
      str+="->";
      temp=temp.getNext();
  }
      str+=temp.getElement();
      return str;
  }
}
