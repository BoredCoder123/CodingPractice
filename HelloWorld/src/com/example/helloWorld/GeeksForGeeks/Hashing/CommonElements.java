package com.example.helloWorld.GeeksForGeeks.Hashing;
//https://practice.geeksforgeeks.org/problems/common-elements5420/1
// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class CommonElements {
    public static void main (String[] args) {

        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        //taking total count of testcases
        int t=sc.nextInt();
        while(t-->0)
        {
            //taking total count-1 of elements
            int n=sc.nextInt();

            //Declaring and Initializing an ArrayList-1
            ArrayList<Integer>v1=new ArrayList<>();

            //adding elements to the ArrayList-1
            for(int i=0;i<n;i++)
            {
                v1.add(sc.nextInt());
            }

            //taking total count-2 of elements
            int m=sc.nextInt();

            //Declaring and Initializing an ArrayList-2
            ArrayList<Integer>v2=new ArrayList<>();

            //adding elements to the ArrayList-2
            for(int i=0;i<m;i++)
            {
                v2.add(sc.nextInt());
            }
            S ob = new S();
            //calling the method common_element
            //and passing ArrayList 1, 2 as arguments
            //and storing the results in a new ArrayList
            ArrayList<Integer>ans=ob.common_element(v1, v2);

            //printing the elements of the new ArrayList
            for(int i:ans)
                System.out.print(i+" ");

            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class S{
    public ArrayList<Integer> common_element(ArrayList<Integer>v1, ArrayList<Integer>v2){
        ArrayList<Integer> ans= new ArrayList<>();
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<v1.size();i++){
            h.add(v1.get(i));
        }
        for(int i=0;i<v2.size();i++){
            if(h.contains(v2.get(i))){
                ans.add(v2.get(i));
            }
        }
        Collections.sort(ans);
        return ans;
    }
}