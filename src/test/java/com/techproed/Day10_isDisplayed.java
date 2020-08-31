package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayed {

    static WebDriver driver;        //instance variable. diger methodlarin icinde kullanilabilir

    @BeforeClass
    public static void setUp(){
        //driver'i kullanilabilir hale getiriyoruz
        WebDriverManager.chromedriver().setup();

        //driver nesnesi olusturalim
        driver = new ChromeDriver();

        //driver komutlarini girelim
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        //google.com'a gidiyoruz
        driver.get("http://google.com");
        WebElement logo = driver.findElement(By.id("hplogo"));

        //eger webelement kullaniciya gösteriliyorsa TRUE
        //eger webelement kullaniciya gösteriliyorsa FALSE
        boolean gorunuyorMu = logo.isDisplayed();

        //testimizin sonucunu bildiriyoruz
        //eger "gorunuyorMu" TRUE ise test PASSED (Basarili)
        //eger "gorunuyorMu" FALSE ise test FAILDE (Basarisiz)
        Assert.assertTrue(gorunuyorMu);
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }
}
