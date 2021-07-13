package com.example.helloWorld;

import com.example.helloWorld.GeeksForGeeks.Array.*;
import com.example.helloWorld.GeeksForGeeks.LinkedList.*;
import com.example.helloWorld.GeeksForGeeks.String.*;
import com.example.helloWorld.LinkedLists.InbuiltLinkedList.*;
import com.example.helloWorld.Sorting.*;

import java.io.IOException;
import java.util.*;
import java.util.Iterator;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
//        BubbleSort.callBubbleSort();
//        InsertionSort.callInsertionSort();
//        Temp.callTemp();
//        SelectionSort.callselectionSort();
//        QuickSort.callQuicksort();
//        MergeSort.callMergeSort();
//        LinkedListMainCall.callLinkedList();
//        InbuiltLinkedList.callInbuiltLinkedList();

//        GeeksForGeeks Array questions
//        SubarrayWithGivenSum.callSubarrayWithGivenSum();
//        CountTheTriplets.callCountTheTriplets();
//        MissingNumberInAnArray.callMissingNumberInAnArray();
//        Sort012.callSort012();
//        LeftSideGreaterRightSideSmaller.callLeftSideGreaterRightSideSmaller();
//        LeadersInAnArray.callLeadersInAnArray();
//        EquilibriumPoint.callEquilibriumPoint();
//        LastIndexOf1.callLastIndexOf1();
//        PythagoreanTriplet.callPythagoreanTriplet();
//        ZigzagArray.callZigzagArray();
//        KadaneAlgorithm.callKadaneAlgorithm();
//        MergeWithoutExtraSpace.callMergeWithoutExtraSpace();
//        ReaarangeArrayAlternatively.callReaarangeArrayAlternatively();
//        PlatformNeeded.callPlatformNeeded();
//        ReverseArrayInGroups.callReverseArrayInGroups();
//        TrappingRainWater.callTrappingRainWater();
//        ChocolateDistribution.callChocolateDistribution();

        //String questions
//        ReverseWordsInAString.callReverseWordsInAString();
//        PermutationOfGivenString.callPermutationOfGivenString();
//        StringRotatedByTwoPlaces.callStringRotatedByTwoPlaces();
//        CheckAnagram.callCheckAnagram();
//        RemoveDuplicates.callRemoveDuplicates();
//        ImplementStrStr.callImplementStrStr();
//        LongestCommonPrefix.callLongestCommonPrefix();
//        StringToInteger.callStringToInteger();
//        LongestDistinctCharInString.callLongestDistinctCharInString();
//        RecursiveRemovalOfAdjacentDuplicates.callRecursiveRemovalOfAdjacentDuplicates();
//        RomanNumber.callRomanNumber();
//        SubstringPalindrome.callSubstringPalindrome();

//        Linked List
//        MiddleOfLinkedList.callMiddleOfLinkedList();

//        HashSet<String> hs = new HashSet<>();
//        hs.add("1");
//        hs.add("1");
//        hs.add("2");
//        hs.add("3");
//        hs.add("4");
//        hs.add("5");
//        Iterator<String> i=hs.iterator();
//        while(i.hasNext()){
//            System.out.print(i.next()+" ");
//        }
//        System.out.println(" ");
//        HashMap<Integer, Integer> hm = new HashMap<>();
//        hm.put(9,1);
//        hm.put(8,2);
//        hm.put(7,3);
//        System.out.println(hm);
//        hm.forEach((k,v) -> System.out.println(k+" "+v));
//
//        HashMap<Integer, Student> hash= new HashMap<>();
//        hash.put(3, new Student(1, "A"));
//        hash.put(2, new Student(2, "B"));
//        hash.put(1, new Student(3, "C"));
//        hash.forEach((k,v)-> System.out.println(k+" "+v.roll+" "+v.name));
//
//        Student[] s = new Student[3];
//        s[0]=new Student(3, "B");
//        s[1]=new Student(2, "A");
//        s[2]=new Student(1, "C");
//        for(int id=0;id<3;id++){
//            System.out.println(s[id].roll+" "+s[id].name);
//        }
//        Arrays.sort(s, new SortByRoll());
//        for(int id=0;id<3;id++){
//            System.out.println(s[id].roll+" "+s[id].name);
//        }
//        Arrays.sort(s, new SortByName());
//        for(int id=0;id<3;id++){
//            System.out.println(s[id].roll+" "+s[id].name);
//        }
        PriorityQueue<Float> pq= new PriorityQueue<>(Collections.reverseOrder());
        pq.add(1.2f);
        pq.add(1.0f);
        pq.add(1.1f);
        pq.add(1.3f);
        pq.poll();
        System.out.println(pq);

        PriorityQueue<Student> pq1 = new PriorityQueue<>(new SortByRoll());
        pq1.add(new Student(2, "A"));
        pq1.add(new Student(3, "B"));
        pq1.add(new Student(1, "C"));
        pq1.add(new Student(4, "D"));
        while(!pq1.isEmpty()){
            Student s=pq1.poll();
            System.out.println(s.roll+" "+s.name);
        }
        System.out.println(" ");
        pq1=new PriorityQueue<>(new SortByName());
        pq1.add(new Student(2, "A"));
        pq1.add(new Student(3, "B"));
        pq1.add(new Student(1, "C"));
        pq1.add(new Student(4, "D"));
        while(!pq1.isEmpty()){
            Student s=pq1.poll();
            System.out.println(s.roll+" "+s.name);
        }
        System.out.println(" ");
        int[][] arr= new int[2][3];
        arr[0][0]=3;
        arr[0][1]=1;
        arr[0][2]=2;
        arr[1][0]=1;
        arr[1][1]=6;
        arr[1][2]=3;
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0]-a2[0];
            }
        });
        System.out.println(arr[0][0]+" "+arr[0][1]+" "+arr[0][2]);
        System.out.println(arr[1][0]+" "+arr[1][1]+" "+arr[1][2]);

        String s1="abc", s2="xyz";
        if((s1+s2).compareTo(s2+s1)<0){
            System.out.println(s1+s2);
        }else if((s1+s2).compareTo(s2+s1)==0)
            System.out.println("Equals");
        else{
            System.out.println(s2+s1);
        }
    }
}
//
class Student{
    int roll;
    String name;
    public Student(int roll, String name){
        this.roll=roll;
        this.name=name;
    }
}

class SortByRoll implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.roll-s2.roll;
    }
}
class SortByName implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.name.compareTo(s2.name);
    }
}