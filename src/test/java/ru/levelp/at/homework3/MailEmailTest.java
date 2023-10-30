package ru.levelp.at.homework3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.homework3.utils.SleepUtils;

public class MailEmailTest {
    public static final String MAIL_URL = "https://account.mail.ru/login";
    private WebDriver driver;
    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        SleepUtils.sleep(2500);
        driver.navigate().to(MAIL_URL);

        var inputLogin = driver.findElement(By.xpath("//input[@name='username']"));
        inputLogin.sendKeys("naydenovae96");

        var buttonNext = driver.findElement(By.xpath("//*[@data-test-id='next-button']"));
        buttonNext.click();

        SleepUtils.sleep(2500);
        var buttonPass = driver.findElement(By.xpath("//input[@name='password']"));
        buttonPass.sendKeys("Ya2yUy2arAI(");

        var buttonSingIn = driver.findElement(By.xpath("//*[@data-test-id='submit-button']"));
        buttonSingIn.click();
    }


    @Test
    void testCreateEmail(){
        SleepUtils.sleep(3000);
        var emailButton = driver.findElement(By.xpath("//span[@class='compose-button__wrapper']"));
        emailButton.click();

        SleepUtils.sleep(2500);
        var inputToWhom = driver.findElement(By.xpath("//input[@class='container--H9L5q size_s--3_M-_']"));
        inputToWhom.sendKeys("naydenovae96@mail.ru");

        var inputTopic = driver.findElement(By.xpath("//div[@class='container--3QXHv']"
            + "/div[@class='inputContainer--nsqFu']"
            + "/input[@class='container--H9L5q size_s--3_M-_']"));
        inputTopic.sendKeys("Test");


        // TODO через xpath не вышло найти поле для ввода тела, пришлось искать через css
        var bodyEmail = driver.findElement(By.cssSelector(".cke_contents_true"));
//        var bodyEmail = driver.findElement(By.xpath("//div[@class='editor_container--3Rj-8']"
//            + "/div[@class='container--2Rl8H']"
//            + "/div[@class='editor-82pv']"
//            + "/div[@class='editable-container-82pv']"
//            + "/div[@class='editable-82pv cke_editable cke_editable_inline cke_contents_true']"));
        bodyEmail.sendKeys("Test");

        var buttonSave = driver.findElement(By.xpath("//*[@data-test-id='save']"));
        buttonSave.click();

        // Проверка verify

        var buttonSend = driver.findElement(By.xpath("//*[@data-test-id='send']"));
        buttonSend.click();

        // Проверка verify

    }

    @Test
    void testCreateEmailInDirectoryTest(){
        SleepUtils.sleep(3000);

        var emailButton = driver.findElement(By.xpath("//span[@class='compose-button__wrapper']"));
        emailButton.click();

        SleepUtils.sleep(2500);
        var inputToWhom = driver.findElement(By.xpath("//input[@class='container--H9L5q size_s--3_M-_']"));
        inputToWhom.sendKeys("naydenovae96@mail.ru");

        var inputTopic = driver.findElement(By.xpath("//div[@class='container--3QXHv']"
            + "/div[@class='inputContainer--nsqFu']"
            + "/input[@class='container--H9L5q size_s--3_M-_']"));
        inputTopic.sendKeys("Тест");

        var bodyEmail = driver.findElement(By.cssSelector(".cke_contents_true"));
        bodyEmail.sendKeys("Тест Тест Тест");

        var buttonSend = driver.findElement(By.xpath("//*[@data-test-id='send']"));
        buttonSend.click();

        // Проверка verify
    }


    @Test
    void testCreateEmailAndDelete(){
        SleepUtils.sleep(3000);

        var emailButton = driver.findElement(By.xpath("//span[@class='compose-button__wrapper']"));
        emailButton.click();

        SleepUtils.sleep(2500);
        var inputToWhom = driver.findElement(By.xpath("//input[@class='container--H9L5q size_s--3_M-_']"));
        inputToWhom.sendKeys("naydenovae96@mail.ru");

        var inputTopic = driver.findElement(By.xpath("//div[@class='container--3QXHv']"
            + "/div[@class='inputContainer--nsqFu']"
            + "/input[@class='container--H9L5q size_s--3_M-_']"));
        inputTopic.sendKeys("На удаление");

        var bodyEmail = driver.findElement(By.cssSelector(".cke_contents_true"));
        bodyEmail.sendKeys("Тест Тест Тест");

        var buttonSend = driver.findElement(By.xpath("//*[@data-test-id='send']"));
        buttonSend.click();

        // Проверка verify

//        var openEmail = driver.findElement(By.xpath(""))


    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
