package com.example.helloWorld.GeeksForGeeks.Trees;
//https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class VerticalTraversalOfTree {

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s = br.readLine();
            Node root = Node.buildTree(s);
            ArrayList <Integer> res = verticalOrder(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();

        }
    }

    private static ArrayList <Integer> verticalOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return null;

        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        int hd = 0;
        Queue<Qobj> que = new LinkedList<>();
        que.add(new Qobj(0, root));
        while (!que.isEmpty()) {
            Qobj temp = que.poll();
            hd = temp.hd;
            Node node = temp.node;

            if (m.containsKey(hd)) {
                m.get(hd).add(node.data);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(node.data);
                m.put(hd, al);
            }
            if (node.left != null)
                que.add(new Qobj(hd - 1, node.left));
            if (node.right != null)
                que.add(new Qobj(hd + 1, node.right));
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
            ArrayList<Integer> al = entry.getValue();
            ans.addAll(al);
        }
        return ans;
    }
}
class Qobj{
    Node node;
    int hd;
    Qobj(int hd, Node node){
        this.hd=hd;
        this.node=node;
    }
}