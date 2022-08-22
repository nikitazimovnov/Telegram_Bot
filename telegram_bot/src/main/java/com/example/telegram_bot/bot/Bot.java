package com.example.telegram_bot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.name}")
    private String botUserName = "my1024_tg_bot";

    @Value("${bot.token}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            SendMessage sm = new SendMessage();
            sm.setChatId(update.getMessage().getChatId());
            sm.setText("Hi!");
            execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
