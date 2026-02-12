package ex3;



public class CircularlyLinkedListClass <E> implements Cloneable { /// must include cloneable to clone list

    /// nested node -------------------------------------------------
    private static class Node<E> {
        private E element;
        private Node<E> next;

        /// constructor
    public Node( E e, Node<E> n) {
        element = e;
        next = n; ///stores references
    }
        /// accesss and change node data
        public E getElement(){ return element; }///returns current node - able to read element
        public Node<E> getNext(){ return next; } ///returns the next node - allows you to switch nodes
        public void setNext(Node<E> n) { next = n; }///updates "next" node to be the one after the new current - allows you to link nodes

    }/// nested Node class end --------------


    /// instance variables ----------------
    /// remember information and hold current condition of lists in between method calls
    private Node<E> tail = null; /// end node - remembers where it is
    private int size = 0; ///returns size

    /// creates empty list----------------------------------
    public CircularlyLinkedListClass() {}

    /// access methods--------------------------------------------

    public int size(){ return size; } ///returns size
    public boolean isEmpty(){ return size == 0; } ///checks if empty

    public E first(){
        if(isEmpty()) return null; ///checks if empty
        return tail.getNext().getElement(); ///returns head first node
    }
    public E last(){
        if(isEmpty()) return null; ///checks if empty
        return tail.getElement(); ///returns tail last node
    }

    public void rotate(){ /// rotates element to back of list
        if(tail != null) /// if empty do nothing
            tail = tail.getNext(); /// head becomes new tail > Tail.next = head => looks back aorund so head becomes tail
    }

    /// add methods -------------------
    public void addFirst(E e){/// adds element to front of list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); ///sets the next node after tail TO tail
        } else {
            Node<E> newest = new Node<>(e, tail.getNext()); /// New node that points to the head node
            tail.setNext(newest); /// tail points to new node
        }
        size++; ///adjusts size to new node

    }
    public void addLast(E e){ /// adds element to end of list
        addFirst(e); ///new element at front of list
        tail = tail.getNext(); ///  new element becomes the tail

    }


    public E removeFirst(){ /// removes and returns first element
        if(isEmpty()) return null; ///doesnt do anything if its empty
        Node<E> head = tail.getNext();  ///head = the node after tail
        if(head == tail) tail = null; ///there is only one node left meaning head and tail are the same node
        else tail.setNext(head.getNext()); ///removes head from list - Ask why?
        size--; ///adjusts size
        return head.getElement(); ///returns removed head element
    }

    ///clone method
    public CircularlyLinkedListClass<E> clone() throws CloneNotSupportedException { /// returns the already created list
        CircularlyLinkedListClass<E> other =  (CircularlyLinkedListClass<E>) super.clone(); /// creates shallow copy / clone - creates new list named other
        if(size > 0) { /// only clones the first list if its not empty

            Node<E> walk = tail.getNext(); ///starts at head (which is after tail)

            Node<E> newest = new Node<>(walk.getElement(), null); ///creates node in list and copies element
            newest.setNext(newest); ///makes it circular or loop back
            other.tail = newest; /// adds a tail node
            walk = walk.getNext(); ///moves to next node in first list

            while(walk != tail.getNext()){ /// loop = continue until back to head
                Node<E> nextNode = new Node<>(walk.getElement(), other.tail.getNext()); /// copies the next element and with the above loop, keeps copying until end
                other.tail.setNext(nextNode); ///links new copied node after the cloned tail node
                other.tail = nextNode; ///movs tail  to last new node
                walk = walk.getNext(); /// moves forward in orgiginal list
            }
        }
        return other; /// returns cloned list
    }


    /// ---TO STRING -----------------------------
    public String toString() {
        StringBuilder sb = new StringBuilder("("); ///starts string with (
        Node<E> walk = tail; ///walk starts a tail

        do {
            walk = walk.getNext(); ///moves to next node
            sb.append(walk.getElement()); ///appends
            if (walk != tail)
                sb.append(", "); ///adds commas

        } while (walk != tail); { /// continue loop until it reaches the end
        sb.append(")"); ///ends string with a )
        return sb.toString(); /// converts to string
    }
    }

    // ---MAIN METHOD -----------------------------------
    public static void main(String[] args) throws CloneNotSupportedException {
            CircularlyLinkedListClass<String> list = new CircularlyLinkedListClass<String>(); ///creates list

            list.addFirst("A"); ///adds elements
            list.addLast("B");
            list.addLast("C");
            list.addLast("D");

            System.out.println("Starting List:" + list); ///lists nodes before clone--------------------

            CircularlyLinkedListClass<String> clonedList = list.clone(); ///clones the list
            System.out.println("Cloned List: " + clonedList); /// cloned list printed ------------------------------


            list.rotate(); ///rotates elements

            System.out.println("Rotated: " + list); ///Rotated list

            list.removeFirst();
            System.out.println("Removed: " + list); ///removed element list
    } ///end of main-----------


}///circular linked class------------------------------------------------------------------------------
