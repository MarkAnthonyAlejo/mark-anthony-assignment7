package com.coderscampus.assignment7;

public class CustomArrayApp {
    public static void main(String[] args) {
        CustomList<String> customList = new CustomArrayList<>();

        for(int i = 1; i < 20; i++) {
            customList.add("Item " + i);
        }

        System.out.println("Size of customList: " + customList.getSize());

        for (int i = 0; i < customList.getSize(); i++) {
            System.out.println(customList.get(i));
        }

        try {
            customList.get(-100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("tried getting item at index -100 -> " + e.getMessage());
        }

        try {
            customList.get(100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("tried getting item at index 100 -> " + e.getMessage());
        }

        CustomList<Integer> integerCustomList = new CustomArrayList<>();

        for (int i = 0; i <= 1000000; i++){
            integerCustomList.add(i);
        }

        System.out.println("Size of integerCustomList: " + integerCustomList.getSize());
        System.out.println("integerCustomList index 500,000 -> " + integerCustomList.get(500000));
        System.out.println("integerCustomList index 999,999 -> " + integerCustomList.get(999999));
    }
}
