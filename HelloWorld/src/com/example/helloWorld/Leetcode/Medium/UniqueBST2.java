package com.example.helloWorld.Leetcode.Medium;

//https://leetcode.com/problems/unique-binary-search-trees-ii/ Q.95

public class UniqueBST2 {
//    public List<TreeNode> generateTrees(int n) {
//        return generateTrees(1, n);
//    }
//
//    public List<TreeNode> generateTrees(int start, int end){
//        List<TreeNode> list = new ArrayList<>();
//        if(start>end){
//            list.add(null);
//            return list;
//        }
//
//        for(int i=start;i<=end;i++){
//            List<TreeNode> leftTree=generateTrees(start, i-1);
//            List<TreeNode> rightTree=generateTrees(i+1, end);
//
//            for(int j=0;j<leftTree.size();j++){
//                TreeNode left=leftTree.get(j);
//                for(int k=0;k<rightTree.size();k++){
//                    TreeNode right=rightTree.get(k);
//                    TreeNode node=new TreeNode(i);
//                    node.left=left;
//                    node.right=right;
//                    list.add(node);
//                }
//            }
//        }
//        return list;
//    }
}
