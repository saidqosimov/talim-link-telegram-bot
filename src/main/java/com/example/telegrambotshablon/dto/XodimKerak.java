package com.example.telegrambotshablon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class XodimKerak {
    private Long chatId;
    private String trainingCenterName;
    private String subjects;
    private String username;
    private String phoneNumber;
    private String address;
    private String workTime;
    private String callTime;
    private String salary;
    private String extraInfo;
}
