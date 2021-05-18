package com.example.helloWorld.GeeksForGeeks.Recursion;
//https://practice.geeksforgeeks.org/problems/combination-sum-part-21208/1
// { Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class CombinationalSum{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            int B = Integer.parseInt(read.readLine());

            S ob = new S();
            List<List<Integer>> result = new ArrayList<>();
            result = ob.combinationSum(A, N, B);
            if(result.size() == 0)
                System.out.println("Empty");
            else{
                for(int i = 0;i < result.size(); i++){
                    System.out.print("(");
                    for(int j = 0;j < result.get(i).size();j++){
                        System.out.print(result.get(i).get(j));
                        if(j != result.get(i).size() - 1)
                            System.out.print(" ");
                    }
                    System.out.print(")");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for java
class S
{
    static List<List<Integer>> combinationSum(int A[], int N, int B)
    {
        List<List<Integer>> ans=new ArrayList<>();

        Arrays.sort(A);

        List<Integer> temp = new ArrayList<>();

        findSum(ans, A, B, 0, temp);
        return ans;
    }

    static void findSum(List<List<Integer>> ans, int[] arr, int sum, int index, List<Integer> temp){
        if(sum==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<arr.length;i++){
            if((sum-arr[0])>=0){
                temp.add(arr[i]);
                findSum(ans, arr, sum-arr[i], i+1, temp);
                temp.remove(Integer.valueOf(arr[i]));
            }
        }
    }
}
