package com.example.demotuan3;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveUserListener implements ServletContextListener, HttpSessionListener {

    private static final String ACTIVE_USERS_ATTRIBUTE = "activeUsersCount";

    private static final AtomicInteger activeSessions = new AtomicInteger(0);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        activeSessions.set(0);

        sce.getServletContext().setAttribute(
                ACTIVE_USERS_ATTRIBUTE,
                activeSessions
        );

        System.out.println(">>> APPLICATION START - active users = "
                + activeSessions.get());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(">>> APPLICATION STOP - active users = "
                + activeSessions.get());

        activeSessions.set(0);

        sce.getServletContext().removeAttribute(ACTIVE_USERS_ATTRIBUTE);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        AtomicInteger activeUsers =
                (AtomicInteger) se.getSession()
                        .getServletContext()
                        .getAttribute(ACTIVE_USERS_ATTRIBUTE);

        if (activeUsers != null) {
            int count = activeUsers.incrementAndGet();

            System.out.println(
                    ">>> SESSION CREATED: "
                            + se.getSession().getId()
                            + " | ACTIVE USERS = "
                            + count
            );
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        AtomicInteger activeUsers =
                (AtomicInteger) se.getSession()
                        .getServletContext()
                        .getAttribute(ACTIVE_USERS_ATTRIBUTE);

        if (activeUsers != null) {
            int count = activeUsers.decrementAndGet();

            if (count < 0) {
                activeUsers.set(0);
                count = 0;
            }

            System.out.println(
                    ">>> SESSION DESTROYED: "
                            + se.getSession().getId()
                            + " | ACTIVE USERS = "
                            + count
            );
        }
    }
}