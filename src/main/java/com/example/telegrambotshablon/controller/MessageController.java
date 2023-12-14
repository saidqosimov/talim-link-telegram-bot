package com.example.telegrambotshablon.controller;

import com.example.telegrambotshablon.service.UserService;
import com.example.telegrambotshablon.utils.MainKeyboard;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
public class MessageController {
    private final MainKeyboard mainKeyboard;
    private final UserService userService;

    public MessageController(MainKeyboard mainKeyboard, UserService userService) {
        this.mainKeyboard = mainKeyboard;
        this.userService = userService;
    }


    public synchronized SendMessage sendMsg(Long chatId, String text, ReplyKeyboardMarkup replyKeyboardMarkup, InlineKeyboardMarkup inline) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        if (replyKeyboardMarkup != null) {
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
        }
        if (inline != null) {
            sendMessage.setReplyMarkup(inline);
        }
        return sendMessage;
    }

    public synchronized SendMessage sendMsg(Long chatId, String text) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        return sendMessage;
    }
}
