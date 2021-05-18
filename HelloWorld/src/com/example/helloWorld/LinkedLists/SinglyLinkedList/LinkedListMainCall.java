package com.example.helloWorld.LinkedLists.SinglyLinkedList;

import static com.example.helloWorld.LinkedLists.SinglyLinkedList.LinkedListUtils.*;

public class LinkedListMainCall {
    public static void callLinkedList(){
        LinkedList list = new LinkedList();
        list= insert(list,1);
        list= insert(list,2);
        list= insert(list,3);
        list= insert(list,4);
        list= insert(list,5);
        list= insert(list,6);
        display(list);
        list= insert(list,7);
        list= insert(list,8);
        display(list);
//        list= delFirstOccurrence(list, 9);
//        display(list);
        list=delAtPos(list,9);
        display(list);
    }
}
