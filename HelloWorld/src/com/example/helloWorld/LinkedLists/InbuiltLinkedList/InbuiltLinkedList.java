package com.example.helloWorld.LinkedLists.InbuiltLinkedList;

import java.util.Collections;
import java.util.LinkedList;

public class InbuiltLinkedList {
    public static void callInbuiltLinkedList(){
        LinkedList<Integer> list= new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(3,6);
        list.addFirst(7);
        list.addLast(8);
        if(list.contains(2)){
            System.out.println("Contains element");
        }else
            System.out.println("Doesn't contain element");

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        for(int i=0;i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println(" ");

        Collections.sort(list);

        for(int i=0;i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
