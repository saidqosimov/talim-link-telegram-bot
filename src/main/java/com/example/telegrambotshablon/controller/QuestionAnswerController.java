package com.example.telegrambotshablon.controller;

import com.example.telegrambotshablon.data.GetData;
import com.example.telegrambotshablon.dto.*;
import com.example.telegrambotshablon.questions.Questions;
import com.example.telegrambotshablon.service.UserService;
import com.example.telegrambotshablon.utils.MainKeyboard;
import com.example.telegrambotshablon.utils.steps.MainStep;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class QuestionAnswerController {

    private final UserService userService;
    private final MainKeyboard mainKeyboard;
    private final MessageController messageController;
    private final GetData getData;

    public QuestionAnswerController(UserService userService, MainKeyboard mainKeyboard, MessageController messageController, GetData getData) {
        this.userService = userService;
        this.mainKeyboard = mainKeyboard;
        this.messageController = messageController;
        this.getData = getData;
    }

    public SendMessage schoolQuestionAnswer(SchoolPost userSchoolData,String text, Long chatId, String username) {
        if (userSchoolData.getSchoolNumber() == null) {
            userSchoolData.setSchoolNumber(text);
            userService.updateUserSchoolData(userSchoolData);
            return messageController.sendMsg(chatId, Questions.schoolQuestions[1] );
        } else if (userSchoolData.getSubjects() == null) {
            userSchoolData.setSubjects(text);
            userService.updateUserSchoolData(userSchoolData);
            return messageController.sendMsg(chatId, Questions.schoolQuestions[2]);
        } else if (userSchoolData.getPhoneNumber() == null) {
            userSchoolData.setPhoneNumber(text);
            userService.updateUserSchoolData(userSchoolData);
            return messageController.sendMsg(chatId, Questions.schoolQuestions[3]);
        } else if (userSchoolData.getAddress() == null) {
            userSchoolData.setAddress(text);
            userService.updateUserSchoolData(userSchoolData);
            return messageController.sendMsg(chatId, Questions.schoolQuestions[4]);
        } else if (userSchoolData.getCallTime() == null) {
            userSchoolData.setCallTime(text);
            userService.updateUserSchoolData(userSchoolData);
            return messageController.sendMsg(chatId, Questions.schoolQuestions[5]);
        } else if (userSchoolData.getExtraInfo() == null) {
            userSchoolData.setExtraInfo(text);
            if(username==null) {
                userSchoolData.setUsername("-");
            }else {
                userSchoolData.setUsername("@" + username);
            }
            userService.updateUserSchoolData(userSchoolData);
            userService.changeStep(chatId, MainStep.START,null,null);
            return messageController.sendMsg(chatId, getData.getSchoolEmployee(chatId), null, mainKeyboard.getApplyKeyboard());
        }
        return null;
    }

    public synchronized SendMessage eduEmployeeQuestionAnswer(XodimKerak xodimKerakData, String text, Long chatId, String username) {
        if (xodimKerakData.getTrainingCenterName() == null) {
            xodimKerakData.setTrainingCenterName(text);
            userService.updateXodimKerak(xodimKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterEmployee[1] );
        } else if (xodimKerakData.getPhoneNumber() == null) {
            xodimKerakData.setPhoneNumber(text);
            userService.updateXodimKerak(xodimKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterEmployee[2]);
        } else if (xodimKerakData.getAddress() == null) {
            xodimKerakData.setAddress(text);
            userService.updateXodimKerak(xodimKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterEmployee[3]);
        } else if (xodimKerakData.getWorkTime() == null) {
            xodimKerakData.setWorkTime(text);
            userService.updateXodimKerak(xodimKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterEmployee[4]);
        } else if (xodimKerakData.getCallTime() == null) {
            xodimKerakData.setCallTime(text);
            userService.updateXodimKerak(xodimKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterEmployee[5]);
        } else if (xodimKerakData.getExtraInfo() == null) {
            xodimKerakData.setExtraInfo(text);
            if(username==null) {
                xodimKerakData.setUsername("-");
            }else {
                xodimKerakData.setUsername("@" + username);
            }
            userService.updateXodimKerak(xodimKerakData);
            userService.changeStep(chatId, MainStep.START,null,null);
            return messageController.sendMsg(chatId, getData.getEducationCenterEmployee(chatId), null, mainKeyboard.getApplyKeyboard());
        }
        return null;
    }

    public SendMessage eduTeacherQuestionAnswer(UstozKerak ustozKerakData, String text, Long chatId, String username) {
        if (ustozKerakData.getFullName() == null) {
            ustozKerakData.setFullName(text);
            userService.updateUstozKerak(ustozKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterTeacher[1] );
        } else if (ustozKerakData.getAge() == null) {
            ustozKerakData.setAge(text);
            userService.updateUstozKerak(ustozKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterTeacher[2]);
        } else if (ustozKerakData.getSubjects() == null) {
            ustozKerakData.setSubjects(text);
            userService.updateUstozKerak(ustozKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterTeacher[3]);
        } else if (ustozKerakData.getPhoneNumber() == null) {
            ustozKerakData.setPhoneNumber(text);
            userService.updateUstozKerak(ustozKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterTeacher[4]);
        } else if (ustozKerakData.getAddress() == null) {
            ustozKerakData.setAddress(text);
            userService.updateUstozKerak(ustozKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterTeacher[5]);
        }  else if (ustozKerakData.getSalary() == null) {
            ustozKerakData.setSalary(text);
            userService.updateUstozKerak(ustozKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterTeacher[6]);
        }  else if (ustozKerakData.getEmployee() == null) {
            ustozKerakData.setEmployee(text);
            userService.updateUstozKerak(ustozKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterTeacher[7]);
        }   else if (ustozKerakData.getCallTime() == null) {
            ustozKerakData.setCallTime(text);
            userService.updateUstozKerak(ustozKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterTeacher[8]);
        } else if (ustozKerakData.getMaqsad() == null) {
            ustozKerakData.setMaqsad(text);
            if(username==null) {
                ustozKerakData.setUsername("-");
            }else {
                ustozKerakData.setUsername("@" + username);
            }
            userService.updateUstozKerak(ustozKerakData);
            userService.changeStep(chatId, MainStep.START,null,null);
            return messageController.sendMsg(chatId, getData.getEduCenterTeacher(chatId), null, mainKeyboard.getApplyKeyboard());
        }
        return null;
    }

    public SendMessage eduShogirdQuestionAnswer(ShogirdKerak shogirdKerakData, String text, Long chatId, String username) {
        if (shogirdKerakData.getFullName() == null) {
            shogirdKerakData.setFullName(text);
            userService.updateShogirdKerak(shogirdKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterStudent[1] );
        } else if (shogirdKerakData.getAge() == null) {
            shogirdKerakData.setAge(text);
            userService.updateShogirdKerak(shogirdKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterStudent[2]);
        } else if (shogirdKerakData.getSubjects() == null) {
            shogirdKerakData.setSubjects(text);
            userService.updateShogirdKerak(shogirdKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterStudent[3]);
        } else if (shogirdKerakData.getPhoneNumber() == null) {
            shogirdKerakData.setPhoneNumber(text);
            userService.updateShogirdKerak(shogirdKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterStudent[4]);
        } else if (shogirdKerakData.getAddress() == null) {
            shogirdKerakData.setAddress(text);
            userService.updateShogirdKerak(shogirdKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterStudent[5]);
        }  else if (shogirdKerakData.getSalary() == null) {
            shogirdKerakData.setSalary(text);
            userService.updateShogirdKerak(shogirdKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterStudent[6]);
        }  else if (shogirdKerakData.getEmployee() == null) {
            shogirdKerakData.setEmployee(text);
            userService.updateShogirdKerak(shogirdKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterStudent[7]);
        }   else if (shogirdKerakData.getCallTime() == null) {
            shogirdKerakData.setCallTime(text);
            userService.updateShogirdKerak(shogirdKerakData);
            return messageController.sendMsg(chatId, Questions.educationCenterStudent[8]);
        } else if (shogirdKerakData.getMaqsad() == null) {
            shogirdKerakData.setMaqsad(text);
            if(username==null) {
                shogirdKerakData.setUsername("-");
            }else {
                shogirdKerakData.setUsername("@" + username);
            }
            userService.updateShogirdKerak(shogirdKerakData);
            userService.changeStep(chatId, MainStep.START,null,null);
            return messageController.sendMsg(chatId, getData.getEduCenterStudent(chatId), null, mainKeyboard.getApplyKeyboard());
        }
        return null;
    }

    public SendMessage eduWorkplaceQuestionAnswer(IshJoyiKerak ishJoyiKerakData, String text, Long chatId, String username) {
        if (ishJoyiKerakData.getFullName() == null) {
            ishJoyiKerakData.setFullName(text);
            userService.updateIshJoyiKerak(ishJoyiKerakData);
            return messageController.sendMsg(chatId, Questions.workplace[1] );
        } else if (ishJoyiKerakData.getAge() == null) {
            ishJoyiKerakData.setAge(text);
            userService.updateIshJoyiKerak(ishJoyiKerakData);
            return messageController.sendMsg(chatId, Questions.workplace[2]);
        } else if (ishJoyiKerakData.getSubjects() == null) {
            ishJoyiKerakData.setSubjects(text);
            userService.updateIshJoyiKerak(ishJoyiKerakData);
            return messageController.sendMsg(chatId, Questions.workplace[3]);
        } else if (ishJoyiKerakData.getPhoneNumber() == null) {
            ishJoyiKerakData.setPhoneNumber(text);
            userService.updateIshJoyiKerak(ishJoyiKerakData);
            return messageController.sendMsg(chatId, Questions.workplace[4]);
        } else if (ishJoyiKerakData.getAddress() == null) {
            ishJoyiKerakData.setAddress(text);
            userService.updateIshJoyiKerak(ishJoyiKerakData);
            return messageController.sendMsg(chatId, Questions.workplace[5]);
        } else if (ishJoyiKerakData.getEmployee() == null) {
            ishJoyiKerakData.setEmployee(text);
            userService.updateIshJoyiKerak(ishJoyiKerakData);
            return messageController.sendMsg(chatId, Questions.workplace[6]);
        }   else if (ishJoyiKerakData.getCallTime() == null) {
            ishJoyiKerakData.setCallTime(text);
            userService.updateIshJoyiKerak(ishJoyiKerakData);
            return messageController.sendMsg(chatId, Questions.workplace[7]);
        } else if (ishJoyiKerakData.getMaqsad() == null) {
            ishJoyiKerakData.setMaqsad(text);
            if(username==null) {
                ishJoyiKerakData.setUsername("-");
            }else {
                ishJoyiKerakData.setUsername("@" + username);
            }
            userService.updateIshJoyiKerak(ishJoyiKerakData);
            userService.changeStep(chatId, MainStep.START,null,null);
            return messageController.sendMsg(chatId, getData.getWorkplace(chatId), null, mainKeyboard.getApplyKeyboard());
        }
        return null;
    }
}
