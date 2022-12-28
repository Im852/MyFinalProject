package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainClass {

    private static final String URL = "https://skillfactory.ru/";

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    @BeforeMethod
    public void setupClass() {
        //ChromeDriverManager.getInstance().setup(); // Это вместо setProperty и прописывания пути драйвера браузера
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Инициализируем драйвер
        driver.manage().window().maximize(); // Чтобы браузер открывался на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Устанавливаем неявное ожидание, если что-то через 10 секунд не нашлось - выбрасываем исключение
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
        driver.get(URL);
    }

    @AfterMethod
    public void finalizeResources() {
        driver.quit(); // Закрываем браузер после выполнения тестов
    }
}

