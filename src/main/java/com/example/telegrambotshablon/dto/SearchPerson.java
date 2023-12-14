package com.example.telegrambotshablon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchPerson {
    private Long chatId;
    private String fullName;
    private String age;
    private String subjects;
    private String username;
    private String phoneNumber;
    private String address;
    private String salary;
    private String employee;
    private String callTime;
    private String maqsad;
}
