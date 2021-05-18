package com.example.helloWorld.GeeksForGeeks.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class CountLeafNodes {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = Node.buildTree(s);

            System.out.println(countLeaves(root));
            t--;

        }
    }
    private static int countLeaves(Node node)
    {
        int res=0;
        if(node==null){
            return 0;
        }else if(node.left==null && node.right==null)
            return 1;

        if(node.right!=null)
            res+=countLeaves(node.right);
        if(node.left!=null)
            res+=countLeaves(node.left);

        return res;
    }
}