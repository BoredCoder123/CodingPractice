package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1#
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

public class HeightOfTree {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = Node.buildTree(s);

            System.out.println(height(root));
            t--;
        }
    }

    private static int height(Node node)
    {
        if(node==null)
            return 0;
        else{
            return (Math.max(height(node.left),height(node.right))+1);
        }
    }
}