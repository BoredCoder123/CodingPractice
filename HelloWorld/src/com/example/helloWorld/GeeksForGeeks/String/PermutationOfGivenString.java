package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
import java.util.*;
import java.lang.*;
import java.io.*;

public class PermutationOfGivenString {
    public static void callPermutationOfGivenString() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            List<String> ans = find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();

        }
    }

    public static List<String> find_permutation(String s) {
        List<String> ans=new ArrayList<String>();
        char[] arr=s.toCharArray();
        Arrays.sort(arr);

        while(true){
            ans.add(new String(arr));

            if(!permute(arr))
                break;
        }
        return ans;
    }

    private static boolean permute(char[] arr){
        int i=arr.length-1;
        while(arr[i-1]>=arr[i]){
            if(--i==0)
                return false;
        }

        int j=arr.length-1;
        while(j>i && arr[j]<=arr[i-1]){
            j--;
        }

        swap(arr, i-1,j);
        reverse(arr,i);
        return true;
    }

    private static void swap(char[] arr, int i, int j){
        char ch=arr[i];
        arr[i]=arr[j];
        arr[j]=ch;
    }

    private static void reverse(char[] chars, int start)
    {
        for (int i = start, j = chars.length - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }
    }
}
