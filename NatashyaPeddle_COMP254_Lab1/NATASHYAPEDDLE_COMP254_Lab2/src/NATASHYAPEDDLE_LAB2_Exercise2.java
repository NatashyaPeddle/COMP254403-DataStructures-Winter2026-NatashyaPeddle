public class NATASHYAPEDDLE_LAB2_Exercise2 {

    /// ---- prefixAverage1 -----------------------------------------------------------------------------------------------
    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */


    /// *****DETERMINES LAYOUT OF METHOD: PrefixAverage1 *****************************************
    public static double[] prefixAverage1(double[] x) { /// creates method that takes double array
        int n = x.length; /// stores length of input array
        double[] a = new double[n];    /// filled with zeros by default - stores the prefix averages
        for (int j=0; j < n; j++) { /// LOOP 1 - goes J:0 to n-1
            double total = 0;            /// begin computing x[0] + ... + x[j] - for each j create double total. sum of elements from those 2 points
            for (int i=0; i <= j; i++) /// LOOP 2 - goes i:0 to j,
                total += x[i]; ///add x[i] to total
            a[j] = total / (j+1);        // record the average
        }
        return a; ///result array - returns array to any calls
    }
    /// Characterization: O(n^2) = Quadratic Time
    /// Explanation: Nested loop (2 loops, outer loop runs n times x inner loop runs n times) = n x n = Quadratic time


    /// ---- prefixAverage2 -------------------------------------------------------------------------------------------------
    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */

    /// *****DETERMINES LAYOUT OF METHOD: PrefixAverage2 *****************************************
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];    // filled with zeros by default
        double total = 0;              // compute prefix sum as x[0] + x[1] + ...
        for (int j=0; j < n; j++) { /// ONLY 1 LOOP
            total += x[j];               // update prefix sum to include x[j]
            a[j] = total / (j+1);        // compute average based on current sum
        }
        return a; ///result array - returns array to any calls
    }
    /// Characterization: O(n) = Linear Time
    /// Explanation: one loop, runs once from 0 to n-1 = Linear time





/// MAIN -------------------------------------------------------------------------------------------------------------------

public static void main(String[] args) {
    int n = 1000; ///starting size = representative values
    int trials = 5; ///5 attempts to test code

    /// checks for errors
    try {
        if (args.length > 0)
            trials = Integer.parseInt(args[0]);
        if (args.length > 1)
            n = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) { }

    int start = n;  // remember the original starting value

    /// testing prefixaverage2 - Linear time----------------------------------------------
    System.out.println("Testing prefixaverage2 O(n)...");

    for (int t=0; t < trials; t++) {
        double[] data = new double[n]; /// filled with zeroes
        prefixAverage2(data); ///method call with zero filled array = Warm up call

        long startTime = System.currentTimeMillis(); ///start timer

        prefixAverage2(data); ///callls / runs algorthim

        long endTime = System.currentTimeMillis(); ///end timer
        long elapsed = endTime - startTime; ///determines length or process in milliseconds

        System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
        n *= 2; ///doubles input for next try, shows how runtime grows as input size grows
    }

    /// testing prefixaverage1 - Quadratic time------------------------------------------------------------
    System.out.println("Testing prefixaverage1 O(n^2)...");

    n = start;                               // restore n to its start value
    for (int t=0; t < trials; t++) {
        double[] data = new double[n]; ///filled with zeroes

        prefixAverage1(data);///method call with zero filled array = Warm up call

        long startTime = System.currentTimeMillis(); ///start timer

        prefixAverage1(data); /// callls / runs algorthim

        long endTime = System.currentTimeMillis(); ///end timer

        long elapsed = endTime - startTime;///determines length or process in milliseconds

        System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
        n *= 2; ///doubles input for next try, shows how runtime grows as input size grows
    }
}
}





