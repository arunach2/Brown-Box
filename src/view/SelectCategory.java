package view;

import model.databases.IDatabaseAccesser;

import java.util.Scanner;

public class SelectCategory {
    public static String listCategories() {

        Scanner sc = new Scanner(System.in);
        String [] categories = {"COMEDY", "ACTION", "DOCUMENTARY", "ROMANCE", "SPORTS", "DRAMA"};
        System.out.println("Displayed below are the categories");
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }

        System.out.print("Please select a category: ");

        int topic = sc.nextInt();
        return categories[topic - 1];
    }

    public static void main(String[] Args) {
        String a = listCategories();
        System.out.println(a);
    }

}
