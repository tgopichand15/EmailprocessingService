package com.example.EmailProcessingservice;

public interface Email {
    public int getCount();
    public String[] getEmail();
    public boolean markEmailAsRead();
}
