package com.techproed;

import org.junit.*;

public class Day08_BeforeAfterMethod {

    @BeforeClass
    public static void setUp(){
        System.out.println("setUp Calisti.");
    }

    @Before
    public  void methoddanOnce(){
        System.out.println("methoddanOnce Calisti.");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 Calisti.");
    }

    @Test
    public void test2(){
        System.out.println("Test 2 Calisti.");
    }

    @After
    public  void methoddanSonra(){
        System.out.println("methoddanSonra Calisti.");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("tearDown Calisti.");
    }

}
