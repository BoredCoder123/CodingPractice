package com.example.helloWorld.GeeksForGeeks.StackAndQueue;

import java.util.*;

public class StackAndQueue {

    private static int[] stack=new int[Integer.MAX_VALUE];
    private static int top=-1;

    private static int[] queue=new int[Integer.MAX_VALUE];
    private static int rear=-1;
    private static int back=-1;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
    }

    //Stack methods
    private static boolean isEmpty(){
        if(top==-1)
            return true;
        else
            return false;
    }
    private static int peek(){
        return stack[top];
    }
    private static int pop(){
        int x=stack[top];
        top--;
        return x;
    }
    private static void push(int x){
        top++;
        stack[top]=x;
    }
    private static int search(int x){
        for(int i=0;i<=top;i++){
            if(stack[i]==x)
                return i;
        }
        return -1;
    }

    //Queue methods
}
