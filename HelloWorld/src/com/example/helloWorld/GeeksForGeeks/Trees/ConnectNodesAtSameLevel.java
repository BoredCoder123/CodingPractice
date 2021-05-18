package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class ConnectNodesAtSameLevel {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = Node.buildTree(s);
            connect(root);
            printSpecial(root);
            System.out.println();
            Node.printInorder(root);
            System.out.println();
            t--;

        }
    }

    private static void connect(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node p=q.poll();
            if(p!=null){
                p.nextRight=q.peek();
                if(p.left!=null)
                    q.add(p.left);
                if(p.right!=null)
                    q.add(p.right);
            }else if(!q.isEmpty()){
                q.add(null);
            }
        }
    }

    public static void printSpecial(Node root)
    {
        if (root == null)
            return;

        Node next_root=null;

        while (root != null)
        {
            System.out.print(root.data+" ");

            if( root.left!=null && next_root==null )
                next_root = root.left;
            else if( root.right!=null && next_root==null  )
                next_root = root.right;

            root = root.nextRight;
        }

        printSpecial(next_root);
    }
}

