package test;

import base.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GiftCertificatePageTest extends MainClass { //Страница подарочного сертификата

    @Test(description = "#22 Проверка блока вопросов (раскрытие по клику) страницы Подарочного сертификата Skillfactory")
    public void checkFAQOnGiftCertificatePage () {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(By.xpath("//a[@href='https://skillfactory.ru/actions']")).click();
        driver.findElement(By.xpath("//a[@href='https://skillfactory.ru/gift-card']//td")).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("(//span[@class = 't668__circle'])[1]")))
                .click(driver.findElement(By.xpath("(//span[@class = 't668__circle'])[1]")));
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class = 't668__textwrapper']/div)[1]")));
        String actualText = driver.findElement(By.xpath("(//div[@class = 't668__textwrapper']/div)[1]")).getText();
        Assert.assertEquals(actualText, "Вы можете приобрести сертификат на любую сумму в интервале от 2000 рублей до 100\u2009000 рублей.");
    }
}
