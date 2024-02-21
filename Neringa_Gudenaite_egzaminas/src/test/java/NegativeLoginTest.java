import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NegativeLoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/prisijungti");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testLoginNegative () throws InterruptedException {
        driver.findElement(By.cssSelector("body > div > form > div > input:nth-child(2)")).sendKeys("Neteisingas@vartotojas");
        driver.findElement(By.cssSelector("body > div > form > div > input:nth-child(3)")).sendKeys("Neteisingas@vartotojas");
        driver.findElement(By.cssSelector(".btn")).click();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

