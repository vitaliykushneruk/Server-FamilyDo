package com.kushneruk.vitaliy.serverfamilydo.registration;

import com.kushneruk.vitaliy.serverfamilydo.persistence.model.User;
import org.springframework.context.ApplicationEvent;

public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private final User user;
    private final String appUrl;

    public OnRegistrationCompleteEvent(final User user, final String appUrl) {
        super(user);
        this.user = user;
        this.appUrl = appUrl;
    }

    public User getUser() {
        return user;
    }

    public String getAppUrl() {
        return appUrl;
    }
}
