import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSuperTest1 {

    private static WebDriver driver;

    @BeforeAll
    public static void downloadDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    public void enter (){
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
    public void testFirstTest() {
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("ОТУС");
        driver.findElement(By.id("search_form_input_homepage")).sendKeys(Keys.RETURN);
        Assertions.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным ...",
                driver.findElement(By.cssSelector("span.EKtkFWMYpwzMKOYr0GYm.LQVY1Jpkk8nyJ6HBWKAk")).getText());
    }
}


