import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCheckResultOtus {

    private static WebDriver driver;
    private Duration second5 = Duration.ofSeconds(5);

    @BeforeAll
    public static void downloadDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    public void enter() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkResultOtus() {
        WebDriverWait wait = new WebDriverWait(driver, second5);
        driver.get("https://duckduckgo.com/");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("search_form_input_homepage"))));
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("ОТУС");
        driver.findElement(By.id("search_button_homepage")).submit();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated
                        (By.xpath("//a[@href='https://otus.ru/' and @data-testid='result-title-a']")));
        Assertions.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным ...",
                driver.findElement(By.xpath("//a[@href='https://otus.ru/' and @data-testid='result-title-a']"))
                        .getText());
    }
}


