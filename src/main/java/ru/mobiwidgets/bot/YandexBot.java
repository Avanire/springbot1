package ru.mobiwidgets.bot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mobiwidgets.bot.competitors.Competitors;
import ru.mobiwidgets.bot.keywords.Keywords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class YandexBot implements Bot {
    private WebDriver driver;
    private String mainWindow;
    private List<String> serpSite = new ArrayList<>();
    @Value("${sitename}")
    private String siteName;

    @Override
    public void searchSystem() throws IOException {
        driver = new ChromeDriver();
        driver.get("https://yandex.ru/");
        mainWindow = driver.getWindowHandle();
    }

    @Override
    public void keywordSearch() throws IOException, InterruptedException {
        searchSystem();
        String keyword = Keywords.getRandomKeyword();
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(keyword);
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(Keys.ENTER);
        getSerpSite();
        enemySite();
    }

    @Override
    public void getSerpSite() {
        List<WebElement> serp = driver.findElements(By.xpath("//li//div//div//div//a//b"));
        for(WebElement element : serp){
            serpSite.add(element.getText());
        }
    }

    @Override
    public void enemySite() throws IOException, InterruptedException {
        List<String> competitors = Competitors.getCompetitors();
        for(int i = 4; i < 8; i++){
            for(int j = 0; j < competitors.size(); j++){
                if(serpSite.get(i).equalsIgnoreCase(competitors.get(j))){
                    WebElement element = driver.findElement(By.xpath(String.format("//a//b[text()='%s']", serpSite.get(i))));
                    Actions actions = new Actions(driver);
                    actions.moveToElement(element).click().build().perform();
                    actionsOnEnemySite();
                }
            }
        }
        try {
            enterOnOurSite();
        }catch (Exception ex){
            System.out.println("Ошибка при переходе в метод enterOnOurSite");
            close();
        }
    }

    @Override
    public void actionsOnEnemySite() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        for(String windows : driver.getWindowHandles()){
            driver.switchTo().window(windows);
        }
        for (int i = 0; i < 3; i++){
            actions.sendKeys(Keys.SPACE).build().perform();
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
        driver.switchTo().window(mainWindow);
    }

    @Override
    public void enterOnOurSite() throws IOException, InterruptedException {
        try{
            Actions actions = new Actions(driver);
            for(int i = 2; i < 6; i++) {
                if(serpSite.contains(siteName)) {
                    WebElement element = driver.findElement(By.xpath(String.format("//b[text()='%s']", siteName)));
                    actions.moveToElement(element).click().build().perform();
                    for (String windows : driver.getWindowHandles()) {
                        driver.switchTo().window(windows);
                    }
                    try {
                        actionOnOurSite();
                    }catch (Exception ex){
                        System.out.println("Ошибка при переходе в метод actionOnOurSite");
                        close();
                    }
                }else {
                    WebElement page = driver.findElement(By.xpath(String.format("//a[text()='%s']", i)));
                    actions.moveToElement(page).click().build().perform();
                    getSerpSite();
                }
            }
        }catch (Exception ex){
            System.out.println("Ошибка в методе enterOnOurSite");
            close();
        }
    }

    @Override
    public void actionOnOurSite() throws InterruptedException, IOException {
        try {
            WebElement element = driver.findElement(By.xpath("//h2[text()='Все категории']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();
            Thread.sleep(3000);
            WebElement element1 = driver.findElement(By.xpath("//a//span[text()='Для собак']"));
            actions.moveToElement(element1).click().build().perform();
            Thread.sleep(3000);
            List<WebElement> list = driver.findElements(By.xpath("//div[@id='content']//a"));
            int min = 2000;
            int max = 10000;
            int diff = max - min;
            Random rnd = new Random();
            int i = rnd.nextInt(diff + 1);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).build().perform();
            Thread.sleep(i);
            actions.moveToElement(list.get(rnd.nextInt(list.size() - 1))).click().build().perform();
            Thread.sleep(100000);
            WebElement element3 = driver.findElement(By.xpath("//jdiv[@class='text_eD']"));
            actions.moveToElement(element3).click().build().perform();
            Thread.sleep(2000);
            WebElement element4 = driver.findElement(By.xpath("//textarea[@placeholder='Введите сообщение']"));
            actions.moveToElement(element4).click().build().perform();
            Thread.sleep(2000);
            //actions.sendKeys("Здравствуйте").build().perform();
            //Thread.sleep(1000);
            //actions.sendKeys(Keys.ENTER).build().perform();
            Thread.sleep(50000);
            close();
        }catch (Exception ex){
            System.out.println("Ошибка на последнем шаге");
            close();
        }
    }

    @Override
    public void start() throws IOException, InterruptedException {
        keywordSearch();
    }

    @Override
    public void close() throws InterruptedException, IOException {
        driver.quit();
        int min = 50000;
        int max = 500000;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        Thread.sleep(i);
        start();
    }
}
