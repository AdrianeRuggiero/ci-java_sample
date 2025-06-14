package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testSum() {
        assertEquals(5, App.sum(2, 3));
    }

    @Test
    void testSumFail() {
        assertEquals(999, App.sum(1, 2));
    }
}
