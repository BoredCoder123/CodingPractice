package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1#
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class IsIdentical {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s1 = br.readLine();
            String s2 = br.readLine();
            Node root1 = Node.buildTree(s1);
            Node root2 = Node.buildTree(s2);
            boolean b = isIdentical(root1,root2);
            if(b==true)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    private static boolean isIdentical(Node root1, Node root2)
    {
        if(root1==null && root2==null)
            return true;
        if(root1!=null && root2!=null){
            return (root1.data==root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
        }
        return false;
    }
}