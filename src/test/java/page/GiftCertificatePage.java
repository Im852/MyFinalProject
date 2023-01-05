package page;

import base.MainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class GiftCertificatePage extends MainClass {
    public GiftCertificatePage(WebDriver driver) {
    }

    /* ***************************************************
     ***********************Locators***********************
     ******************************************************/

    private static final String ACTIONS_BUTTON_FOOTER = "//a[@href='https://skillfactory.ru/actions']";
    private static final String GIFT_CERTIFICATE_FORM_BUTTON = "//a[@href='https://skillfactory.ru/gift-card']//td";
    private static final String PLUS_ITEM_ON_FAQ_BLOCK = "(//span[@class = 't668__circle'])[1]";
    private static final String FAQ_BLOCK_INFORMATION_ITEM = "(//div[@class = 't668__textwrapper']/div)[1]";

    /* ***************************************************
     ***********************Methods***********************
     *****************************************************/

    public String checkFAQOnGiftCertificatePage() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(By.xpath(ACTIONS_BUTTON_FOOTER)).click();
        driver.findElement(By.xpath(GIFT_CERTIFICATE_FORM_BUTTON)).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(PLUS_ITEM_ON_FAQ_BLOCK)))
                .click(driver.findElement(By.xpath(PLUS_ITEM_ON_FAQ_BLOCK)));
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FAQ_BLOCK_INFORMATION_ITEM)));
        return driver.findElement(By.xpath(FAQ_BLOCK_INFORMATION_ITEM)).getText();
    }
}
