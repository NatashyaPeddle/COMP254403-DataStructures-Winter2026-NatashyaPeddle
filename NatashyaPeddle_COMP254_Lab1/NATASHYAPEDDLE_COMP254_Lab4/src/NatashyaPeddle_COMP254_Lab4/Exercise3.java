package NatashyaPeddle_COMP254_Lab4;
import References.SinglyLinkedList;

/// Implement a method with signature concatenate(Exercise3<E> Q2)
///  for the Exercise3<E> class that takes all elements of Q2 and
/// appends them to the end of the original queue. The operation should
///  run in O(1) time and should result in Q2 being an empty queue.
///  Write the necessary code to test the method. Hint: You may
/// just modify the SinglyLinkedList class to add necessary support.


public class Exercise3<E> { /// defines generic param type

    private SinglyLinkedList<E> list = new SinglyLinkedList<E>(); ///references the singlylinkedlist.java file

    public Exercise3() {} ///constructor for empty queue

    public int size() { return list.size(); } ///returns num of elements in queue

    public boolean isEmpty() { return list.isEmpty(); } ///checkes if empty

    public void enqueue(E e) { /// adds element e to rear of queue
         list.addLast(e); ///adds to end of list
    }

    public E dequeue() { return list.removeFirst(); } ///returns and removes element at front of queue

    public E first(){ /// returns first element without removing or changing it
        return list.first();
    }

    /// CONCATENATE ==========================================================================
    /// takes another Queue Q2 and appends all elements to this queue
    public void concatenate(Exercise3<E> Q2) {

        if(this.isEmpty()){ /// checks if empty
            this.list = Q2.list; ///assigns list reference to Q2
        } else {
            this.list.tail.setNext(Q2.list.head); ///Q2 List become the new ones for this.list / links lists
            this.list.tail = Q2.list.tail;
            this.list.size += Q2.list.size; ///updates size
        }

        Q2.list.head = Q2.list.tail = null; /// becomes empty queue
        Q2.list.size = 0;

    }
    /// MAIN =============================================================================================================
    public static void main(String[] args) {
        Exercise3<Integer> Q1 = new Exercise3<Integer>(); ///creates empty queues
        Exercise3<Integer> Q2 = new Exercise3<Integer>();

        /// Enqueues elements =================================
        Q1.enqueue(1); ///adds element to Q1
        Q1.enqueue(2);
        Q1.enqueue(3);

        Q2.enqueue(4); ///adds element to Q2
        Q2.enqueue(5);
        Q2.enqueue(6);

        /// Original Queues printed out =========================
        System.out.println("Without Concatenation:");
        System.out.println("Q1:" + Q1.list.toString());
        System.out.println("Q2:" + Q2.list.toString());

        Q1.concatenate(Q2); ///calls concatenate method to alter Queues / combines queues together

        /// New Queues printed out =========================
        System.out.println("Concatenating...");
        System.out.println("Q1:" + Q1.list.toString());
        System.out.println("Q2:" + Q2.list.toString());

    }

}

