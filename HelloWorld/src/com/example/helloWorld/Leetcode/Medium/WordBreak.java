package com.example.helloWorld.Leetcode.Medium;

import java.util.*;

//https://leetcode.com/problems/word-break/ Question number 139
public class WordBreak {
    HashMap<String, Boolean> wordLookup= new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()==0)
            return true;

        if(wordLookup.containsKey(s)) return wordLookup.get(s);

        boolean res=false;

        for(String w:wordDict){
            if(s.contains(w)){
                int i=s.indexOf(w);
                String first=s.substring(0,i);
                String second=s.substring(i+w.length());
                res=wordBreak(first, wordDict) && wordBreak(second, wordDict);
                if(res)
                    break;
            }
        }
        wordLookup.put(s, res);

        return res;
    }
}