package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IlkDers {

    public static void main(String[] args) {

        //Browser'leri kullanabilmek icin WebDriverManager kütüphanesini kullandik.
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com");

        WebElement aramaKutusu =  driver.findElement(By.id("twotabsearchtextbox"));
        //WebElement aramaKutusu2 = driver.findElement(By.xpath("//input[@type='text']"));
        //samsung headphones
        aramaKutusu.sendKeys("samsung headphones" + Keys.ENTER);

        WebElement sonucSayisi = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(sonucSayisi.getText());

        WebElement ilkUrun = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println(ilkUrun.getText());

        List<WebElement> tumUrunler = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));


        for (WebElement w : tumUrunler) {
            System.out.println(w.getText());
        }

        //tumUrunler.get(4).getText();





    }
}
