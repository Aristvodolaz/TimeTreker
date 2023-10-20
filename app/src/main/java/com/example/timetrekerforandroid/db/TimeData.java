package com.example.timetrekerforandroid.db;

public class TimeData {
    public String login; //login studenta
    public String data; //day
    public String time; // time input or exit
    public String corpus; //name corpus
    public boolean type; // exit or input

    public TimeData() {
    }
    public TimeData(String login, String data, String time, String corpus, boolean type) {
        this.login = login;
        this.data = data;
        this.time = time;
        this.corpus = corpus;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCorpus() {
        return corpus;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
