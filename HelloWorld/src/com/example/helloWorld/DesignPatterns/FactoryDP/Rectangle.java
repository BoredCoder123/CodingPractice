package com.example.helloWorld.DesignPatterns.FactoryDP;

import java.util.Scanner;

public class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.print("Enter the length and breadth of rectangle: ");
        Scanner sc= new Scanner(System.in);
        int l = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Drawing square with side "+l+" and breadth "+b);
    }
}
