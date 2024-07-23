// Ilano, Carylle Keona D. & Tan, Jam Meisy F.
// ICS 2605 - 1CSC
// Lab Exercise 1

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LabEx1 {
    static Scanner in = new Scanner(System.in);
    static Random rng = new Random();
    public static void main(String[] args)
    {
        //Step 3a. Member Names:
        System.out.println("Ilano, Carylle Keona D. & Tan, Jam Meisy F.");

        //Step 3b. Prompts the user to input a positive integer t
        //Alternative 1: Scanner Class
        System.out.print("""
            LabEx1
            -------------------------------------------------------------------
            1 - Fibonacci Sequence (Iterative)
            2 - Fibonacci Sequence (Recursive)
            3 - Shuffling an Array with Random Numbers
            4 - Sorting an Array with Random Numbers (Insertion Sort)
            5 - Fibonacci Sequence (Recursive)
            6 - Shuffling an Array with Random Numbers for K Elements
            7 - Sorting an Array with Random Numbers for K Elements (Insertion Sort)
            -------------------------------------------------------------------
            Enter a method number:\s""");

        //Validates the user input if valid
        int t = validate(in.nextInt());
        System.out.println("Selected Number: " + t);

        //Step 3c. Prompts the user to input a positive integer n
        System.out.print("\nInput n: ");
        int n = in.nextInt();

        //Step 3c. Initialization for Part 2
        int[] array_3_4 = new int[n];
        if (t == 3 || t == 4)
            for (int i = 0; i < n; i++)
                array_3_4[i] = rng.nextInt(10000);

        //Step 3c. Initialization for Part 3
        int maxTime = n;
        int[] array_6_7 = new int[100_000_000];
        if (t == 6 || t == 7)
            for (int i = 0; i < 100_000_000; i++)
                array_6_7[i] = rng.nextInt(10000);


        System.out.print("\nMethod called: ");
        switch (t)
        {
            case 1 -> System.out.println("fib()");
            case 2, 5 -> System.out.println("fibR()");
            case 3, 6 -> System.out.println("shuffleR()");
            case 4, 7 -> System.out.println("insertionSort()");
        }

        switch (t)
        {
            case 1, 2 -> {
                System.out.println("[Arguments passed] ");
                System.out.printf("nth Term: %d", n);
            }
            case 3, 4 -> {
                System.out.println("[Arguments passed] ");
                System.out.printf("""
                    Starting Index: %d
                    Ending Index: %d
                    Array: %s""", 0, n - 1, Arrays.toString(array_3_4));
            }
        }

        int term = 0, k = 0;
        long start = 0, current = 0, end = 0;
        switch (t)
        {
            case 1 -> {
                start = System.nanoTime();
                term = fib(n);
                end = System.nanoTime();
                System.out.printf("\n\nTerm %d in Fibonacci sequence: %d", n, term);
            }
            case 2 -> {
                start = System.nanoTime();
                term = fibR(n);
                end = System.nanoTime();
                System.out.printf("\n\nTerm %d in Fibonacci sequence: %d", n, term);
            }
            case 3 ->
            {
                start = System.nanoTime();
                shuffleR(array_3_4, 0, n - 1);
                end = System.nanoTime();
                System.out.printf("\n\nShuffled Array: %s", Arrays.toString(array_3_4));
            }
            case 4 ->
            {
                start = System.nanoTime();
                mergeSort(array_3_4, 0, n - 1);
                end = System.nanoTime();
                System.out.printf("\n\nSorted Array: %s", Arrays.toString(array_3_4));
            }
            case 5 -> {
                start = System.nanoTime();
                while ((current - start)/(double)1_000_000_000 < maxTime)
                {
                    k++;
                    System.out.printf("k = %d", k);
                    fibR(k);
                    System.out.println(";");
                    current = System.nanoTime();
                }
            }
            case 6 ->
            {
                start = System.nanoTime();
                while ((current - start)/(double)1_000_000_000 < maxTime)
                {
                    k++;
                    for (int i = 0; i < k; i++)
                        array_6_7[i] = rng.nextInt(10000);
                    System.out.printf("k = %d", k);
                    shuffleR(array_6_7, 0, k);
                    System.out.println(";");
                    current = System.nanoTime();
                }
            }
            case 7 ->
            {
                start = System.nanoTime();
                while ((current - start)/(double)1_000_000_000 < maxTime)
                {
                    k++;
                    for (int i = 0; i < k; i++)
                        array_6_7[i] = rng.nextInt(10000);
                    System.out.printf("k = %d", k);
                    insertionSort(array_6_7, 0, k);
                    System.out.println(";");
                    current = System.nanoTime();
                }
            }
        }

        //Finds the elapsed time in milliseconds:
        if (t >= 1 && t <= 4)
            System.out.printf("\nTime elapsed: %f ms", (end - start) / (double) 1000000);
        //Takes note of k for given maxTime seconds
        else
        {
            System.out.printf("\nTime elapsed: %f s", (current - start) / (double) 1000000000);
            System.out.printf("\nk for Max Time (%ds): %d", maxTime, k);
        }
    }
    static int validate(int x)
    {
        while (x < 1 || x > 7)
        {
            System.out.print("Invalid Input! Please try again: ");
            x = in.nextInt();
        }
        return x;
    }
    public static int fib(int n)
    {
        int temp1 = 0, temp2 = 1, term = 0;
        if (n == 0)
            return 0;
        for (int i = 1; i < n; i++) {
            term = temp1 + temp2;
            temp1 = temp2;
            temp2 = term;
        }
        return term;
    }
    public static int fibR(int n)
    {
        if (n <= 1)
            return n;
        return fibR(n - 1) + fibR(n - 2);
    }
    public static void shuffleR(int[] array, int left, int right)
    {
        if (left == right)
            return;

        int temp = array[right];
        int temp_index = rng.nextInt(right - left + 1);

        array[right] = array[temp_index];
        array[temp_index] = temp;

        shuffleR(array, left, right-1);
    }
    public static void insertionSort(int[] array, int left, int right)
    {
        int i, j, temp;
        for (i = left + 1; i <= right; i++) {
            temp = array[i];
            for (j = i - 1; j >= left && array[j] > temp ; j--)
                array[j + 1] = array[j];
            array[j + 1] = temp;
        }
    }
    static void mergeSort(int[] array, int i, int j) {
        if (i < j) {
            int mid = (i + j)/2;
            mergeSort(array, i, mid);
            mergeSort(array, mid + 1, j);
            merge(array, i, mid, j);
        }
    }
    static void merge(int[] array, int left, int mid, int right) {
        int[] merging = new int[right - left + 1];
        int index = 0, lcount = left, rcount = mid + 1;
    /*
				Placing values in order by comparing the start of the data
		in the left half or right half.

				Increments the index of left half or right half to compare
		the next set of values.

				Code stops when either half is finished.
	*/
        while (lcount <= mid && rcount <= right)
            merging[index++] = (array[lcount] <= array[rcount])?
                    array[lcount++] : array[rcount++] ;

    /*
				Detects which half has remaining values, and adds it to the
		rest of the spots.
			  This is plausible since in recursion the array is already
		sorted.
				When either half is finished, the remaining spaces contain
		the highest values in sorted order.
	*/

        if (lcount > mid)
            while ( rcount <= right )
                merging[index++] = array[rcount++];
        else
            while (lcount <= mid)
                merging[index++] = array[lcount++];

        // Copies the small sorted merging-array to the original array
        for (index = 0 ; index < right-left+1 ; index++)
            array[left + index] = merging[index];
    }
}
