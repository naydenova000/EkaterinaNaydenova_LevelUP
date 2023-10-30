package ru.levelp.at.homework3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import ru.levelp.at.homework3.utils.SleepUtils;

class MailLoginTest {

    public static final String MAIL_URL = "https://mail.ru/";
    private WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        SleepUtils.sleep(2500);
        driver.navigate().to(MAIL_URL);
    }

    @Test
    void testLogin(){
        var loginButton = driver.findElement(By.xpath("//*[@data-testid='enter-mail-primary']"));
        loginButton.click();

        var frameElement = driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"));
        driver = driver.switchTo().frame(frameElement);
        var inputUserName = driver.findElement(By.xpath("//input[@name='username']"));
        inputUserName.sendKeys("naydenovae96");


        var passButton = driver.findElement(By.xpath("//*[@data-test-id='next-button']"));
        passButton.click();

        SleepUtils.sleep(2500);
        var inputPass = driver.findElement(By.xpath("//input[@name='password']"));
        inputPass.sendKeys("Ya2yUy2arAI(");

        var logButton = driver.findElement(By.xpath("//*[@data-test-id='submit-button']"));
        logButton.click();

        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(MAIL_URL, expectedUrl);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
