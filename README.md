<h4>Реализованная функциональность</h4>
<ul>
    <li>Авторизация;</li>
    <li>Создание и учет актов получения;</li>
    <li>Создание и учет актов отдачи;</li>
    <li>Генерация печатных форм актов</li>
</ul> 
<h4>Особенность проекта в следующем:</h4>
<ul>
 <li>Генерация печатных форм актов;</li>  
 </ul>
<h4>Основной стек технологий:</h4>
<ul>
    <li>Windows</li>
    <li>JavaScript, BootStrap, Axios, JQuery</li>
    <li>Java, Java Spring, Apache Tomcat, Lombok</li>
    <li>MySQL</li>
    <li>iTextSharp, Microsoft .Net</li>
    <li>Git</li>
</ul>

<h4>Демо</h4>
<p>Демо сервиса доступно по адресу: http://vm2888336.33ssd.had.wf:8585/fs-platform/index.html </p>


СРЕДА ЗАПУСКА
------------
1) развертывание сервиса производится на windows server (2012+);
2) требуется установленный Apache Tomcat (5+);
3) требуется установленная СУБД MySQL (8+);


УСТАНОВКА
------------
1) Создать пользователя в БД MySQL
2) Выполните все скрипты из каталога /db
3) Прописать верную конфигурацию подключения к БД в файле app/food-sharing-service/src/main/application.properties
3) Скомпилировать и собрать war-архив из каталога /app
4) Развернуть архив в apache tomcat пути food-sharing-service
5) Скомпилировать и собрать .net-решение из каталога /dotnet
6) Выложить его в каталог на сервере
7) Скопировать каталог /client в директорию /webapps/fs-platform