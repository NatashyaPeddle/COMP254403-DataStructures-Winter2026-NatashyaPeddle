public class NATASHYAPEDDLE_LAB3_Exercise1 {
    /// Create a recursive algorithm to compute the product of two positive integers, m and n, using only
    ///addition and subtraction. Implement the Java or Python code. Hint: You need subtraction to count down from
    ///m or n and addition to do the arithmetic needed to get the right answer. Check linearSum method from Week 5 examples.


/// write from scratch
    /// linearsum method in week 5 examples



    /** Creates recursive algorithm to compute the product of two positive integers, m and n */
    public static int recursiveCalculation(int m, int n) { /// takes m and n ints
        if (n == 0) /// if 0 then sum is 0
            return 0;
        else
            return recursiveCalculation(m, n-1) + m; ///m added n times
        /// calls method, n decreased by 1 (counts down), m adds to result of smaller problem

        /// must use subtraction and addition
        /// subtraction: n-1 = counts down each call towards base
        /// Addition: + m = adds the product
    }



    /// MAIN---------------------------------------------------------------------------------
    public static void main(String[] args) {


        for(int m = 1; m <= 10; m++){ /// iterates 1-10, tests recursive multiplication for values of m
            for(int n = 1; n <= 10; n++){ /// inner loop iterates 1-10, tests combinations of m and n
                System.out.print(recursiveCalculation(m, n)); /// calls method and prints product of m and n
                int recursive = recursiveCalculation(m, n); ///stores above result / product in variable "recursive"
                System.out.println(" "); ///space
                int answer = m * n; /// calculates product by multiplying used for comparison ref
                if (recursive != answer) { /// uses the comparison ref to see if its different then the recursive result
                    System.out.println("Problem with calculation");
                }

            }
            System.out.println("------------------------");
            System.out.println("Calculation Successful");
            System.out.println("------------------------");
        }

//        for (int limit = 1; limit < 100; limit++) {
//            int[] data = new int[limit];
//            for (int k=0; k < limit; k++)
//                data[k] = k+1;
//            int answer = limit * (limit + 1) / 2;
//
//            int linear = linearSum(data, limit);
//            if (linear != answer)
//                System.out.println("Problem with linear sum for n=" + limit);
//
//
//        }
    }




}
