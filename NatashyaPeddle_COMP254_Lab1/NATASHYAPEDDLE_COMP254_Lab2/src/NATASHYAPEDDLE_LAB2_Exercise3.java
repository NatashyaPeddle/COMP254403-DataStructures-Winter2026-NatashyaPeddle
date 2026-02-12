import java.util.Arrays;

class NATASHYAPEDDLE_LAB2_Exercise3 {

    /** Returns true if there are no duplicate elements in the array. */

    /// UNIQUE 1 --------------------------------------------------------------------------------------------------
    /// ***GENERAL STRUCTURE / LAYOUT OF UNIQUE METHODS - CHECKS TO MAKE SURE N ARRAY HAS NO DUPLICATES***
    public static boolean unique1(int[] data) { /// takes in array
        int n = data.length; ///stores int size
        for (int j=0; j < n-1; j++) /// j starts at index 0, stops at n-2,
            for (int k=j+1; k < n; k++) /// k starts at one position after j, compares j data with all elements after it
                if (data[j] == data[k]) /// comparison of elements / checks for duplicates
                    return false;                    // found duplicate pair
        /// returns false if there's duplicates
        return true;                           // if we reach this, elements are unique
    }
    /// 0(n^2) - QUADRATIC TIME = nxn (2 loops)


     /// UNIQUE 2 --------------------------------------------------------------------------------------------------
    /** Returns true if there are no duplicate elements in the array. */
    public static boolean unique2(int[] data) {/// takes in array
        int n = data.length; ///stores int size
        int[] temp = Arrays.copyOf(data, n);   /// make copy of data ///sorting modifies array, by taking copy it doesnt
        Arrays.sort(temp);                     /// and sort the copy = duplicates become neighbors if they are duplicates
        for (int j=0; j < n-1; j++)
            if (temp[j] == temp[j+1])            /// check neighboring entries for duplicates - for example if you had two 1s out of 13421 it would put them 11234
                return false;                      // found duplicate pair
        /// returns false if there's duplicates
        return true;                           // if we reach this, elements are unique
    }

    /// sort / takes copy = O(n log n) = N LOG N


    /// stops algorthium from going over 1 min-------------------------------------------------------------
    ///
    /// *** WHEN GIVEN AN "N" VALUE IT CREATES AN ARRAY AND CHECKS WHETHER OR NOT ITS UNDER 1 MINUTE - HELPER METHOD
    public static boolean unique1MinCheck(int n) { /// check if  runs under one min for size n
        int[] data = new int[n]; /// creates arrau
        for(int i=0; i<n; i++) data[i] = i; /// makes sure its unique
        long start = System.currentTimeMillis(); ///stores current time in milliseconds
        unique1(data); ///calls /runs algorthim
        long end = System.currentTimeMillis(); ///asks what time it is currently / returns time in milliseconds / how long it took to run
        return (end - start) < 60000; ///returns true if under a minute
    }
    public static boolean unique2MinCheck(int n) { /// check if  runs under one min for size n
        int[] data = new int[n]; /// creates arrau
        for(int i=0; i<n; i++) data[i] = i; /// makes sure its unique
        long start = System.currentTimeMillis(); ///stores current time in milliseconds
        unique2(data); ///calls /runs algorthim
        long end = System.currentTimeMillis(); ///asks what time it is currently / returns time in milliseconds / how long it took to run
        return (end - start) < 60000; ///returns true if under a minute
    }
    /// FIND MAX value in one min -----------------------------------------------------------
    /// *** USING 1 MIN CHECK IT LOOKS FOR THE LARGEST "VALID" VALUE TO RETURN***
    public static int unique1Max(){
        int low = 1;
        int high = 1; ///assign values

        /// find upper bound ------------------ checks until 1 min mark
        while(unique1MinCheck(high)){ /// keep doubling until it becomes it hits the minute mark
            high *= 2;

            /// high is the value that fails (too long)
        /// low becomes the last working value before failture
        }

       /// binary Search----------------------------------------------------------------
        while(low <= high){ /// answer is between high (failure) and low (as checked in previous while loop)
            int mid = low + (high - low) / 2; ///prevents overflow
        /// mid is temporary value to test for the highest valid value without breaching the 1 min mark

            if(unique1MinCheck(mid)) { /// if under 1 min true
                low = mid + 1; ///mid is true - still under a minute, try larger values

            } else { /// if under 1 min false

                high = mid - 1; ///mid is too slow go smaller values
            }

        }
        return high; /// largest valid value
        /// low = first invalid value
    }


    public static int unique2Max(){
        int low = 1;
        int high = 1; ///assign values

        /// find upper bound
        while(unique2MinCheck(high)){ /// keep doubling until it becomes it hits the minute mark
            high *= 2;

            /// high is the value that fails (too long)
            /// low becomes the last working value before failture
        }
        /// binary Search
        while(low <= high){ /// answer is between high (failure) and low (as checked in previous while loop)
            int mid = low + (high - low) / 2; ///prevents overflow

            if(unique2MinCheck(mid)) { /// if under 1 min true
                low = mid + 1; ///mid is true - still under a minute, try larger values

            } else { /// if under 1 min false

                high = mid - 1; ///mid is too slow go smaller values
            }

        }
        return high; /// largest valid value
        /// largest valid value
    }


    /// MAIN -------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int n = 1000;     ///start at 1000
        int trials = 15; ///15 attempts


        /// error catching
        try {
            if (args.length > 0)
                trials = Integer.parseInt(args[0]);
            if (args.length > 1)
                n = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
        }

        int start = n;  // remember the original starting value

        /// testing unique 2 - N LOG N----------------------------------------------
        System.out.println("Testing Unique 2 N LOG N...");

        for (int t = 0; t < trials; t++) { /// runs 10 times

            int[] data = new int[n]; /// filled with zeroes - creates array,

            for( int i = 0; i < n; i++ ) data[i] = i;

            long startTime = System.currentTimeMillis(); ///starts timer

            unique2(data); /// calls/ runs algorthim

            long endTime = System.currentTimeMillis(); ///ends timmer and returns time

            long elapsed = endTime - startTime; ///determines how long it took to run / start-end = mid width time

            System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed)); ///shows how long it took
            n *= 2; /// double the problem size - shows runtime growth as input grows
        }

        /// testing unique 1 - Quadratic timee------------------------------------------------------------
        System.out.println("Testing Unique 1  O(n^2)...");

        n = start;                               // restore n to its start value

        for (int t = 0; t < trials; t++) { /// 10 attempts

            int[] data = new int[n]; ///filled with zeroes - creates array

            for( int i = 0; i < n; i++ ) data[i] = i;

            long startTime = System.currentTimeMillis(); ///start timer

            unique1(data); /// calls/ runs algorthim

            long endTime = System.currentTimeMillis(); ///end timer and return time\

            long elapsed = endTime - startTime; ///determines how long it took to run / start-end = mid width time

            System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed)); ///shows how long it took
            n *= 2; /// double the problem size - shows runtime growth as input grows
        }

        /// binary search ----------------------------------
        System.out.println("Binary Search: Unique 1..." + unique1Max());
        System.out.println("Binary Search: Unique 2..." + unique2Max());

    }

}

/// QUESTIONS ----------------------------------------

///Which out of Unique 1 or Unique 2 solve the element uniqueness problem?
/// both check for duplicates

/// preform experiment analysis to determine the largest value of n within the time that the algorthum runs in 1 min or less
///Do binary search to determine maximum effective value of n for each algorthm