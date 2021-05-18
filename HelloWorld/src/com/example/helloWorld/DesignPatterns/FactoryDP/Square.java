package com.example.helloWorld.DesignPatterns.FactoryDP;

import java.util.Scanner;

public class Square implements Shape{
    @Override
    public void draw(){
        System.out.print("Enter the side of square: ");
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Drawing square with side "+n+".");
    }
}
