package com.example.helloWorld.GeeksForGeeks.StackAndQueue;
//https://practice.geeksforgeeks.org/problems/parenthesis-checker/0
import java.util.*;
import java.io.*;
import java.lang.*;

public class ParenthesisChecker {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        //Reading total number of testcases
        int t= sc.nextInt();

        while(t-- >0)
        {
            //reading the string
            String st = sc.next();

            //calling ispar method of Paranthesis class
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");

        }
    }

    static boolean ispar(String s)
    {
        Stack<Character> stk= new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='(')
                stk.push(s.charAt(i));
            else if(s.charAt(i)== ']' || s.charAt(i)== '}' || s.charAt(i)== ')'){
                if(stk.empty())
                    return false;
                else{
                    char t=stk.pop().charValue();
                    if( (t=='(' && s.charAt(i)!=')' ) || (t=='[' && s.charAt(i)!=']' ) || ( t=='{' && s.charAt(i)!='}' ) )
                        return false;
                }
            }
        }
        if(stk.empty())
            return true;
        else
            return false;
    }
}