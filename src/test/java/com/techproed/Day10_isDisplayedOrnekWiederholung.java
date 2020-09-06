package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnekWiederholung {

    static WebDriver driver;

    @Before
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.bestbuy.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest(){
        String sayfaBasligi = driver.getTitle();

        boolean baslikBestKelimisiniIceriyorMu = sayfaBasligi.contains("Best");
        Assert.assertTrue(baslikBestKelimisiniIceriyorMu);
    }

    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.className("logo"));

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
