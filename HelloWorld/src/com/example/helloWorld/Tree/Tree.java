package com.example.helloWorld.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

public class Tree {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        Node root=createTree(s);
        recursivePrintInorder(root);
        System.out.println(" ");
        iterativePrintInorder(root);
        System.out.println(" ");
        recursivePreorder(root);
        System.out.println(" ");
        iterativePreorder(root);
        System.out.println(" ");
        recursivePostOrder(root);
        System.out.println(" ");
        iterativePostOrder(root);
    }

    public static Node createTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");

        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            Node currNode = queue.peek();
            queue.remove();

            String currVal = ip[i];

            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));

                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void recursivePrintInorder(Node root)
    {
        if(root == null)
            return;

        recursivePrintInorder(root.left);
        System.out.print(root.val+" ");

        recursivePrintInorder(root.right);
    }

    public static void iterativePrintInorder(Node root){
        if(root==null){
            System.out.println("The list is empty");
            return;
        }
        else {
            Stack<Node> s = new Stack<>();
            Node node = root;
            while (node != null || !s.isEmpty()) {
                while (node != null) {
                    s.push(node);
                    node = node.left;
                }
                node = s.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    public static void recursivePreorder(Node root){
        if(root==null)
            return;
        System.out.print(root.val+" ");
        recursivePreorder(root.left);
        recursivePreorder(root.right);
    }

    public static void iterativePreorder(Node root){
        if(root==null){
            System.out.println("The tree is empty");
            return;
        }
        Stack<Node> s= new Stack<>();
        s.push(root);
        Node node = root;
        while(!s.isEmpty()){
            node = s.pop();
            System.out.print(node.val+" ");
            if(node.right!=null){
                s.push(node.right);
            }
            if(node.left!=null){
                s.push(node.left);
            }
        }
    }

    public static void recursivePostOrder(Node root){
        if(root==null){
            return;
        }
        recursivePostOrder(root.left);
        recursivePostOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static void iterativePostOrder(Node root){
        if(root==null){
            System.out.println("The tree is empty");
            return;
        }else{
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(root);
            Node node = root;
            while(!s1.isEmpty()){
                node=s1.pop();
                s2.push(node);
                if(node.left!=null)
                    s1.push(node.left);
                if(node.right!=null)
                s1.push(node.right);
            }
            while(!s2.isEmpty()){
                node=s2.pop();
                System.out.print(node.val+" ");
            }
        }
    }
}
