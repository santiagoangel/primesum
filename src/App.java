
//You are given an integer array.
//Find the number of subarrays with a prime sum.

//solution is on App class and an external version for test this is on GFG class

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Lets's try:");
        Integer question[] = new Integer[] { 3, 7, 4, 5 };
        App app = new App();
        System.out.println("[3, 7, 4, 5 ]");
        System.out.println("numOfPossibleArrays: " + app.numOfPossibleArrays(question));
        System.out.println("");
        app.printSubArrays(question, 0, 0);
        System.out.println("primes: " + app.numberOfPrimeArrays(question));
        System.out.println("");
        Integer question2[] = new Integer[] { 3, 8, 4, 5 };
        System.out.println("[3, 8, 4, 5 ]");
        System.out.println("numOfPossibleArrays: " + app.numOfPossibleArrays(question2));
        app.printSubArrays(question2, 0, 0);
        System.out.println("");
        System.out.println("primes: " + app.numberOfPrimeArrays(question2));

    }

    public int numOfPossibleArrays(Integer input[]) {
        int n = input.length;
        int numOfPossibleArrays = (n * (n + 1)) / 2;
        return numOfPossibleArrays;
    }

    public int numberOfPrimeArrays(Integer input[]) {
        int primes = 0;

        for (int i = 0; i < input.length; i++) {

            Integer current[] = new Integer[input.length - i];
            System.arraycopy(input, i, current, 0, input.length - i);

            int sum = 0;
            for (Integer c : current) {
                sum = sum + c;

            }

            if (isPrime(sum)) {
                primes++;
            }
            if (isPrime(current[0])) {
                primes++;
            }
            sum = 0;

        }
        return primes;
    }

    public boolean isPrime(Integer n) {

        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void printSubArrays(Integer[] array, int start, int end) {
        int[] arr = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
        printSubArrays(arr, start, end);
    }

    public void printSubArrays(int[] arr, int start, int end) {

        // Stop if we have reached the end of the array
        if (end == arr.length)
            return;
        // Increment the end point and start from 0
        else if (start > end)
            printSubArrays(arr, 0, end + 1);
        // Print the subarray and increment the starting
        // point
        else {
            int sum = 0;
            System.out.print("[");
            for (int i = start; i < end; i++) {
                System.out.print(arr[i] + ", ");
                sum = sum + arr[i];
            }
            System.out.println(arr[end] + "]");
            sum = sum + arr[end];
            if (isPrime(sum)) {
                System.out.println("" + sum + " is Prime");

            }
            printSubArrays(arr, start + 1, end);
        }
        return;
    }

}
