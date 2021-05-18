package com.example.helloWorld.GeeksForGeeks.LinkedList;

import java.io.*;
import java.util.*;
import com.example.helloWorld.GeeksForGeeks.LinkedList.Node;

public class MiddleOfLinkedList {

    public static void callMiddleOfLinkedList() throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            int ans = getMiddle(head);
            System.out.println(ans);
//            Node.printList(head);
            t--;
        }
    }

    private static int getMiddle(Node head)
    {
        int cnt=0, midcnt=0;
        Node curNode=head;
        while(curNode!=null){
            midcnt++;
            curNode=curNode.next;
        }
        midcnt/=2;
        curNode=head;
        while(cnt<midcnt){
            cnt++;
            curNode=curNode.next;
        }
        return curNode.data;
    }
}