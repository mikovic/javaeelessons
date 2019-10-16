package com.minakov.controller;


import com.minakov.persist.Message;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
@Named
@RequestScoped
public class MessageBean {
    @Inject
    private Message message;
    public MessageBean() {
    }
    public Message getMessage() {
        return message;
    }
    public void setMessage(Message message) {
        this.message = message;
    }
}

