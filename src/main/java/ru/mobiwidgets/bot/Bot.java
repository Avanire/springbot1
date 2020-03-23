package ru.mobiwidgets.bot;

import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public interface Bot {
    void searchSystem() throws IOException;
    void keywordSearch() throws IOException, InterruptedException;
    void getSerpSite();
    void enemySite() throws IOException, InterruptedException;
    void actionsOnEnemySite() throws InterruptedException;
    void enterOnOurSite() throws IOException, InterruptedException;
    void actionOnOurSite() throws InterruptedException, IOException;
    void start() throws IOException, InterruptedException;
    void close() throws InterruptedException, IOException;
    void moveToElement(List<WebElement> list) throws InterruptedException, AWTException;
}
