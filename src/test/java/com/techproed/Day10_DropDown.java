package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DropDown {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        // Select class'ından nesne üretmeden dropdown üzerinde işlem yapayız.
        // Eğer mülakatta dropdown ile ilgili bir soru gelirse, kesinlikle
        // select class'ından bahsetmeniz gerekiyor.
        Select select = new Select(dropDown);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Seçeneğin yazısına göre, seçim yapabiliriz.
        select.selectByVisibleText("Baby"); //secenegin yazisina göre
        //select.selectByValue("search-alias=baby-products-intl-ship");     //value="search-alias=baby-products-intl-ship" 'e göre
        //select.selectByIndex(1);     //index sayiyina göre (1)

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //secenegin value attribute'u kullanilarak secim yapilir
        select.selectByValue("search-alias=automotive-intl-ship");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //secenegin bulundugu index sirasina göre secim yapilabilir
        select.selectByIndex(3);

        //getFirstSelectedOption() dropDown üzerinde su anda secili olan
        // WebElementi return eder

        WebElement secim = select.getFirstSelectedOption();
        System.out.println(secim.getText());

        //getOptions() tüm secenekleri toplam sayisini size return eder
        List<WebElement> liste = select.getOptions();

        for (WebElement webElement: liste) {
            System.out.println(webElement.getText());
        }

        // liste.size() tüm seçeneklerin toplam sayısını size return eder.
        int toplamSecenekSayisi = liste.size();
        System.out.println("Toplam seçim sayısı : " + toplamSecenekSayisi);
    }





}
