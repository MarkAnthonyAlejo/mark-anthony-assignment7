package com.coderscampus.assignment7;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomArrayListTest {
    @Test
    public void shouldAddItemAtSpecificIndex() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        list.add(1,"X");

        assertEquals("A", list.get(0));
        assertEquals("X", list.get(1));
        assertEquals("B", list.get(2));
        assertEquals("C", list.get(3));
        assertEquals(4, list.getSize());
    }

    @Test
    public  void shouldAddItemAtBeginning() {
        CustomList<String> list = new CustomArrayList<>();
        list.add(0,"First");
        assertEquals("First", list.get(0));
        assertEquals(1,list.getSize());
    }

    @Test
    public void shouldAddItemToEnd() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("One");
        list.add(1, "Two");
        assertEquals("Two", list.get(1));
        assertEquals(2, list.getSize());
    }

    @Test
    public void shouldAddMultipleItemsAndTriggerResize() {
        CustomList<Integer> list = new CustomArrayList<>();
        for(int i = 0; i < 15; i++) {
            list.add(i);
        }
        assertEquals(15,list.getSize());
        assertEquals(0, list.get(0));
        assertEquals(14, list.get(14));
    }

    @Test
    public void shouldThrowExceptionWhenAddingAtInvalidIndex() {
        CustomList<String> list = new CustomArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, "oops"));
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "Oops"));
    }

    @Test
    public void shouldGetItemAtValidIndex() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Alpha");
        assertEquals("Alpha", list.get(0));
    }

    @Test
    public void shouldThrowExceptionWhenGettingAtInvalidIndex() {
        CustomList<String> list = new CustomArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add("Test");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void shouldRemoveItemAtBeginning() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("X");
        list.add("Y");
        String removed = list.remove(0);
        assertEquals("X", removed);
        assertEquals("Y", list.get(0));
        assertEquals(1, list.getSize());
    }

    @Test
    public void shouldRemoveItemAtMiddle() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        String removed = list.remove(2);
        assertEquals("C", removed);
        assertEquals("D", list.get(2));
        assertEquals(3, list.getSize());
    }

    @Test
    public void shouldRemoveItemAtEnd() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("1");
        list.add("2");

        String removed = list.remove(1);
        assertEquals("2", removed);
        assertEquals(1, list.getSize());
    }

    @Test
    public void shouldThrowExceptionWhenRemovingAtInvalidIndex() {
        CustomList<String> list = new CustomArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        list.add("Z");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    public void shouldReturnCorrectSize() {
        CustomList<String> list = new CustomArrayList<>();
        assertEquals(0, list.getSize());
        list.add("One");
        assertEquals(1, list.getSize());
        list.add("Two");
        assertEquals(2, list.getSize());
        list.remove(0);
        assertEquals(1, list.getSize());
    }

    //List to get 100%

    @Test
    public void shouldThrowWhenAddWithNegativeIndex() {
        CustomList<String> list = new CustomArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "Invalid"));
    }

    @Test
    public void shouldThrowWhenGetWithNegativeIndex() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Item");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    public void shouldThrowWhenRemovedWithNegativeIndex() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Item");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    public void shouldRemoveLastElementAndNullifySlot() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("First");
        list.remove(0);
        assertEquals(0, list.getSize());
    }




//    @Test
//    public void shouldThrowExceptionWhenAddingAtInvalidIndex() {
//        CustomList<String> list = new CustomArrayList<>();
//        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, "Oops"));
//        list.add("A");
//        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "Oops"));
//    }
//
//    @Test
//    public void shouldRemoveItemAtIndex() {
//        CustomList<String> list = new CustomArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//
//        String removed = list.remove(1);
//        assertEquals("B", removed);
//        assertEquals("A", list.get(0));
//        assertEquals("C", list.get(1));
//        assertEquals(2, list.getSize());
//    }
//
//    @Test
//    public void shouldThrowExceptionWhenRemovingAtInvalidIndex(){
//        CustomList<String> list = new CustomArrayList<>();
//        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
//    }
}