package ex1;

//In this exercise, you will use the DoublyLinkedList implementation of the textbook (week 2 lecture examples.
//Write a method for concatenating two doubly linked lists L and M, with header and trailer sentinel nodes,
//into a single list L′. Write a main method to test the new method. Hint: Connect the end of L into the beginning of M.

public class DoublyLinkedListClass <E> {

    /// LAYOUT: Previous <- element list -> next  double list = both ways
    private static class Node<E> {
/// this defines the shape/layout of the node --------------------- nexted node
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) { /// constructor: setting data
            element = e;
            prev = p;
            next = n;

        }

        public E getElement() { return element; } ///returns current node
        /// get node - accessing nodes
        public Node<E> getPrev() { return prev; } ///returns the previous ndde to the current one or NULL if no node
        public Node<E> getNext() { return next; } ///returns the next ndde to the current one or NULL if no node

        /// set node ----- update nodes
        public void setPrev(Node<E> p) { prev = p; } ///
        public void setNext(Node<E> n) { next = n; }
    } /// end of nested node---------------------this defines the shape/layout of the node

    private Node<E> header; /// creates "Sentinel node" at start
    private Node<E> trailer; /// creates "Sentinel node" at end
    private int size = 0; ///list element num


    /// constructs empty list

    public DoublyLinkedListClass() {
        header = new Node<>(null, null, null); ///creates header
        trailer = new Node<>(null, header, null); ///trailer is preceeded by header
        header.setNext(trailer); /// header is followed by trailer
    }

    /// creates a new list empty list - base for all lists^^^----------

    /// ---------required operations---------
    public int size() { return size; } ///returns number of elements in list
    public boolean isEmpty() { return size == 0; } ///checks and returns whether its empty


    /// ----add methods---------------------------------------------------
    ///
    /// used to add elements in main
    public void addFirst(E e) { addBetween(e, header, header.getNext());}///Added between header <--> next node after header

    public void addLast(E e) { addBetween(e, trailer.getPrev(), trailer);} ///Added between trailer <--> previous node before trailer



    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        /// creates/links nodes
        Node<E> newest = new Node<>(e, predecessor, successor); ///creates new node "newest" predecsesor = header / successor = trailer
        predecessor.setNext(newest); ///sets newest after header
        successor.setPrev(newest); ///sets newest before trailer
        size++; ///changes size of list to include new node
    }
    /// ----remove methods--------------------------------------------------------------
    /// reverse of the add methods, it removes the element next to trailer/header
    public E removeFirst() {
        if (isEmpty()) return null; /// has nothing to remove if empty
        return remove(header.getNext()); /// removes element directly after header
    }
    public E removeLast() {
        if (isEmpty()) return null; /// has nothing to remove if empty
        return remove(trailer.getPrev()); /// removes element directly before trailer
    }

    private E remove(DoublyLinkedListClass.Node<E> node) {
        DoublyLinkedListClass.Node<E> predecessor = node.getPrev(); /// returns the previous node before current node and sets it to name
        DoublyLinkedListClass.Node<E> successor = node.getNext(); /// returns the next node after current node and sets it to name
        predecessor.setNext(successor); ///skips over the removed node example: predecessor > removed node > successor = predecessor > successor
        successor.setPrev(predecessor); ///does the same as above but reverse/backward
        size--;///decreases size when element is removed
        return node.getElement(); ///calls the name of the removed node
    }

    /// ----returns element-------------------
    ///  just used to check elements without touching list
    public E getFirst() {
        if (isEmpty()) return null; /// if size = 0 doesnt return
        return header.element;
    }
    public E getLast() {
        if (isEmpty()) return null; /// if size = 0 doesnt return
        return trailer.element;
    }

    /// ------concatenate-------------------------------------------------
   public void concatenate(DoublyLinkedListClass<E> other) { /// takes other list and adds to end of current list

       Node<E>thisLast = this.trailer.getPrev(); /// "Sentinel node" = this.trailer node at end of current list > returns last element
       Node<E>otherLast = other.trailer.getPrev(); /// gets last element of other list > store in otherlast
       Node<E>otherFirst = other.header.getNext(); ///first element in other list > will connect to end of current list


       /// ---update size----
       this.size+=other.size(); ///combines the sizes of added elements


       /// --- connect lists----

       otherLast.setNext(this.trailer); /// connects end of other list to the trailer of the first list
       otherFirst.setPrev(thisLast); /// connect last node in L list to last of M
       thisLast.setNext(otherFirst); /// connect last node of L list to first of M
       this.trailer.setPrev(otherLast); ///new backward/previous link of L list to include the M list

       /// ---remove old list elements
        other.header.setNext(other.trailer); /// Makes empty / closes it
        other.trailer.setPrev(other.header); /// Makes empty / closes it
        other.size = 0;
   }

    /// -----STRING-----------------------------------
    public String toString() {
        StringBuilder sb = new StringBuilder("("); ///starts string with (
        DoublyLinkedListClass.Node<E> walk = header.getNext(); /// goes down the list of elements using "walk"
        while (walk != trailer) { /// continue loop until end node "trailer"
            sb.append(walk.getElement()); ///appends data to string format
            walk = walk.getNext(); /// goes to next node
            if (walk != trailer)
                sb.append(", "); ///adds comma after element if there are others following that aren't trailer
        }
        sb.append(")"); ///ends string with a )
        return sb.toString(); /// converts to string
    }

    public static void main(String[] args) {
        /// ---------populates lists------------------

        /// L List
        DoublyLinkedListClass<String> L = new DoublyLinkedListClass<>(); /// creates L list
        L.addFirst("A"); ///Adds first element for L
        L.addLast("B"); ///adds element after last for L
        L.addLast("C");

        ///  M List
        DoublyLinkedListClass<String> M = new DoublyLinkedListClass<>(); ///creates M list
        M.addFirst("D"); ///Adds first element for M
        M.addLast("E"); ///adds element after last for M

        /// Print lists
        System.out.println("L:" + L);
        System.out.println("M:" + M);

        L.concatenate(M); ///calls concatenate method to merge M into L list

        System.out.println("Concatenating...");
        System.out.println("L:" + L);
        System.out.println("M:" + M);

    }
} ///END OF DOUBLYLINKEDLIST CLASS
