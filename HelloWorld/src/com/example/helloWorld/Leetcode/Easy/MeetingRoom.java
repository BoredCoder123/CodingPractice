package com.example.helloWorld.Leetcode.Easy;
//https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/
import java.util.*;

public class MeetingRoom {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int[] start= new int[n];
        int[] end= new int[n];
        String[] s=sc.nextLine().split(" ");
        String[] e=sc.nextLine().split(" ");
        for(int i=0;i<n;i++){
            start[i]=Integer.parseInt(s[i]);
            end[i]=Integer.parseInt(e[i]);
        }

        int ans = new MeetingRoom().meetingRoom(start, end);
        System.out.println(ans);

    }

    class Pair{
        int start, end;
        Pair(int s, int e){
            start=s;
            end=e;
        }
    }

    public int meetingRoom(int[] start, int[] end){
        int ans=1, i, j;
        int n=start.length;
        Pair[] p = new Pair[n];
        for(i=0;i<n;i++){
            p[i]=new Pair(start[i], end[i]);
        }
        Arrays.sort(p, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.end - p2.end;
            }
        });

        for(i=1, j=0;i<n;i++){
            if(p[j].end <=p[i].start) {
                ans++;
                j=i;
            }
        }

        return ans;
    }
}