package NatashyaPeddle_COMP254_Lab4;
import References.Position;
import References.PositionalList;
import References.LinkedPositionalList;
/// IMPORTS REQUIRED FILE ^^^^^ ================================================

///Suppose we want to extend the PositionalList ADT with a method, indexOf(p),
/// that returns the current index of the element stored at position p. Write
///  this method using only other methods of the PositionalList interface
///   (not details of our LinkedPositionalList implementation). Write the
///   necessary code to test the method. Hint: Count the steps while
///    traversing the list until encountering position p.




public class Exercise1<E> {

    public static <E> int indexOf(PositionalList<E> list, Position<E> p) { /// generic class can use any type of param
        /// list = positional list we're searching through
        /// p what we want to find
        int index = 0; ///initalizes counter to current index
        Position<E> walk = list.first(); ///start from first position


        /// LOOP going through list ==========================================================================================
        while (walk != null) { /// traverses down the list until its null / no positions left
            if (walk == p) { /// looks for a match
                return index; ///returns the index position when found
            }
            walk = list.after(walk); ///moves to next position every loop
            index++; ///increment index

        }
        return -1; ///return to -1 if not found
    }


    ///  MAIN ==============================================================
public static void main(String[] args) {
    PositionalList<Integer> list = new LinkedPositionalList<>(); ///makes list

    /// inerts num into list
    Position<Integer> p1 = list.addFirst(1); ///inserts 1 at the start of list and sets position to p1
    Position<Integer> p2 = list.addLast(2); ///inserts num at the end of list and sets position to p2
    Position<Integer> p3 = list.addLast(3); ///inserts num at the end of list and sets position to p3

    /// PRINTS AND FINDS INDEXES ========================================================================
    System.out.println("Index of P1:" + indexOf(list, p1)); ///prints out index of num // output: 0
    System.out.println("Index of P2:" + indexOf(list, p2)); ///prints out index of num // output: 1
    System.out.println("Index of P3:" + indexOf(list, p3)); ///prints out index of num // output: 2

}


}
