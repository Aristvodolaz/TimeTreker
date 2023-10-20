package com.example.timetrekerforandroid.db;

public class UserTimeData {
    public String name;
    public String institute;
    public String cafedra;
    public String group;
    public String vhod;
    public String vyhod;
    public String data;
    public String corpus;
    public String login;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getCafedra() {
        return cafedra;
    }

    public void setCafedra(String cafedra) {
        this.cafedra = cafedra;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getVhod() {
        return vhod;
    }

    public void setVhod(String vhod) {
        this.vhod = vhod;
    }

    public String getVyhod() {
        return vyhod;
    }

    public void setVyhod(String vyhod) {
        this.vyhod = vyhod;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCorpus() {
        return corpus;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserTimeData() {
    }

    public UserTimeData(String name, String institute, String cafedra, String group, String vhod, String vyhod, String data, String corpus, String login) {
        this.name = name;
        this.institute = institute;
        this.cafedra = cafedra;
        this.group = group;
        this.vhod = vhod;
        this.vyhod = vyhod;
        this.data = data;
        this.corpus = corpus;
        this.login = login;
    }
}
