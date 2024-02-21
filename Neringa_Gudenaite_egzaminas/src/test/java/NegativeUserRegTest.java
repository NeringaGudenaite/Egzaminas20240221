import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeUserRegTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/prisijungti");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testInvalidPassword() {
        String randomUsername = "User" + UUID.randomUUID().toString().substring(0, 8);
        driver.findElement(By.cssSelector("body > div > form > div > h4 > a")).click();
        driver.findElement(By.cssSelector("#username")).sendKeys(randomUsername);
        driver.findElement(By.cssSelector("#password")).sendKeys("Mama123");
        driver.findElement(By.cssSelector("#passwordConfirm")).sendKeys("Mama1234");
        driver.findElement(By.cssSelector("#userForm > button")).click();
        String errorMessage = driver.findElement(By.cssSelector("#passwordConfirm-error")).getText();
        assertEquals("Slaptažodžiai nesutampa", errorMessage);
    }

    @AfterEach
    public void closeBrowser() {

        driver.quit();
    }
}
