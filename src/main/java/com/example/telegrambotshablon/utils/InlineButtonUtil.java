package com.example.telegrambotshablon.utils;


import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InlineButtonUtil {

    public static InlineKeyboardButton button(String text , String callbackdata){
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText(text);
        inlineKeyboardButton.setCallbackData(callbackdata);
        return inlineKeyboardButton;
    }

    public static List<InlineKeyboardButton> row(InlineKeyboardButton... inlineKeyboardButtons){
        List<InlineKeyboardButton> row = new LinkedList<>();
        row.addAll(Arrays.asList(inlineKeyboardButtons));
        return row;
    }

    public static List<List<InlineKeyboardButton>> collection(List<InlineKeyboardButton>... lists){
        List<List<InlineKeyboardButton>> rowCollection = new LinkedList<>();
        rowCollection.addAll(Arrays.asList(lists));
        return rowCollection;
    }

    public static InlineKeyboardMarkup inlineKeyboardMarkup(List<List<InlineKeyboardButton>> collection){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(collection);
        return inlineKeyboardMarkup;
    }

}
