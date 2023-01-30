package org.example.test2;

import java.util.Scanner;

public class TesetingFile {
    public static void main(String[] args) {
        int ageForID = 16;
        Scanner scan = new Scanner(System.in);
        System.out.println("How old are you?");
        int userAge = scan.nextInt();
        System.out.println("Are you citizen of KG");
        boolean isCitizen = scan.nextBoolean();
        System.out.println("Are you in KG?");
        boolean inKG = scan.nextBoolean();

        if (isCitizen){
            if (userAge >= ageForID){
                if (inKG){
                    System.out.println("You can get an ID passport");
                } else {
                    System.out.println("You need to be in KG");
                }
            } else {
                System.out.println("Your age is not available");
            }
        } else {
            System.out.println("You are not a citizen");
        }
    }
}
