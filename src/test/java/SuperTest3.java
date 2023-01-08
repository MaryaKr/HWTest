import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SuperTest3 {

    private WebDriver driver;
    private String login = "pacej80570@dni8.com";
    private String password = "Pacej80570_";
    private static Logger log = LogManager.getLogger(SuperTest3.class);


    @BeforeEach
    public void enter() {
        WebDriverManager.chromedriver().setup();
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
    public void thirdTest() {
        driver.get("https://Otus.ru");
        driver.findElement(By.cssSelector(".header3__button-sign-in")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("form.new-log-reg__form.js-login .new-input")).sendKeys(login);
        driver.findElement(By.cssSelector("input.js-psw-input")).sendKeys(password);
        driver.findElement(By.cssSelector("form.new-log-reg__form.js-login button.new-button")).submit();
        log.info(driver.manage().getCookies());


    }
}
