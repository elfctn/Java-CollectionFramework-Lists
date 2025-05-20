package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:\n0 - Quit\n1 - Add item(s)\n2 - Remove item(s)");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.println("Enter item(s) to add (comma separated):");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;
                case 2:
                    System.out.println("Enter item(s) to remove (comma separated):");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
            printSorted();
        }
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (!checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
            }
        }
        sortList();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            groceryList.remove(trimmed);
        }
        sortList();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        System.out.println("Current grocery list: " + groceryList);
    }

    private static void sortList() {
        Set<String> set = new LinkedHashSet<>(groceryList);
        groceryList = new ArrayList<>(set);
        Collections.sort(groceryList);
    }
}
