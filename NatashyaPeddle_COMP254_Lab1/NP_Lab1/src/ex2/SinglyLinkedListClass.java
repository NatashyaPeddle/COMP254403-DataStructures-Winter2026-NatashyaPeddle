package ex2;


/// In this exercise, you will add a method swapNodes to SinglyLinkedList class from week 2 lecture examples.
/// This method should swap two nodes node1 and node2 (and not just their contents)
///  given references only to node1 and node2. The new method should check if node1 and node2 are the same node, etc.
/// Write the main method to test the swapNodes method. Hint: You may need to traverse the list.

public class SinglyLinkedListClass<E> implements Cloneable {
    /// this defines the shape/layout of the node --------------------- nexted node
    private static class Node<E>{
        /// --------nested node class

        private  E element;
        private Node<E> next;

        public Node(E e, Node<E> n){  /// constructor: setting data, e = element, n = next node

            element = e;
            next = n;

        }

        public E getElement(){ return element; }///returns current node
        public Node<E> getNext(){ return next; } ///returns the next node
        public void setNext(Node<E> n) { next = n; }///updates "next" node to be the one after the new current

    } ///end of nested ------------this defines the shape/layout of the node

    /// instance variables
    private Node<E> head = null; ///starting node - is empty ----points to start node reference - needed to traverse list
    private Node<E> tail = null; ///end node - is empty points to end node reference needed to traverse list & add nodes
    private int size = 0; ///num of elements

    /// Constructs singly linked empty list---------- initializes above ^^^^
    public SinglyLinkedListClass(){}

    /// access methods-------------
    public int size(){ return size; } ///returns size
    public boolean isEmpty(){ return size == 0; } ///checks if empty

    public E first(){
        if(isEmpty()) return null; ///checks if empty
        return head.getElement(); ///returns head first node
    }
    public E last(){
        if(isEmpty()) return null; ///checks if empty
        return tail.getElement(); ///returns tail last node
    }

    /// add methods -------------------
    public void addFirst(E e){
        head = new Node<E>(e,head); ///creates new node at front
        if(size == 0) tail = head; ///if empty both point to the same node
        size++; ///adjusts size to new node

    }
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null); ///creates new node at back,
        ///^^^^^it will always be null because no nodes come after it (which is what makes it the last node)
        if (isEmpty()) /// checks if empty
            head = newest; ///if no other nodes the last node becomes the first/head
        else
            tail.setNext(newest); ///if not it remains as the tail
        tail = newest;
        size++; ///adjusts size to new node
    }

/// --- removes first -----------
//    public E removeFirst(){
//        if(isEmpty()) return null; ///checks empty
//        E answer = head.getElement(); ///save element and go to next
//        head = head.getNext();
//        size--; ///adjusts size by subtracting
//        if(size == 0) /// checks if size = 0, if so it resets tail
//            tail = null;
//        return answer;
//    }

    /// -----SWAP NODE METHOD ------------------
    public void swapNode(Node<E> node1, Node<E> node2){ /// swaps the ENTIRE nodes

        Node<E>prev1 = null, prev2 = null; ///prev = previous node - Stores previous nodes
        Node<E> walk = head; ///walk = traverses list

        /// find previous nodes
        while(walk != null) { /// loop through full list
            if(walk.getNext()== node1) prev1 = walk; ///if while traversing  next node is node1 then its stored as the previous (as if you have passed over it)
            if(walk.getNext() == node2) prev2 = walk; ///if while traversing  next node is node2 then its stored as the previous (as if you have passed over it)
            walk = walk.getNext(); ///just moving forward down list
        }

        /// if previous node is not found stop
        if
                ((node1 != head && prev1 == null) || /// prev1 = node before node1, so if null > no node points to node1
                /// head = no previous node so if node1 is head then it works, if not head = null
                (node2 != head && prev2 == null)) /// same logic ^^^
                { return;}
            /// Stops it before list breaks


        /// node connect / link nodes----------------------

        /// *********ONLY RUNS IF SWAPPED*********** RELINKS EVERYTHING AFTER SWAP
        /// prev1 = A, node1 = B, Node1.next = C, Node2=D, node2 next = null/E/Tail
        if (prev1 != null) /// If previous before node1 is not null
            prev1.setNext(node2); ///replaces node1 link with node2
        /// ^^^^ so makes A > D instead of A > B Still

        else /// if previous before node1/A = Null/doesnt exist
            head = node2; /// then update head = node2 - meaning B(head) swaps with D and D becomes head
        /// Example:
        /// A>B>C>D>Null - A = Head, if Node1.Previous = A doesnt exist and B & D are swapped then it goes D>C>B>Null meaning D is the new head


        if(prev2 != null) ///  If previous to node2 = C, C = is not null
            prev2.setNext(node1); /// then update the next after previous2/C (D position) to node1 = B
        else
            head = node1; ///if it is null then make node 1 = head
        ///Example
        ///


        /// swap order
        Node<E> temp = node1.getNext(); ///temporary place to store node 1's next pointer which would be "C" in this instance A>B>*C*
        /// Node 1 = B, Node1 next = C (B is getting swapped) , so it stores C as a temp value so it keeps its position***

        node1.setNext(node2.getNext()); ///node1 points > to the node node2 used to point to (it replaces node2's pointer)
        /// It goes A>B>C>D>E, Node2 = D, Node2's next = E? So when swapped B now points to E so A>D>C>B>*E*

        node2.setNext(temp); ///node2 now points to the temp node1 used to (it replaces node1's pointer)
        /// this takes the earlier temp value C and sets Node 2 = D to have its next be C so A>D>*C*

        /// update tail
        if (node1.getNext() == null) tail = node1; ///if node1 is last node then tail is updated
        if (node2.getNext() == null) tail = node2;///if node2 is last node then tail is updated
    }/// end swap node method -----------------

/// ---TO STRING -----------------------------
public String toString() {
    StringBuilder sb = new StringBuilder("("); ///starts string with (
    SinglyLinkedListClass.Node<E> walk = head; /// goes down the list of elements using "walk"
    /// starts "walking" at head/first node

    while (walk != null) { /// continue loop until it reaches the end
        sb.append(walk.getElement()); ///appends element to list
        if (walk != tail)
            sb.append(", "); ///adds comma after element if there are others following that aren't trailer
        walk = walk.getNext(); ///gets the next element / continues down list
    }
    sb.append(")"); sb.append(")"); ///ends string with a )
    return sb.toString(); /// converts to string
}

/// ---MAIN METHOD -----------------------------------
public static void main(String[] args) {
        SinglyLinkedListClass<String> list = new SinglyLinkedListClass<String>(); ///creates list
        list.addFirst("A"); ///adds elements
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");

        System.out.println(list); ///lists nodes before swap

        Node<String> node1 = list.head.getNext(); ///select b node - Head = A, A.Next = B so set B as Node 1
        Node<String> node2 = list.head.getNext().getNext().getNext(); ///select d node - Head = A, so A.Next.Next.Next => A>B>C> *D* so set Node 2 = D

        list.swapNode(node1, node2); ///swaps the node

        System.out.println("Swapping...");
        System.out.println(list); ///lists nodes after swap

    }///end of main-----------

}///END OF SINGLY LINKED LIST
