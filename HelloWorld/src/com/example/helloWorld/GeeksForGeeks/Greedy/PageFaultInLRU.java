package com.example.helloWorld.GeeksForGeeks.Greedy;


// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class PageFaultInLRU{
    public static void main(String args[])throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int pages[] = new int[N];
            for (int i = 0; i < N; i++)
                pages[i] = Integer.parseInt(input_line[i]);
            int C = Integer.parseInt(read.readLine());

            System.out.println(pageFaults(N, C, pages));
        }
    }

    static int pageFaults(int n, int c, int pages[]){
        HashSet<Integer> s = new HashSet<>(c);
        HashMap<Integer, Integer> indexes = new HashMap<>();

        int page_faults = 0;
        for (int i=0; i<n; i++)
        {
            if (s.size() < c)
            {
                if (!s.contains(pages[i]))
                {
                    s.add(pages[i]);
                    page_faults++;
                }
                indexes.put(pages[i], i);
            }
            else
            {
                if (!s.contains(pages[i]))
                {
                    int lru = Integer.MAX_VALUE, val=Integer.MIN_VALUE;
                    Iterator<Integer> itr = s.iterator();
                    while (itr.hasNext()) {
                        int temp = itr.next();
                        if (indexes.get(temp) < lru)
                        {
                            lru = indexes.get(temp);
                            val = temp;
                        }
                    }
                    s.remove(val);
                    indexes.remove(val);
                    s.add(pages[i]);
                    page_faults++;
                }
                indexes.put(pages[i], i);
            }
        }
        return page_faults;
    }
}