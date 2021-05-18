package com.example.helloWorld.GeeksForGeeks.Hashing;
//https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1 works only with non repeating numbers
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            So sln = new So();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends

class Pair{
    public int first;
    public int second;
    Pair(int f, int s){
        first=f;
        second=s;
    }
}

class So {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Pair> h=new HashMap<>();
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length;j++){
                h.put(arr[i]+arr[j], new Pair(arr[i],arr[j]));
            }
        }

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length;j++){
                if(h.containsKey(k-arr[i]-arr[j])){
                    Pair p=h.get(arr[i]+arr[j]);
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(p.first);
                    temp.add(p.second);
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    Collections.sort(temp);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}
