import Nishant_DS.*;

class SLL
{
    public static void main(String ar[])
    {
      SinglyLinkedList<Integer> s=new SinglyLinkedList<>();
      SinglyLinkedList<Integer> b=new SinglyLinkedList<Integer>();
      SinglyLinkedList<Integer> c=new SinglyLinkedList<Integer>();    
        s.addLast(1);
        s.addLast(2);
        s.addLast(5);
        s.addLast(3);
        s.addLast(1);
        //c.merge(s,b);
        //c.reverse();
        //if(!s.isEmpty())
        s.checkpalindrome();
            System.out.print(s.toString());
    }
}