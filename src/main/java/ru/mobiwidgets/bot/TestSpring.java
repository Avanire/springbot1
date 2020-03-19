package ru.mobiwidgets.bot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TestSpring {
    public static void main(String[] args) throws IOException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
          BotConfig.class
        );

        Bot bot = context.getBean("yandexBot", YandexBot.class);
        bot.start();

        context.close();
    }
}
