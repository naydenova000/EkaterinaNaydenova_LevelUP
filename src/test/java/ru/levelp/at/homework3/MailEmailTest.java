package ru.levelp.at.homework3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.homework3.utils.SleepUtils;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertTrue;

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
        bodyEmail.sendKeys("Test");

        var buttonSave = driver.findElement(By.xpath("//*[@data-test-id='save']"));
        buttonSave.click();
        SleepUtils.sleep(2500);

        var notifyMessage = driver.findElement(By.xpath("//span[@class='notify__message__text']"))
                                  .getText();

        java.time.LocalTime currentTime = java.time.LocalTime.now();
        var time = currentTime.format(DateTimeFormatter.ofPattern("HH:mm"));

        assertTrue(notifyMessage.contains("Сохранено в черновиках в " + time));
        assertTrue(driver.findElement(By.xpath("//*[@data-test-id='underlay-wrapper']"))
                         .getText().contains("naydenovae96@mail.ru"));
//        assertTrue(driver.findElement(By.xpath("//div[@class='inputContainer--nsqFu']"));
//                         .getText().contains("Test"));
        assertTrue(bodyEmail.getText().contains("Test"));

        var buttonSend = driver.findElement(By.xpath("//*[@data-test-id='send']"));
        buttonSend.click();
        SleepUtils.sleep(1000);

        //TODO не понятно как найти кнопку крестик!
        var closeWindow = driver.findElement(By.name("Закрыть"));
        closeWindow.click();


//       var draft = driver.findElement(By.xpath("//span[@data-highlighted-class='button2_highlighted']"));
//       draft.click();
//        assertTrue(driver.findElement(By.xpath("//a[@class='GymhcKf']")).getText().
//                         contains("Письмо отправлено"));

        SleepUtils.sleep(2000);


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
