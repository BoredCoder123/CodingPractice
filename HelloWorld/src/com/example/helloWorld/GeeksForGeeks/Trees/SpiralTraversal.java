package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class SpiralTraversal {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s = br.readLine();
            Node root = Node.buildTree(s);
            ArrayList<Integer> result = findSpiral(root);
            for(int value : result)
                System.out.print(value + " ");
            System.out.println();

        }
    }

    private static ArrayList<Integer> findSpiral(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
            return ans;
        int lev=0;
        Stack<Node> s1= new Stack<>();
        Stack<Node> s2=new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                Node temp=s1.pop();
                ans.add(temp.data);
                if(temp.right!=null){
                    s2.push(temp.right);
                }
                if(temp.left!=null){
                    s2.push(temp.left);
                }
            }
            while(!s2.isEmpty()){
                Node temp=s2.pop();
                ans.add(temp.data);
                if(temp.left!=null)
                    s1.push(temp.left);
                if(temp.right!=null)
                    s1.push(temp.right);
            }
        }
        return ans;
    }
}