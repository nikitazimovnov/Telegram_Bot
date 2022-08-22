package com.example.telegram_bot.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

    String name();

    String args();

    int minArgs() default 0;

    String desc();

    int maxArgs() default Integer.MAX_VALUE - 2;

    boolean showInHelpList() default true;

    String[] aliases();
}
