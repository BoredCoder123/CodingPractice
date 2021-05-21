//package com.example.helloWorld.Leetcode.Medium;
//
//https://leetcode.com/problems/clone-graph/submissions/ Q.133
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class ClonedGraph {
//    public Node cloneGraph(Node source) {
//        Queue<Node> q = new LinkedList<Node>();
//        q.add(source);
//
//        // An HashMap to keep track of all the
//        // nodes which have already been created
//        HashMap<Node,Node> hm =
//                new HashMap<Node,Node>();
//        if(source==null)
//            return null;
//        //Put the node into the HashMap
//        hm.put(source,new Node(source.val));
//
//        while (!q.isEmpty())
//        {
//            // Get the front node from the queue
//            // and then visit all its neighbours
//            Node u = q.poll();
//
//            // Get corresponding Cloned Graph Node
//            Node cloneNodeU = hm.get(u);
//            if (u.neighbors != null)
//            {
//                List<Node> v = u.neighbors;
//                for (Node graphNode : v)
//                {
//                    // Get the corresponding cloned node
//                    // If the node is not cloned then we will
//                    // simply get a null
//                    Node cloneNodeG = hm.get(graphNode);
//
//                    // Check if this node has already been created
//                    if (cloneNodeG == null)
//                    {
//                        q.add(graphNode);
//
//                        // If not then create a new Node and
//                        // put into the HashMap
//                        cloneNodeG = new Node(graphNode.val);
//                        hm.put(graphNode,cloneNodeG);
//                    }
//
//                    // add the 'cloneNodeG' to neighbour
//                    // vector of the cloneNodeG
//                    cloneNodeU.neighbors.add(cloneNodeG);
//                }
//            }
//        }
//
//        // Return the reference of cloned source Node
//        return hm.get(source);
//    }
//}
