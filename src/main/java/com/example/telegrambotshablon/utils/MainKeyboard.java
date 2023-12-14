package com.example.telegrambotshablon.utils;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
public class MainKeyboard {
    public ReplyKeyboardMarkup getMainKeyboard() {
        return KeyboardButtonUtil.keyboard(KeyboardButtonUtil.collection(
                        KeyboardButtonUtil.row(

                                KeyboardButtonUtil.button(ButtonsName.EDUCATION_CENTER),

                                KeyboardButtonUtil.button(ButtonsName.SCHOOL)
                        )
                )
        );
    }

    public ReplyKeyboardMarkup getEnterDataProcess() {
        return KeyboardButtonUtil.keyboard(KeyboardButtonUtil.collection(
                        KeyboardButtonUtil.row(
                                KeyboardButtonUtil.button(ButtonsName.BACK)
                        )
                )
        );
    }

    public ReplyKeyboardMarkup getSchoolCategory() {
        return KeyboardButtonUtil.keyboard(KeyboardButtonUtil.collection(
                        KeyboardButtonUtil.row(
                                KeyboardButtonUtil.button(ButtonsName.EMPLOYEE)),
                        KeyboardButtonUtil.row(
                                KeyboardButtonUtil.button(ButtonsName.BACK_MENU))
                )
        );
    }

    public ReplyKeyboardMarkup getEducationCenterCategory() {
        return KeyboardButtonUtil.keyboard(KeyboardButtonUtil.collection(
                        KeyboardButtonUtil.row(
                                KeyboardButtonUtil.button(ButtonsName.EMPLOYEE),
                                KeyboardButtonUtil.button(ButtonsName.TEACHER)

                        ),                        KeyboardButtonUtil.row(
                                KeyboardButtonUtil.button(ButtonsName.STUDENT),
                                KeyboardButtonUtil.button(ButtonsName.WORKPLACE)
                        ),
                        KeyboardButtonUtil.row(
                                KeyboardButtonUtil.button(ButtonsName.BACK_MENU))
                )
        );
    }

    public InlineKeyboardMarkup getApplyKeyboard() {
        return InlineButtonUtil.inlineKeyboardMarkup(InlineButtonUtil.collection(
                InlineButtonUtil.row(
                        InlineButtonUtil.button("✅ Tasdiqlash", ButtonsName.TRUE)),
                InlineButtonUtil.row(
                        InlineButtonUtil.button("❌ Bekor qilish", ButtonsName.FALSE))
        ));
    }

}
