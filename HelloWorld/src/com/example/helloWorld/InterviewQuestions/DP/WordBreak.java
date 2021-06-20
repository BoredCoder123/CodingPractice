package com.example.helloWorld.InterviewQuestions.DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String[] dict = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};
        System.out.println(wordBreak(dict, "ilikesamsung"));
        System.out.println(wordBreak(dict, "iiiiiiii"));
        System.out.println(wordBreak(dict, ""));
        System.out.println(wordBreak(dict, "ilikelikeimangoiii"));
        System.out.println(wordBreak(dict, "samsungandmango"));
        System.out.println(wordBreak(dict, "samsungandmangok"));
        System.out.println(wordBreak(dict, "iiceankit"));
    }

    private static boolean wordBreak(String[] dict, String str) {
        Set<String> wordDict=new HashSet<>(Arrays.asList(dict));
        int[] pos= new int[str.length()+1];
        Arrays.fill(pos, -1);
        pos[0]=0;
        for(int i=0;i<str.length();i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=str.length();j++){
                    String sub= str.substring(i, j);
                    if(wordDict.contains(sub))
                        pos[j]=i;
                }
            }
        }
        return pos[str.length()]!=-1;
    }
}
