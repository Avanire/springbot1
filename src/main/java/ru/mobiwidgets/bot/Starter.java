package ru.mobiwidgets.bot;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class Starter {
    private Bot bot;

    @Autowired
    public Starter(@Qualifier("googleBot") Bot bot) {
        this.bot = bot;
    }

    public void start() throws IOException, InterruptedException {
        System.out.println("Запускаем приложение");
        bot.start();
    }
}
