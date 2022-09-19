package org.skan;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JunitDemoTest {

    @BeforeAll
    static void setUp(){
        System.out.println("Before all!!!");
    }

    @AfterAll
    static void tearDown(){
        System.out.println("After All!!!");
    }

    @Test
    void simpleTestFirst(){
        System.out.println("Test simple first!");
        Assertions.assertTrue(3>2);
    }

    @Test
    void simpleTestSecond(){
        System.out.println("Test simple second!");
        Assertions.assertTrue(3>2);
    }
}
