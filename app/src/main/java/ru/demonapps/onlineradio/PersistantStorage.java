/*
 * *
 *  * Created by DemonApps on 19.05.2022, 20:09
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 19.05.2022, 20:09
 *
 */

package ru.demonapps.onlineradio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class PersistantStorage {
    public static final String STORAGE_NAME = "StorageName";

    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;
    @SuppressLint("StaticFieldLeak")
    private static Context context = null;

    public static void init(Context cntxt) {
        context = cntxt;
    }

    static void init() {
        settings = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
    }

    public static void addProperty(String name, String value) {
        if (settings == null) {
            init();
        }
        editor.putString(name, value);
        editor.apply() ;
    }

    public static String getProperty(String name) {
        if (settings == null) {
            init();
        }
        return settings.getString(name, null);
    }
}
