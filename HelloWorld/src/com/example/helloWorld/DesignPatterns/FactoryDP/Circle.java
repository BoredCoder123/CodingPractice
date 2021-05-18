package com.example.helloWorld.DesignPatterns.FactoryDP;

import java.util.Scanner;

public class Circle implements Shape{
    @Override
    public void draw(){
        System.out.print("Enter the radius of circle: ");
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Drawing circle with radius "+n+".");
    }
}
