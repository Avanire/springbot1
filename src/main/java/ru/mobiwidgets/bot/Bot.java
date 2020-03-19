package ru.mobiwidgets.bot;

import java.io.IOException;

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
}
