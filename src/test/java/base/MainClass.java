package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class MainClass {

    private static final String URL = "https://skillfactory.ru/";

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor js;


    @BeforeMethod
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Инициализируем драйвер
        driver.manage().window().maximize(); // Чтобы браузер открывался на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Устанавливаем неявное ожидание, если что-то через 10 секунд не нашлось - выбрасываем исключение
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
        driver.get(URL);
        // Было актуально, когда спрашивали про cookie
        /*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='t657__btn-wrapper']/div")));
        driver.findElement(By.xpath("//div[@class='t657__btn-wrapper']/div")).click();*/
    }

    @AfterMethod
    public void finalizeResources() {
        driver.quit(); // Закрываем браузер после выполнения тестов
    }
}

