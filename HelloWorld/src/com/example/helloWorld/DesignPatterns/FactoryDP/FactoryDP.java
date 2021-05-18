package com.example.helloWorld.DesignPatterns.FactoryDP;

import java.util.Scanner;

public class FactoryDP {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean isTrue = true;
        while(isTrue){
            System.out.print("Enter your choice(1. Circle, 2. Square, 3. Rectangle, 0. Exit): ");
            int n=sc.nextInt();
            if(n==1){
                Shape s = new Circle();
                s.draw();
            }else if(n==2){
                Shape s = new Square();
                s.draw();
            }else if(n==3){
                Shape s = new Rectangle();
                s.draw();
            }else if(n==0){
                isTrue=false;
            }else{
                System.out.println("Incorrect input. Enter again");
            }
        }
    }
}
