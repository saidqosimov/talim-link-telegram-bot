package com.example.telegrambotshablon.service;

import com.example.telegrambotshablon.config.BotConfig;
import com.example.telegrambotshablon.controller.MessageController;
import com.example.telegrambotshablon.data.GetData;
import com.example.telegrambotshablon.dto.SchoolPost;
import com.example.telegrambotshablon.controller.QuestionAnswerController;
import com.example.telegrambotshablon.dto.*;
import com.example.telegrambotshablon.questions.Questions;
import com.example.telegrambotshablon.utils.ButtonsName;
import com.example.telegrambotshablon.utils.MainKeyboard;
import com.example.telegrambotshablon.utils.steps.MainStep;
import com.example.telegrambotshablon.utils.steps.SchoolStep;
import com.example.telegrambotshablon.utils.steps.StudyCenterStep;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    private final BotConfig botConfig;
    private final MessageController messageController;
    private final UserService userService;
    private final MainKeyboard mainKeyboard;
    private final GetData getData;
    private final QuestionAnswerController questionAnswerController;


    @SneakyThrows
    public TelegramBot(BotConfig botConfig,
                       MessageController messageController,
                       UserService userService,
                       MainKeyboard mainKeyboard,
                       GetData getData,
                       QuestionAnswerController questionAnswerController) {

        this.botConfig = botConfig;
        this.messageController = messageController;
        this.userService = userService;
        this.mainKeyboard = mainKeyboard;
        this.getData = getData;


        this.questionAnswerController = questionAnswerController;

    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {

            Message message = update.getMessage();
            String text = message.getText();
            Long chatId = message.getChatId();

            if (text.equals("/start")) {
                if (userService.getUserByChatId(chatId) == null) {
                    userService.addUser(chatId);
                }
                sendMessage(messageController.sendMsg(chatId, ButtonsName.START, mainKeyboard.getMainKeyboard(), null));
                userService.changeStep(chatId, MainStep.START, null, null);
            } else if (text.equals("/help")) {
                sendMessage(messageController.sendMsg(chatId, ButtonsName.HELP));
            } else if (text.equals(ButtonsName.BACK) || text.equals(ButtonsName.BACK_MENU)) {
                userService.changeStep(chatId, MainStep.START, null, null);
                userService.clearUsersData(chatId);
                sendMessage(messageController.sendMsg(chatId, "Asosiy menyu:", mainKeyboard.getMainKeyboard(), null));
            } else if (text.equals(ButtonsName.SCHOOL) && userService.getUserByChatId(chatId).getMainStep().equals(MainStep.START)) {
                userService.changeStep(chatId, MainStep.SCHOOL, null, null);
                sendMessage(messageController.sendMsg(chatId, "Tanlang:", mainKeyboard.getSchoolCategory(), null));
            }


            else if (userService.getUserByChatId(chatId)==null) {
                userService.addUser(chatId);
                sendMessage(messageController.sendMsg(chatId, "Asosiy menyu:", mainKeyboard.getMainKeyboard(), null));
            }
            //Maktab
               else if (text.equals(ButtonsName.EMPLOYEE) && userService.getUserByChatId(chatId).getMainStep().equals(MainStep.SCHOOL)) {
                    userService.changeStep(chatId, MainStep.SCHOOL, SchoolStep.EMPLOYEE, null);
                    sendMessage(messageController.sendMsg(chatId, "Xоdim topish uchun ariza berish\n" +
                            "\n" +
                            "Hozir sizga bir necha savollar beriladi. \n" +
                            "Har biriga javob bering. \n" +
                            "Oxirida agar hammasi to'g'ri bo'lsa, Tasdiqlash tugmasini bosing va arizangiz Adminga yuboriladi."));

                    sendMessage(messageController.sendMsg(chatId, Questions.schoolQuestions[0], mainKeyboard.getEnterDataProcess(), null));

                    SchoolPost schoolPost = new SchoolPost();
                    schoolPost.setChatId(chatId);
                    userService.updateUserSchoolData(schoolPost);
                } else if (userService.getUserByChatId(chatId).getMainStep().equals(MainStep.SCHOOL) && userService.getUserByChatId(chatId).getSchoolStep().equals(SchoolStep.EMPLOYEE)) {
                    sendMessage(questionAnswerController.schoolQuestionAnswer(userService.getUserSchoolData(chatId), text, chatId, message.getFrom().getUserName()));
                }

                //O'quv markaz

                else if (text.equals(ButtonsName.EDUCATION_CENTER) && userService.getUserByChatId(chatId).getMainStep().equals(MainStep.START)) {
                    userService.changeStep(chatId, MainStep.EDUCATION_CENTER, null, null);
                    sendMessage(messageController.sendMsg(chatId, "Tanlang:", mainKeyboard.getEducationCenterCategory(), null));
                } else if (text.equals(ButtonsName.EMPLOYEE)) {
                    userService.changeStep(chatId, MainStep.EDUCATION_CENTER, null, StudyCenterStep.EMPLOYEE);
                    sendMessage(messageController.sendMsg(chatId, "Xodim topish uchun ariza berish\n" +
                            "\n" +
                            "Hozir sizga bir necha savollar beriladi. \n" +
                            "Har biriga javob bering. \n" +
                            "Oxirida agar hammasi to'g'ri bo'lsa, Tasdiqlash tugmasini bosing va arizangiz Adminga yuboriladi."));
                    sendMessage(messageController.sendMsg(chatId, Questions.educationCenterEmployee[0], mainKeyboard.getEnterDataProcess(), null));
                    XodimKerak xodimKerak = new XodimKerak();
                    xodimKerak.setChatId(chatId);
                    userService.updateXodimKerak(xodimKerak);
                } else if (text.equals(ButtonsName.TEACHER)) {
                    userService.changeStep(chatId, MainStep.EDUCATION_CENTER, null, StudyCenterStep.TEACHER);
                    sendMessage(messageController.sendMsg(chatId, "Ustoz topish uchun ariza berish\n" +
                            "\n" +
                            "Hozir sizga bir necha savollar beriladi. \n" +
                            "Har biriga javob bering. \n" +
                            "Oxirida agar hammasi to'g'ri bo'lsa, Tasdiqlash tugmasini bosing va arizangiz Adminga yuboriladi."));
                    sendMessage(messageController.sendMsg(chatId, Questions.educationCenterTeacher[0], mainKeyboard.getEnterDataProcess(), null));
                    UstozKerak ustozKerak = new UstozKerak();
                    ustozKerak.setChatId(chatId);
                    userService.updateUstozKerak(ustozKerak);
                } else if (text.equals(ButtonsName.STUDENT)) {
                    userService.changeStep(chatId, MainStep.EDUCATION_CENTER, null, StudyCenterStep.STUDENT);
                    sendMessage(messageController.sendMsg(chatId, "Shogird topish uchun ariza berish\n" +
                            "\n" +
                            "Hozir sizga bir necha savollar beriladi. \n" +
                            "Har biriga javob bering. \n" +
                            "Oxirida agar hammasi to'g'ri bo'lsa, Tasdiqlash tugmasini bosing va arizangiz Adminga yuboriladi."));
                    sendMessage(messageController.sendMsg(chatId, Questions.educationCenterStudent[0], mainKeyboard.getEnterDataProcess(), null));
                    ShogirdKerak shogirdKerak = new ShogirdKerak();
                    shogirdKerak.setChatId(chatId);
                    userService.updateShogirdKerak(shogirdKerak);
                } else if (text.equals(ButtonsName.WORKPLACE)) {
                    userService.changeStep(chatId, MainStep.EDUCATION_CENTER, null, StudyCenterStep.WORKPLACE);
                    sendMessage(messageController.sendMsg(chatId, "Ish joyi topish uchun ariza berish\n" +
                            "\n" +
                            "Hozir sizga bir necha savollar beriladi. \n" +
                            "Har biriga javob bering. \n" +
                            "Oxirida agar hammasi to'g'ri bo'lsa, Tasdiqlash tugmasini bosing va arizangiz Adminga yuboriladi."));
                    sendMessage(messageController.sendMsg(chatId, Questions.workplace[0], mainKeyboard.getEnterDataProcess(), null));
                    IshJoyiKerak ishJoyiKerak = new IshJoyiKerak();
                    ishJoyiKerak.setChatId(chatId);
                    userService.updateIshJoyiKerak(ishJoyiKerak);
                } else if (userService.getUserByChatId(chatId).getCenterStep().equals(StudyCenterStep.EMPLOYEE)) {
                    sendMessage(questionAnswerController.eduEmployeeQuestionAnswer(userService.getXodimKerakData(chatId), text, chatId, message.getFrom().getUserName()));
                } else if (userService.getUserByChatId(chatId).getCenterStep().equals(StudyCenterStep.TEACHER)) {
                    sendMessage(questionAnswerController.eduTeacherQuestionAnswer(userService.getUstozKerakData(chatId), text, chatId, message.getFrom().getUserName()));
                } else if (userService.getUserByChatId(chatId).getCenterStep().equals(StudyCenterStep.STUDENT)) {
                    sendMessage(questionAnswerController.eduShogirdQuestionAnswer(userService.getShogirdKerakData(chatId), text, chatId, message.getFrom().getUserName()));
                } else if (userService.getUserByChatId(chatId).getCenterStep().equals(StudyCenterStep.WORKPLACE)) {
                    sendMessage(questionAnswerController.eduWorkplaceQuestionAnswer(userService.getIshJoyiKerakData(chatId), text, chatId, message.getFrom().getUserName()));
                } else {
                    sendMessage(messageController.sendMsg(chatId, "Asosiy menyu:", mainKeyboard.getMainKeyboard(), null));
                }

        } else if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            Long chatId = update.getCallbackQuery().getFrom().getId();
            int id = update.getCallbackQuery().getMessage().getMessageId();
            String resume = getResume(chatId);
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(id);
            editMessageText.setText(resume);
            execute(editMessageText);
            if (data.equals(ButtonsName.TRUE)) {
                sendMessage(messageController.sendMsg(botConfig.getAdmin(), resume));
                sendMessage(messageController.sendMsg(chatId, "Xabar 24 soat ichida adminlar tomonidan ko'rib chiqilib kanalimizga joylanadi"));
            }
            sendMessage(messageController.sendMsg(chatId, "Asosiy menyu:", mainKeyboard.getMainKeyboard(), null));
        }
    }

    private String getResume(Long chatId) {
        if (userService.getXodimKerakData(chatId) != null) {
            return getData.getEducationCenterEmployee(chatId);
        } else if (userService.getUstozKerakData(chatId) != null) {
            return getData.getEduCenterTeacher(chatId);
        } else if (userService.getShogirdKerakData(chatId) != null) {
            return getData.getEduCenterStudent(chatId);
        } else if (userService.getIshJoyiKerakData(chatId) != null) {
            return getData.getWorkplace(chatId);
        } else if (userService.getUserSchoolData(chatId) != null) {
            return getData.getSchoolEmployee(chatId);
        }
        return null;
    }


    @SneakyThrows
    public void sendMessage(SendMessage sendMessage) {
        execute(sendMessage);
    }

    @Override
    public String getBotUsername() {
        return botConfig.getUsername();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
}