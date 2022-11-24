# Демонстрационный проект: UI + API тесты <a target="_blank" href="https://demowebshop.tricentis.com/">demowebshop.tricentis.com</a>.
<p align="center">
<img width="50%" title="JavaRush" src="images/logo/demowebshop.png">
</p>

## :mag_right: Содержание:

- [Тестовая модель](#receipt-Тестовая-модель)
- [Стек](#wrench-Стек)
- [Jenkins сборка](#window-Jenkins-сборка)
- [Локальный запуск](#arrow_forward-Локальный-запуск)
- [Удаленный запуск](#arrow_forward-Удаленный-запуск)
- [Allure отчет](#signal_strength-Allure-отчет)
- [Видео прохождения теста Selenoid](#signal_strength-Видео-прохождения-теста-Selenoid)
- [Отчёт в telegram](#signal_strength-Отчёт-в-telegram)

## :receipt: Тестовая модель

- Регистрация пользователя
- Редактирование профиля


## :wrench: Стек
<p align="center">
<img width="6%" title="Idea" src="images/logo/Idea.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Idea" src="images/logo/Selenide.svg">
<img width="6%" title="Java" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/Junit5.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Jenkins" src="images/logo/rest.png">
<img width="6%" title="Jenkins" src="images/logo/Telegram.svg">
</p>

## 	:window: Jenkins сборка
<img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a>  <a target="_blank" href="https://jenkins.autotests.cloud/job/demo-project-ui-api/">Jenkins job</a>
<p align="center">
<a href=""><img src="images/screen/Jenkins.png" alt="Jenkins"/></a>
</p>


### :arrow_forward: Локальный запуск:
```
gradle clean localTest
```
### :arrow_forward: Удаленный запуск:
```
gradle clean remoteTest
```
или
```
gradle clean
test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl="${REMOTE_DRIVER_URL}"
-DvideoStorage="https://selenoid.autotests.cloud/video/"
```
## :signal_strength: Allure-отчет
<img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/demo-project-ui-api/allure/">Allure report</a>
<p align="center">
<a href=""><img src="images/screen/Allure.png" alt="Allure"/></a>
</p>

## :signal_strength: Видео прохождения теста Selenoid
<p align="center">
<a href=""><img src="images/gif/Selenoid.gif" alt="Selenoid"/></a>
</p>

## :signal_strength: Отчёт в telegram

<a href=""><img src="images/screen/Telegram.png" alt="Telegram"/></a>

