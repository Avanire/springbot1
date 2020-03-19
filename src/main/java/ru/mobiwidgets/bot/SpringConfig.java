package ru.mobiwidgets.bot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.mobiwidgets.bot")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

}
