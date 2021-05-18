package com.example.helloWorld.LinkedLists.SinglyLinkedList;

public class LinkedListUtils {
    public static LinkedList insert(LinkedList list, int data){
        LinkedList.Node newNode= new LinkedList.Node(data);
        newNode.next=null;

        if(list.head==null){
            list.head=newNode;
        }else{
            LinkedList.Node last=list.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=newNode;
        }
        return list;
    }

    public static void display(LinkedList list){
        LinkedList.Node curNode= list.head;
        while(curNode!= null){
            System.out.print(curNode.data+" ");
            curNode=curNode.next;
        }
        System.out.println(" ");
    }

    public static LinkedList delFirstOccurrence(LinkedList list, int key){
        LinkedList.Node curNode=list.head;
        Boolean isNotDeleted=true;
        if(list.head==null){
            System.out.println("List is empty. Nothing to delete.");
            return list;
        }
        if(curNode.data==key){
            isNotDeleted=false;
            System.out.println("Element deleted at head of list.");
            list.head=list.head.next;
        }else{
            while(curNode.next!=null){
                if(curNode.next.data==key){
                    isNotDeleted=false;
                    System.out.println("Element deleted.");
                    curNode.next=curNode.next.next;
                    break;
                }else{
                    curNode=curNode.next;
                }
            }
        }
        if(isNotDeleted){
            System.out.println("Element not present in list");
        }
        return list;
    }

    public static LinkedList delAtPos(LinkedList list, int delPos){
        LinkedList.Node curNode= list.head;
        if(delPos==1){
            System.out.println("First element deleted");
            list.head=list.head.next;
        }else{
            int i=1;
            while(curNode!=null && i<delPos-1){
                curNode=curNode.next;
                i++;
            }
            if(curNode.next!=null){
                System.out.println("Element deleted at position "+delPos);
                curNode.next=curNode.next.next;
            }
            else
                System.out.println("Position is greater than length of list. Hence unable to delete.");
        }
        return list;
    }
}
