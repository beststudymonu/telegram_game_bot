package com.cbs.telegram.bot.telegram_api_connector.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bot_setting")
public class BotSetting {
    @Id
    @Column(name = "bot_name")
    private String name;
    @Column(name = "telegram_bot_id")
    private String telegramId;
    private String token;
}
