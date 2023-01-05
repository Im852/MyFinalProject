### Проект по реализации автоматического тестирования для сайта Skillfactory (https://skillfactory.ru/) ###

Для запуска тестов - клик ПКМ по файлу testing.xml -> Run 
либо
клик ПКМ по папке 'MyFinalProject'-> Run 'All Tests'
***
Тесты можно разделить на два больших вида:
1. тесты, основная цель которых - переход к релевантным запросу страницам или элементам на странице (элементы хэдера, футера, баннеры, левое меню):
* Тест №1 - Переход к странице с курсами по тестированию из хэдера главной страницы
* Тест №2 - Переход к странице "Бесплатно" из главной страницы
* Тест №4 - Переход к странице 'Корпоративное обучение' из хэдера главной страницы
* Тест №5 - Переход к странице 'Сотрудничество' из хэдера главной страницы
* Тест №6 - Переход к странице 'Блог' из хэдера главной страницы
* Тест №8 - Переход к странице со всеми курсами через баннер на главной странице
* Тест №9 - Переход к курсам по Java из футера
* Тест №10 - Переход к отзывам студентов из футера
* Тест №11 - Переход на Youtube из футера
* Тест №13 - Возврат на главную страницу из страницы списка курсов при клике на лого в хэдере
* Тест №14 - Переход к странице 'Центр карьеры' через страницу списка курсов
* Тест №16 - Выбор курсов на странице курсов через левое меню
* Тест №17 - Переход к курсам по тестированию, на которых изучается Selenium WebDriver из главной страницы
2. тесты, проверяющие активность форм (т.к. позитивное тестирование форм в данном случае проводить нежелательно, проводились негативные проверки):
* Тест №3 - Проверка активности формы для подписки на новости на главной странице
* Тест №7 - Проверка формы для получения консультации на главной странице
* Тест №12 - Открытие/закрытие чата с помощником
* Тест №15 - Проверка формы для заказа звонка на странице списка курсов
* Тест №18 - Проверка формы для записи на курс 'QA-инженер на Java'
* Тест №19 - Проверка формы 'Задать вопрос' на странице Контакты
* Тест №20 - Проверка формы 'Задать вопрос центру карьеры' на странице Центра карьеры
* Тест №21 - Проверка формы регистрации на бесплатные онлайн-интенсивы на странице Бесплатно
* Тест №22 - Проверка блока вопросов (раскрытие по клику) страницы Подарочного сертификата Skillfactory
---
При выполнении задания автор, ориентируясь на собственный опыт, реализовал сценарии поведения, которые были бы актуальны для него при посещении указанного сайта