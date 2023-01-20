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
    private Duration second1 = Duration.ofSeconds(1);

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
        driver.get("https://duckduckgo.com/");
        driver.manage().timeouts().implicitlyWait(second1);
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("ОТУС");
        driver.findElement(By.id("search_button_homepage")).submit();
        WebDriverWait wait = new WebDriverWait(driver, second1);
        WebElement element = wait.until(ExpectedConditions
                .visibilityOfElementLocated
                        (By.xpath("//a[@href='https://otus.ru/' and @data-testid='result-title-a']")));
        Assertions.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным ...",
                driver.findElement(By.xpath("//a[@href='https://otus.ru/' and @data-testid='result-title-a']"))
                        .getText());
    }
}


