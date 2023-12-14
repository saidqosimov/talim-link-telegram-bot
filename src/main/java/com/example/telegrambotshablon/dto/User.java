package com.example.telegrambotshablon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long chatId;
    private String  MainStep;
    private String  schoolStep;
    private String centerStep;
}
