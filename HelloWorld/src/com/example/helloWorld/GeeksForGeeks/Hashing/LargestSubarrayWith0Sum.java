package com.example.helloWorld.GeeksForGeeks.Hashing;
//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
import java.util.*;

public class LargestSubarrayWith0Sum {
    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

        int sum=0;
        int maxLen=0, i;

        for(i=0;i<n;i++){
            sum+=arr[i];
            if(arr[i]==0 && maxLen==0)
                maxLen=1;
            if(sum==0)
                maxLen=i+1;

            Integer prevI=h.get(sum);

            if(prevI!=null)
                maxLen=Math.max(maxLen, i-prevI);
            else
                h.put(sum, i);
        }
        return maxLen;
    }
}