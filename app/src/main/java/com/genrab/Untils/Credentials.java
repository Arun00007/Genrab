package com.genrab.Untils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by intel on 6/9/2017.
 */

public class Credentials {
    private static final String APP_KEY = "genrab";
    private static final String USER_ID = "user_id";
    private static final String USER_LOGIN = "login";
    private static final String USER_EMAIL = "email";
    private static final String COUNTRY_ID = "country_id";

    public static void SaveUserID(int id, Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP_KEY, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(USER_ID, id);
        editor.apply();
    }

    public static int getUserID(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP_KEY, Activity.MODE_PRIVATE);
        return preferences.getInt(USER_ID, 0);
    }


    public static void SaveUserEmail(String email, Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP_KEY, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_EMAIL, email);
        editor.apply();
    }

    public static String getUserEmail(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP_KEY, Activity.MODE_PRIVATE);
        return preferences.getString(USER_EMAIL, "");
    }


    public static String getCountryId(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP_KEY, Activity.MODE_PRIVATE);
        return preferences.getString(COUNTRY_ID, "");
    }

    public static void SaveCountryId(String countryId, Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP_KEY, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(COUNTRY_ID, countryId);
        editor.apply();
    }

    //******************SAVE USER LOGIN*********************//
    public static void SaveuserLogin(boolean value, Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP_KEY, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(USER_LOGIN, value);
        editor.apply();
    }

    public static boolean getSaveUserLogin(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP_KEY, Activity.MODE_PRIVATE);
        return preferences.getBoolean(USER_LOGIN, false);
    }
    //**********************END*************************//

    //***********************SAVE LOGOUT SESSION***************//
    public static void logout(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP_KEY, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
    //***********************END***************//

}
