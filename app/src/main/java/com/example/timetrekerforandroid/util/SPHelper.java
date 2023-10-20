package com.example.timetrekerforandroid.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.timetrekerforandroid.ApplicationLoader;

public class SPHelper {
    public static final String FILE_NAME = "treker";
    public static final String LOGIN = "login_user";

    public static final String PHONE_MODEL = "phone_model";
    public static final String INSTITUTE = "institute";
    public static final String CAFEDRA = "cafedra";
    public static final String GROUP = "group";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String VHOD_TIME = "vhod_time";
    public static final String LAST_UNIQ_KEY = "uniq_key";

    private static SharedPreferences getPrefs() {
        return ApplicationLoader.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getEdit() {
        return getPrefs().edit();
    }

    public static void setLogin(String lat) {
        getEdit().putString(LOGIN, lat).commit();
    }
    public static String getLogin() {
        return getPrefs().getString(LOGIN, "");
    }

    public static void setPhoneModel(String phone){
        getEdit().putString(PHONE_MODEL, phone).commit();
    }
    public static String getPhoneModel(){
        return getPrefs().getString(PHONE_MODEL, "");
    }

    public static void setInstitute(String lat) {
        getEdit().putString(INSTITUTE, lat).commit();
    }
    public static String getInstitute() {
        return getPrefs().getString(INSTITUTE, "");
    }

    public static void setCafedra(String lat) {
        getEdit().putString(CAFEDRA, lat).commit();
    }
    public static String getCafedra() {
        return getPrefs().getString(CAFEDRA, "");
    }

    public static void setGroup(String lat) {
        getEdit().putString(GROUP, lat).commit();
    }
    public static String getGroup() {
        return getPrefs().getString(GROUP, "");
    }

    public static void setName(String lat) {
        getEdit().putString(NAME, lat).commit();
    }
    public static String getName() {
        return getPrefs().getString(NAME, "");
    }

    public static void setSurname(String lat) {
        getEdit().putString(SURNAME, lat).commit();
    }
    public static String getSurname() {
        return getPrefs().getString(SURNAME, "");
    }
    public static void setVhodTime(String lat) {
        getEdit().putString(VHOD_TIME, lat).commit();
    }
    public static String getVhodTime() {
        return getPrefs().getString(VHOD_TIME, "");
    }

    public static void setLastUniqKey(String lat) {
        getEdit().putString(LAST_UNIQ_KEY, lat).commit();
    }
    public static String getLastUniqKey() {
        return getPrefs().getString(LAST_UNIQ_KEY, "");
    }

}
