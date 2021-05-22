package com.example.helloWorld.Leetcode.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MeetingRoom2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        sc.nextLine();
        int[][] arr= new int[n][2];
        int i;
        for(i=0;i<n;i++){
            String[] s = sc.nextLine().split(" ");
            arr[i][0]=Integer.parseInt(s[0]);
            arr[i][1]=Integer.parseInt(s[1]);
        }
        System.out.println(meetingRoom2(arr));
    }

    static int meetingRoom2(int[][] times){
        int curr=0, max=0, n=times.length, i;
        if(n==0)
            return 0;
        Arrays.sort(times, (a,b)-> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(i=0;i<n;i++){
            if(pq.isEmpty()){
                curr=1;
                max=Math.max(curr, max);
            }
            if(!pq.isEmpty() && times[i][0]<pq.peek()){
//                System.out.println("1 "+curr+" "+pq.peek()+" "+times[i][0]);
                curr++;
                Math.max(curr, max);
            }else if(!pq.isEmpty() && times[i][0]>=pq.peek()){
//                System.out.println("2 "+curr+" "+pq.peek()+" "+times[i][0]);
                while(!pq.isEmpty() && times[i][0]>=pq.peek()){
                    pq.poll();
                    curr--;
                }
//                System.out.println(curr);
                curr++;
                max=Math.max(curr, max);
            }
            pq.add(times[i][1]);
        }
        return max;
    }
}
