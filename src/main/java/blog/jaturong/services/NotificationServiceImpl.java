package blog.jaturong.services;


import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class NotificationServiceImpl implements NotificationService {

    public static final String NOTIFY_MSG_SESSION_KEY = "siteNotificationMessages";

    @Autowired
    private HttpSession httpSession;

    @Override
    public void addInfoMessage(String msg) {

    }

    @Override
    public void addErrorMessage(String msg) {

    }
}
