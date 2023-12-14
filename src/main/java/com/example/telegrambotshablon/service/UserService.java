package com.example.telegrambotshablon.service;

import com.example.telegrambotshablon.dto.*;
import com.example.telegrambotshablon.utils.steps.MainStep;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserService {
    Map<Long, User> user = new HashMap<>();
    Map<Long, SchoolPost> schoolPostMap = new HashMap<>();
    Map<Long, XodimKerak> xodimKerakMap = new HashMap<>();
    Map<Long, UstozKerak> ustozKerakMap = new HashMap<>();
    Map<Long, ShogirdKerak> shogirdKerakMap = new HashMap<>();
    Map<Long, IshJoyiKerak> ishJoyiKerakMap = new HashMap<>();


    public User getUserByChatId(Long chatId) {
        return user.get(chatId);
    }

    public synchronized void addUser(Long chatId) {
        User newUser = new User();
        newUser.setChatId(chatId);
        newUser.setMainStep(MainStep.START);
        user.put(chatId, newUser);
    }

    public synchronized void changeStep(Long chatId, String  mainStep, String  schoolStep, String  centerStep) {
        User currentUser = new User();
        currentUser.setChatId(chatId);
        currentUser.setMainStep(mainStep);
        currentUser.setSchoolStep(schoolStep);
        currentUser.setCenterStep(centerStep);
        user.put(chatId, currentUser);
    }

    public synchronized void updateUserSchoolData(SchoolPost schoolPost) {
        Long chatId = schoolPost.getChatId();
        schoolPostMap.put(chatId, schoolPost);
    }

    public synchronized SchoolPost getUserSchoolData(Long chatId) {
        return schoolPostMap.get(chatId);
    }

    public synchronized void updateXodimKerak(XodimKerak xodimKerak){
        Long chatId = xodimKerak.getChatId();
        xodimKerakMap.put(chatId,xodimKerak);
    }
    public synchronized XodimKerak getXodimKerakData(Long chatId){
        return xodimKerakMap.get(chatId);
    }

    public synchronized void updateUstozKerak(UstozKerak ustozKerak){
        Long chatId = ustozKerak.getChatId();
        ustozKerakMap.put(chatId,ustozKerak);
    }
    public synchronized UstozKerak getUstozKerakData(Long chatId){
        return ustozKerakMap.get(chatId);
    }
    public synchronized void updateShogirdKerak(ShogirdKerak shogirdKerak){
        Long chatId = shogirdKerak.getChatId();
        shogirdKerakMap.put(chatId,shogirdKerak);
    }
    public synchronized ShogirdKerak getShogirdKerakData(Long chatId){
        return shogirdKerakMap.get(chatId);
    }
    public synchronized void updateIshJoyiKerak(IshJoyiKerak ishJoyiKerak){
        Long chatId = ishJoyiKerak.getChatId();
        ishJoyiKerakMap.put(chatId,ishJoyiKerak);
    }
    public synchronized IshJoyiKerak getIshJoyiKerakData(Long chatId){
        return ishJoyiKerakMap.get(chatId);
    }

    public synchronized void clearUsersData(Long chatId){
        xodimKerakMap.remove(chatId);
        ustozKerakMap.remove(chatId);
        shogirdKerakMap.remove(chatId);
        ishJoyiKerakMap.remove(chatId);
        schoolPostMap.remove(chatId);
    }

}
