package com.example.telegrambotshablon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolPost {
    private Long chatId;
    private String schoolNumber;
    private String subjects;
    private String username;
    private String phoneNumber;
    private String address;
    private String callTime;
    private String extraInfo;
}
