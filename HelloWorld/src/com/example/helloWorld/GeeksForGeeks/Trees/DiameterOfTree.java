package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class DiameterOfTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = Node.buildTree(s);
            System.out.println(diameter(root));
            t--;
        }
    }
    private static int diameter(Node root) {
        if(root==null)
            return 0;

        int lheight=height(root.left);
        int rheight=height(root.right);

        int ldiameter=diameter(root.left);
        int rdiameter=diameter(root.right);

        return Math.max(lheight+rheight+1, Math.max(ldiameter,rdiameter));
    }

    static int height(Node node){
        if(node==null)
            return 0;

        return (1+Math.max(height(node.left),height(node.right)));
    }
}