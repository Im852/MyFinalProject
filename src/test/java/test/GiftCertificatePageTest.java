package test;

import base.MainClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GiftCertificatePage;


public class GiftCertificatePageTest extends MainClass { //Страница подарочного сертификата

    @Test(description = "#22 Проверка блока вопросов (раскрытие по клику) страницы Подарочного сертификата Skillfactory")
    public void checkFAQOnGiftCertificatePage() {
        GiftCertificatePage giftCertificatePage = new GiftCertificatePage(driver);
        String actualText = giftCertificatePage.checkFAQOnGiftCertificatePage();
        Assert.assertEquals(actualText, "Вы можете приобрести сертификат на любую сумму в интервале от 2000 рублей до 100\u2009000 рублей.");
    }
}
