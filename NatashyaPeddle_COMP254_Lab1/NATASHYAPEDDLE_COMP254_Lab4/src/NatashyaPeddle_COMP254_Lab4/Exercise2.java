package NatashyaPeddle_COMP254_Lab4;

import java.util.Stack;

///Implement a method with signature transfer(S, T)
///  that transfers all elements from stack S onto stack T,
/// so that the element that starts at the top of S is the
///  first to be inserted onto T, and the element at the
/// bottom of S ends up at the top of T. Write the necessary code to test the method.



public class Exercise2<E> extends Stack<E> {

        public static final int CAPACITY=1000;   /// default array capacity = size of array

        private E[] data;                        /// generic array used for storage = is array storing elements

        private int t = -1;                      /// index of the top element in stack = top element

        public Exercise2() { this(CAPACITY); }  /// constructs stack with default capacity =

        @SuppressWarnings({"unchecked"})
        public Exercise2(int capacity) {        // constructs stack with given capacity
            data = (E[]) new Object[capacity];     // safe cast; compiler may give warning
        }

        @Override
        public int size() { return (t + 1); } ///Returns the number of elements in the stack.

        @Override
        public boolean isEmpty() { return (t == -1); } /// Tests whether the stack is empty.

        /// CHECKS IF STACK IS FULL =================================================================
    public E push(E e) throws IllegalStateException {
            if (size() == data.length) throw new IllegalStateException("Stack is full"); ///if the array storing the elements is full
            data[++t] = e;                           /// increment t before storing new item ///Inserts an element at the top of the stack.
        return e; ///returns pushed element
    }


    public E Top() throws IllegalStateException {
        return null;
    }


        /// Returns top element without removing it ===================================================================
        public E top() { ///  Returns, but does not remove, the element at the top of the stack.
            if (isEmpty()) return null; ///top element in the stack (or null if empty)
            return data[t]; ///returns data
        }


        /// Removes and returns the top element from the stack =========================================================
        public E pop() {
            if (isEmpty()) return null; ///element removed (or null if empty)
            E answer = data[t]; ///stores data in answer
            data[t] = null;                        // dereference to help garbage collection
            t--; ///decremenets t
            return answer; /// returns answer
        }

        /// TO STRING==================================================================
        /// converts to string
        public String toString() { /// Converts to string
            StringBuilder sb = new StringBuilder("("); ///adds bracket
            for (int j = t; j >= 0; j--) { /// Loop
                sb.append(data[j]);
                if (j > 0) sb.append(", "); ///adds comma between elements
            }
            sb.append(")"); ///adds bracket
            return sb.toString();
        }

        /// TRANSFER METHOD ===============================================
        public static <E> void transfer (Stack<E> S, Stack<E> T){
            Stack<E> temp = new Stack<>(); ///creates temp stack to reverse order so that elements are inserted correctly onto t
            /// ^^^^ and so that element bottom of s ends up on top of t

            while(!S.isEmpty()){ /// pops elements from s and pushes them onto temp
                temp.push(S.pop()); ///reverses order of elements
            }

            while(!temp.isEmpty()){ /// pops elements from temp and pushes them onto t
                T.push(temp.pop()); ///reverses order of elements
            }
        }


        /** Demonstrates sample usage of a stack. */
        public static void main(String[] args) {
            Stack<Integer> S = new Exercise2<>();  /// creates new empty stack S
            Stack<Integer> T = new Exercise2<>(); /// creates new empty stack T

            ///Adds / pushes elements to stack S =========================================
            S.push(1);
            S.push(2);
            S.push(3); // contents: (1, 2, 3)
            /// bottom = 1 > top = 3


            ///Adds / pushes elements to stack T ======================================================
            T.push(4);
            T.push(5);
            /// bottom = 4 > top = 5

            /// prints out original list============================================================
            System.out.println("Without Transfer:");
            System.out.println("S:" + S);
            System.out.println("T:" + T);

            transfer(S,T); ///calls transfer method to transfer elements to new stack

            /// prints out new lists of transferrred elements ====================================
            System.out.println("Transferring...");
            System.out.println("S:" + S);
            System.out.println("T:" + T);

            ///prints out number of elements of final list =================================================
            System.out.println("Counting...");
            System.out.println("Output:" + T.size());


        }
    }



