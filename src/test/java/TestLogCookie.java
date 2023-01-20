import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestLogCookie {

    private static WebDriver driver;
    private String login = "pacej80570@dni8.com";
    private String password = "Pacej80570_";
    private static Logger log = LogManager.getLogger(TestLogCookie.class);
    private Duration second1 = Duration.ofSeconds(1);

    @BeforeAll
    public static void downloadDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    public void enter (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void logCookie() {
        driver.get("https://Otus.ru");
        driver.findElement(By.cssSelector(".header3__button-sign-in")).click();
        driver.manage().timeouts().implicitlyWait(second1);
        driver.findElement(By.cssSelector("form.new-log-reg__form.js-login .new-input")).sendKeys(login);
        driver.findElement(By.cssSelector("input.js-psw-input")).sendKeys(password);
        driver.findElement(By.cssSelector("form.new-log-reg__form.js-login button.new-button")).submit();
        log.info(driver.manage().getCookies());


    }
}
