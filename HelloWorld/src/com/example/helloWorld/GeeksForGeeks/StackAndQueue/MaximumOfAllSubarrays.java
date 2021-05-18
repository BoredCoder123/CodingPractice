package com.example.helloWorld.GeeksForGeeks.StackAndQueue;
//https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
import java.util.*;

public class MaximumOfAllSubarrays {

    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        //taking total count of testcases
        int t = sc.nextInt();



        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();

            //taking size of subArrays
            int k = sc.nextInt();

            //Declaring and Intializing an array of size n
            int arr[] = new int[n];

            //adding all the elements to the array
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }

            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = max_of_subarrays(arr, n, k);

            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }

    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {

        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < k; ++i)
        {

            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >=
                    arr[Qi.peekLast()])

                // Remove from rear
                Qi.removeLast();

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i)
        {

            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <=
                    i - k)
                Qi.removeFirst();

            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty()) && arr[i] >=
                    arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window

        ArrayList<Integer> a=new ArrayList<>();
        a.add(arr[Qi.peek()]);
        return a;
    }
}