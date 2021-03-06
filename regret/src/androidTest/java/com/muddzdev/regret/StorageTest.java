package com.muddzdev.regret;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class StorageTest {

    private Storage storage;
    private DoublyLinkedList<Record> doublyLinkedList;

    @Before
    public void setup() {
        storage = new Storage(InstrumentationRegistry.getTargetContext());
        doublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    public void testLoadHistory() {
        storage.saveHistory(doublyLinkedList);
        assertTrue(storage.hasHistory());
        assertNotNull(storage.loadHistory());
    }

    @Test
    public void testSaveHistory() {
        storage.saveHistory(doublyLinkedList);
        assertTrue(storage.hasHistory());
    }

    @Test
    public void testClearHistory() {
        storage.clear();
        assertFalse(storage.hasHistory());
    }
}