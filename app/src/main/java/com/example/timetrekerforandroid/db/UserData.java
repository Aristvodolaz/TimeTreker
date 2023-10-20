package com.example.timetrekerforandroid.db;

public class UserData {
    public String name;
    public String surname;
    public String group;
    public String type; // worker=0 or student=1
    public String institute;
    public String cafedra;
    public String date_birth;

    public String login;

    public UserData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public UserData(String name, String surname, String group, String type, String institute, String cafedra, String date_birth, String login) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.type = type;
        this.institute = institute;
        this.cafedra = cafedra;
        this.date_birth = date_birth;
        this.login = login;
    }
}
