import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class TestCheckOpenedPicture {

    private static WebDriver driver;


    @BeforeAll
    public static void downloadDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
     public void enter (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
    }

    @AfterAll
    public static void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void CheckOpenedPicture() {

        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/" +
                "photoflash-liberty-demo_Free/685659620/" +
                "web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");

        List<WebElement> modalWindowWebElementsList = driver.findElements(By.cssSelector("div.pp_pic_holder.light_rounded"));
        if (modalWindowWebElementsList.size() != 0) {
            Assertions.assertFalse(modalWindowWebElementsList.get(0).isDisplayed());
        }

        WebElement imageLinkWebElement = driver.findElements(By.cssSelector("a.image-zoom")).get(0);
        try {
            imageLinkWebElement.click();
        } catch (ElementClickInterceptedException e) {
            imageLinkWebElement.click();
        }

        modalWindowWebElementsList = driver.findElements(By.cssSelector("div.pp_pic_holder.light_rounded"));
        Assertions.assertTrue(modalWindowWebElementsList.get(0).isDisplayed());


    }

}
