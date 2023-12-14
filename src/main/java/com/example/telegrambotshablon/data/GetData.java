package com.example.telegrambotshablon.data;


import com.example.telegrambotshablon.config.BotConfig;
import com.example.telegrambotshablon.dto.SchoolPost;

import com.example.telegrambotshablon.dto.*;

import com.example.telegrambotshablon.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class GetData {
    private final UserService userService;
    private final BotConfig botConfig;

    public GetData(UserService userService, BotConfig botConfig) {
        this.userService = userService;
        this.botConfig = botConfig;
    }

    public String getSchoolEmployee(Long chatId) {
        SchoolPost userSchoolData = userService.getUserSchoolData(chatId);
        String data =

                "\uD83C\uDFE2 MAKTABGA XODIM KERAK\n\n" +

                        "\n\uD83C\uDFE2 Maktab(raqam): " + userSchoolData.getSchoolNumber() +
                        "\n\uD83D\uDCD7 Fan(lar) dars soati: " + userSchoolData.getSubjects() +
                        "\n\uD83D\uDCF1Telegram: " + userSchoolData.getUsername() +
                        "\n☎\uFE0F Aloqa: " + userSchoolData.getPhoneNumber() +
                        "\nⓂ\uFE0F Manzil: " + userSchoolData.getAddress() +
                        "\n\uD83D\uDD70 Murojaat vaqti: " + userSchoolData.getCallTime() +
                        "\n\uD83D\uDCDC Talablar : " + userSchoolData.getExtraInfo() +
                        "\n\n#ishJoyiMaktab\n\n" +
                        "➡\uFE0F @"+botConfig.getChannel()+" kanaliga ulanish";
        return data;
    }



    public String getEducationCenterEmployee(Long chatId) {
        XodimKerak xodimKerak = userService.getXodimKerakData(chatId);
        String data =
                "\uD83C\uDFEC TAJRIBALI XODIM KERAK\n\n" +
                        "\uD83C\uDFEC O'quv markaz: " + xodimKerak.getTrainingCenterName() +
                        "\n\uD83D\uDCD7 Fan(lar):" + xodimKerak.getSubjects() +
                        "\n\uD83D\uDCF1 Telegram:" + xodimKerak.getUsername() +
                        "\n☎\uFE0F Aloqa: " + xodimKerak.getPhoneNumber() +
                        "\nⓂ\uFE0F Manzil: " + xodimKerak.getAddress() +
                        "\n\uD83D\uDD70 Ish vaqti:" + xodimKerak.getWorkTime() +
                        "\n\uD83D\uDD70 Murojaat vaqti: " + xodimKerak.getCallTime() +
                        "\n\uD83D\uDCDC Qo'shimcha ma'lumotlar: " + xodimKerak.getExtraInfo() +
                        "\n\n#ishJoyi\n\n" +
                        "➡\uFE0F @"+botConfig.getChannel()+" kanaliga ulanish";
        return data;
    }

    public String getEduCenterTeacher(Long chatId) {
        UstozKerak ustozKerak = userService.getUstozKerakData(chatId);
        return
                "\uD83D\uDCBC USTOZ KERAK\n" +
                        "\n\uD83C\uDF93 Shogird: " + ustozKerak.getFullName() +
                        "\n\uD83C\uDF10 Yosh: " + ustozKerak.getAge() +
                        "\n\uD83D\uDCD7 Fan(lar): " + ustozKerak.getSubjects() +
                        "\n\uD83D\uDCF1 Telegram: " + ustozKerak.getUsername() +
                        "\n☎\uFE0F Aloqa: " + ustozKerak.getPhoneNumber() +
                        "\nⓂ\uFE0F Manzil: " + ustozKerak.getAddress() +
                        "\n\uD83D\uDCB0 Narxi: " + ustozKerak.getSalary() +
                        "\n\uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBB Kasbi: " + ustozKerak.getEmployee() +
                        "\n\uD83D\uDD70 Murojaat qilish vaqti: " + ustozKerak.getCallTime() +
                        "\n\uD83D\uDD0E Maqsad: " + ustozKerak.getMaqsad() +
                        "\n\n#shogird\n\n" +
                        "➡\uFE0F @"+botConfig.getChannel()+" kanaliga ulanish";

    }

    public String getEduCenterStudent(Long chatId) {
        ShogirdKerak shogirdKerak = userService.getShogirdKerakData(chatId);
        return
                "\uD83C\uDF92 SHOGIRD KERAK\n\n" +
                        "\uD83C\uDF93 Ustoz: " + shogirdKerak.getFullName() +
                        "\n\uD83C\uDF10 Yosh: " + shogirdKerak.getAge() +
                        "\n\uD83D\uDCD7 Fan(lar): " + shogirdKerak.getSubjects() +
                        "\n\uD83D\uDCF1 Telegram: " + shogirdKerak.getUsername() +
                        "\n☎\uFE0F Aloqa: " + shogirdKerak.getPhoneNumber() +
                        "\nⓂ\uFE0F Manzil: " + shogirdKerak.getAddress() +
                        "\n\uD83D\uDCB0 Narxi: " + shogirdKerak.getSalary() +
                        "\n\uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBB Kasbi: " + shogirdKerak.getEmployee() +
                        "\n\uD83D\uDD70 Murojaat qilish vaqti: " + shogirdKerak.getCallTime() +
                        "\n\uD83D\uDD0E Maqsad: " + shogirdKerak.getMaqsad() +
                        "\n\n#ustoz\n\n" +
                        "➡\uFE0F @"+botConfig.getChannel()+" kanaliga ulanish";
    }


    public String getWorkplace(Long chatId) {
        IshJoyiKerak ishJoyiKerak = userService.getIshJoyiKerakData(chatId);
        return                 "\uD83C\uDFEC ISH JOYI KERAK\n\n" +
                "\n\uD83D\uDC68\u200D\uD83D\uDCBC Xodim(\uD83E\uDDD5 Xodima): " + ishJoyiKerak.getFullName() +
                "\n\uD83C\uDF10 Yosh: " + ishJoyiKerak.getAge() +
                "\n\uD83D\uDCD7 Fan(lar): " + ishJoyiKerak.getSubjects() +
                "\n\uD83D\uDCF1 Telegram: " + ishJoyiKerak.getUsername() +
                "\n☎\uFE0F Aloqa: " + ishJoyiKerak.getPhoneNumber() +
                "\nⓂ\uFE0F Manzil: " + ishJoyiKerak.getAddress() +
                "\n\uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBB Kasbi: " + ishJoyiKerak.getEmployee() +
                "\n\uD83D\uDD70 Murojaat qilish vaqti: " + ishJoyiKerak.getCallTime() +
                "\n\uD83D\uDD0E Maqsad: " + ishJoyiKerak.getMaqsad() +
                "\n\n#xodim\n\n" +
                "➡\uFE0F @"+botConfig.getChannel()+" kanaliga ulanish";
    }

}
