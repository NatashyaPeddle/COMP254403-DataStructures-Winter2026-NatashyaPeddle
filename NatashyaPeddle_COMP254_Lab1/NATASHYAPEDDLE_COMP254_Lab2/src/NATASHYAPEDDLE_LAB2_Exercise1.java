class NATASHYAPEDDLE_LAB2_Exercise1 {
/// EXAMPLE 1 -------------------------------------------------------------------------------------
    /** Returns the sum of the integers in given array. */
    public static int example1(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++)       // loop from 0 to n-1
        /// n-1 just means its saying within the index
            total += arr[j];
        return total;
    }

    /// Characterization: O(n) = Linear Time
    /// Explanation: one loop, runs once from 0 to n-1 = Linear time
    /// Each iteration does constant work and time grows in line with n




    /// EXAMPLE 2 -------------------------------------------------------------------------------------
    /** Returns the sum of the integers with even index in given array. */
    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j += 2)    // note the increment of 2
            total += arr[j];
        return total;
    }
    /// Characterization: O(n) = Linear Time
    /// Explanation: one loop, (incremented by 2 but still only 1 loop) = Linear time
    /// Each iteration does constant work and time grows in line with n
    /// Does the incrementation do anything to running time?? Anything to do with Logarithmic time?


    /// EXAMPLE 3 -------------------------------------------------------------------------------------
    /** Returns the sum of the prefix sums of given array. */
    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++)       // loop from 0 to n-1
            for (int k=0; k <= j; k++)    // loop from 0 to j
                total += arr[j];
        return total;
    }
    /// Characterization: O(n^2) = Quadratic Time
    /// Explanation: Nested loop (2 loops, outer loop runs n times x inner loop runs n times) = n x n = Quadratic time


/// EXAMPLE 4 -------------------------------------------------------------------------------------
    /** Returns the sum of the prefix sums of given array. */
    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j=0; j < n; j++) {     // loop from 0 to n-1
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }
    /// Characterization: O(n) = Linear Time
    /// Explanation: one loop, runs once from 0 to n-1 = Linear time
    /// Each iteration does constant work and time grows in line with n

    /// EXAMPLE 5 -------------------------------------------------------------------------------------
    /** Returns the number of times second array stores sum of prefix sums from first. */
    public static int example5(int[] first, int[] second) { // assume equal-length arrays
        int n = first.length, count = 0;
        for (int i=0; i < n; i++) {     // loop from 0 to n-1
            int total = 0;
            for (int j=0; j < n; j++)     // loop from 0 to n-1
                for (int k=0; k <= j; k++)  // loop from 0 to j
                    total += first[k];
            if (second[i] == total) count++;
        }
        return count;
    }

}
/// Characterization: O(n^3) = Cubic Time
/// Explanation: Nested Loops = 2, 3 loops total, Outer loop n times x middle loop n times x inner loop n times - n x n x n = Cubic time
/// OR O(n^2) x n = O(n^3)
