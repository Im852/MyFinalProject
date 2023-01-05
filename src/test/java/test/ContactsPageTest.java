package test;

import base.MainClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ContactsPage;
import page.MainPage;

public class ContactsPageTest extends MainClass { //Страница Контакты

    @Test(description = "#19 Проверка формы 'Задать вопрос' на странице Контакты")
    public void checkQuestionFormFromContactsPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToAllCoursesPage();
        ContactsPage contactsPage = new ContactsPage(driver);
        String actualMessage = contactsPage.getValidationMessageFromQuestionForm();
        Assert.assertEquals(actualMessage, "Пожалуйста, заполните все обязательные поля");
    }
}
