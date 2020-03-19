package ru.mobiwidgets.bot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GoogleBot implements Bot{
    @Override
    public void searchSystem() throws IOException {

    }

    @Override
    public void keywordSearch() throws IOException, InterruptedException {

    }

    @Override
    public void getSerpSite() {

    }

    @Override
    public void enemySite() throws IOException, InterruptedException {

    }

    @Override
    public void actionsOnEnemySite() throws InterruptedException {

    }

    @Override
    public void enterOnOurSite() throws IOException, InterruptedException {

    }

    @Override
    public void actionOnOurSite() throws InterruptedException, IOException {

    }

    @Override
    public void start() throws IOException, InterruptedException {
        System.out.println("Запускаем гугл бота");
    }

    @Override
    public void close() throws InterruptedException, IOException {

    }
}
