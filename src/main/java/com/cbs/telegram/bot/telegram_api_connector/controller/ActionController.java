package com.cbs.telegram.bot.telegram_api_connector.controller;

import com.cbs.telegram.bot.telegram_api_connector.dto.ActionDto;
import com.cbs.telegram.bot.telegram_api_connector.entity.Action;
import com.cbs.telegram.bot.telegram_api_connector.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("action")
public class ActionController {
    private final ActionService actionService;

    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping("/get/{actionId}")
    public ActionDto getNextAction(@PathVariable Long actionId) {
        return actionService.getAction(actionId);
    }

    @PostMapping("/add")
    public Action addChild(Long actionId, String text) {
        return actionService.addChild(actionId, text);
    }

    @PostMapping("/updateMessage")
    public Action updateMessage(Long actionId, String text) {
        return actionService.updateActionMessage(actionId, text);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long actionId) {
        actionService.deleteAction(actionId);
    }
}
