package com.beginsecure.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class ProgTest {

    @Test
    public void test_min() {
        int[] numbers = {5, 2, 8, 1, 9};
        assertEquals(1, Prog._min(numbers));
    }

    @Test
    public void test_max() {
        int[] numbers = {5, 2, 8, 1, 9};
        assertEquals(9, Prog._max(numbers));
    }

    @Test
    public void test_sum() {
        int[] numbers = {5, 2, 8, 1, 9};
        assertEquals(25, Prog._sum(numbers));
    }

    @Test
    public void test_mult() {
        int[] numbers = {5, 2, 8, 1, 9};
        assertEquals(720, Prog._mult(numbers));
    }

    @Test
    void testPerformance() throws IOException {
        Random random = new Random();

        int limit = 30;
        int[] sizes = new int[limit];
        for (int i = 0; i < limit; ++i) {
            sizes[i] = (int) Math.pow(10, 6);
        }
        long[] times = new long[limit];

        for (int i = 0; i < limit; i++) {
            int[] numbers = new int[sizes[i]];
            for (int j = 0; j < sizes[i]; j++) {
                numbers[j] = random.nextInt(1000);
            }

            long startTime = System.nanoTime();
            Prog._min(numbers);
            long endTime = System.nanoTime();
            times[i] = endTime - startTime;

            assertTrue(times[i] <= 20000000, "Performance test failed" + " " + times[i]);
        }
    }

    @Test
    void testMemory() throws IOException {
        Random random = new Random();

        int limit = 30;
        int[] sizes = new int[limit];
        for (int i = 0; i < limit; ++i) {
            sizes[i] = (int) Math.pow(10, 5);
        }

        for (int i = 0; i < limit; i++) {
            int[] numbers = new int[sizes[i]];
            for (int j = 0; j < sizes[i]; j++) {
                numbers[j] = random.nextInt(1000);
            }

            Prog._min(numbers);
            long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            assertTrue(usedBytes < 50000000, "Memory test failed" + " " + usedBytes);
        }
    }
}