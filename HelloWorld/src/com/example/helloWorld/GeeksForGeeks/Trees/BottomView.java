package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class BottomView {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s = br.readLine();
            Node root = Node.buildTree(s);
            ArrayList <Integer> res = bottomView(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
        }
    }

    private static ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        TreeMap<Integer,Node> t=new TreeMap<>();

        root.hd=0;
        q.add(root);
        Node temp;
        while(!q.isEmpty()){
            temp=q.poll();
            t.put(temp.hd, temp);
            if(temp.left!=null){
                temp.left.hd=temp.hd-1;
                q.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.hd=temp.hd+1;
                q.add(temp.right);
            }
        }
        for(Map.Entry<Integer,Node> entry: t.entrySet()){
            arr.add(entry.getValue().data);
        }
        return arr;
    }
}