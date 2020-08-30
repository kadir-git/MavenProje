package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http://google.com");

        //Test case: google.com'un basligi "Google Arama Sayfasi" olsun.
        String title = driver.getTitle();

        //Google'in title'i "Google Arama Sayfasi"na esit mi, degil mi?

        Assert.assertEquals("Google Arama Sayfasi", title);
        //Assert.assertEquals(5, 5);
        //Assert.assertEquals("Yazi", "Google");
        //Assert.assertEquals(true, false);
    }

    @Test
    public void test2(){
        driver.get("http://amazon.com");
        //amazon.com'un basligi Amazon kelimesini iceriyor mu
        String title = driver.getTitle();

        boolean iceriyorMu = title.contains("Amazon"); //true yada false
        Assert.assertTrue(iceriyorMu);  //bunun true oldugunu dogrula
        //parantezin ici TRUE ise test basarili

    }

    @Test
    public void test3(){
        driver.get("http://facebook.com");
        String title = driver.getTitle();

        //Facebook.com'un title'i YouTube kelimesini icermesin

        boolean iceriyorMu = title.contains("YouTube");
        Assert.assertFalse(iceriyorMu);
        //parantezin ici FALSE ise test basarili
    }

    @Test
    public void test4(){
        driver.get("http://google.com");
        String title = driver.getTitle();

        System.out.println("MERHABALAR..");

        Assert.assertEquals("Google Arama Sayfasi", title);

        //eger test basarisizsa icinde ki testin kalan kismini calistirmaz
        System.out.println("Test dogrulama islemi bitti...");
    }

    @Test
    public void test5(){
        driver.get("http://facebook.com");
        String title = driver.getTitle();


        boolean iceriyorMu = title.contains("Google");
        Assert.assertFalse(iceriyorMu);

        System.out.println("Test dogrulama islemi bitti...");
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }






}
