package com.example.helloWorld.Leetcode.Coding60;

import org.jetbrains.annotations.NotNull;

import java.util.*;

class Node implements Comparable<Node> {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public int compareTo(@NotNull Node o) {
        return this.val-o.val;
    }
}

public class DuplicateListWithRandomPointer {
    public static void main(String[] args) {
        Node t1=new Node(7);
        Node t2=new Node(13);
        Node t3=new Node(11);
        Node t4=new Node(10);
        Node t5=new Node(1);
        List<Node> n=new ArrayList<>();
        n.add(t1);
        n.add(t2);
        n.add(t3);
        n.add(t4);
        n.add(t5);

        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        t5.next=null;

        t1.random=null;
        t2.random=t1;
        t3.random=t5;
        t4.random=t3;
        t5.random=t2;

        Node copy=copyRandomList(t1);

        System.out.printf("Printing copy list:\n");
        print(t1);
        System.out.printf("Ending copy list:\n");

        Collections.sort(n, Collections.reverseOrder());
        System.out.printf("\nPrinting sorted list:\n");
        for(int i=0;i<n.size();i++){
            System.out.println(n.get(i).val+" "+((n.get(i).random!=null) ? n.get(i).random.val : null));
        }
        System.out.printf("Ending sorted list:\n");

    }

    private static void print(Node head) {
        Node t=head;
        while(t!=null){
            System.out.print(t.val+" ");
            if(t.random!=null)
                System.out.print(t.random.val);
            System.out.println(" ");
            t=t.next;
        }
    }

    public static Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        Node curr=head;
        while(curr!=null){
            Node t=new Node(curr.val);
            hm.put(curr, t);
            curr=curr.next;
        }
        hm.put(null, null);
        curr=head;
        while(curr!=null){
            Node t=hm.get(curr);
            t.next=hm.get(curr.next);
            t.random=hm.get(curr.random);
            curr=curr.next;
        }

        System.out.println("Hashmap started");
        for(Map.Entry<Node, Node> entry : hm.entrySet()) {
            if(entry.getKey()!=null)
                System.out.println(entry.getKey().val+" "+entry.getValue().val);
        }
        System.out.println("Hashmap ended");
        System.out.println(" ");
        return hm.get(head);
    }
}
