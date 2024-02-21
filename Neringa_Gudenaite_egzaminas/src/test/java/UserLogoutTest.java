import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class UserLogoutTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/prisijungti");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("body > div > form > div > input:nth-child(2)")).sendKeys("NeringaTest");
        driver.findElement(By.cssSelector("body > div > form > div > input:nth-child(3)")).sendKeys("Mama123");
        driver.findElement(By.cssSelector(".btn")).click();
    }

    @Test
    public void testLogout() {

        driver.findElement(By.cssSelector("ul.nav:nth-child(3)")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
