package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void beforeMethod(){

        driver = new ChromeDriver();
        driver.get("http://www.bestbuy.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest(){
        String sayfaBasligi = driver.getTitle();
        boolean bestKelimisiniIceriyorMu = sayfaBasligi.contains("Best");
        Assert.assertTrue(bestKelimisiniIceriyorMu);
    }

    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.className("logo"));
                                        //By.xpath("//img[@class='logo']")
        boolean logoGorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(logoGorunuyorMu);
    }

    @Test
    public void mexicoLinkTest(){
        WebElement mexicoLinki = driver.findElement(By.partialLinkText("Mexico"));
        boolean linkGorunuyorMu = mexicoLinki.isDisplayed();
        Assert.assertTrue(linkGorunuyorMu);
    }

    @After
    public void afterMethod(){
        driver.quit();
    }

}
