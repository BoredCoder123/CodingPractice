package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class LeftViewOfTree {


    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = Node.buildTree(s);
            ArrayList<Integer> result = leftView(root);
            for(int value : result){
                System.out.print(value + " ");
            }
            System.out.println();
            t--;
        }
    }

    private static ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root==null)
            return arr;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp=root;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=1;i<=n;i++){
                temp=q.poll();
                if(i==1){
                    arr.add(temp.data);
                }
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }
        return arr;
    }
}