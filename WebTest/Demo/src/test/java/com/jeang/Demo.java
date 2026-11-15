package com.jeang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        Path path = Paths.get("C:\\develop\\chromedriver-win64\\chromedriver.exe");
        path=Paths.get("/Users/jeang/devlop/chromedriver/chromedriver");
        System.setProperty("webdriver.chrome.driver", path.toString());
        //  创建Chrome浏览器实例
        driver = new ChromeDriver();
    }

    @Test
    public void openBaidu() throws InterruptedException {
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("chat-textarea")).sendKeys("java");
        Thread.sleep(2000);
//        driver.findElement(By.id("chat-submit-button")).click();
        driver.findElement(By.xpath("//*[@id=\"chat-submit-button\"]")).click();
    }
    @Test
    public void testAction(){

    }

    //    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
