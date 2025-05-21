package com.coderscampus.unitTest.assignment7;

import com.coderscampus.assignment7.CustomArrayList;
import com.coderscampus.assignment7.CustomList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UnitTest {
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
    public void shouldThrowExceptionWhenAddingAtInvalidIndex() {
        CustomList<String> list = new CustomArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, "Oops"));
    }

    @Test
    public void shouldRemoveItemAtIndex() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove(1);
        assertEquals("B", removed);
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
        assertEquals(2, list.getSize());
    }

    @Test
    public void shouldThrowExceptionWhenRemovingAtInvalidIndex(){
        CustomList<String> list = new CustomArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }
}
