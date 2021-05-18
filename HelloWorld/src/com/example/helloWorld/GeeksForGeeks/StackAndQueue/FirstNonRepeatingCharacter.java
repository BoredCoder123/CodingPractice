package com.example.helloWorld.GeeksForGeeks.StackAndQueue;
//https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0
import java.util.*;
import java.lang.*;
import java.io.*;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String A = br.readLine().trim();
            String ans = FirstNonRepeating(A);
            System.out.println(ans);
        }
    }

    public static String FirstNonRepeating(String a) {
        Queue<Character> q = new LinkedList<>();
        int[] charCount = new int[26];
        String ans = "";
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            q.add(c);
            charCount[(int) c - (int) 'a']++;
            while (!q.isEmpty()) {
                if (charCount[(int) q.peek().charValue() - (int) 'a'] > 1) {
                    q.remove();
                } else {
                    ans += q.peek().charValue();
                    break;
                }
            }
            if (q.isEmpty())
                ans += '#';
        }
        return ans;
    }
}