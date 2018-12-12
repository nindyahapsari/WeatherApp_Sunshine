/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nindyahapsari.android.sunshine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nindyahapsari.android.sunshine.data.WeatherContract.WeatherEntry;

/**
 * Manages a local database for weather data.
 */
public class WeatherDbHelper extends SQLiteOpenHelper {



    public static final String DATABASE_NAME = "weather.db";



    private static final int DATABASE_VERSION = 3;

    public WeatherDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {



        final String SQL_CREATE_WEATHER_TABLE =

                "CREATE TABLE " + WeatherEntry.TABLE_NAME + " (" +



                WeatherEntry._ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                WeatherEntry.COLUMN_DATE       + " INTEGER NOT NULL, "                 +

                WeatherEntry.COLUMN_WEATHER_ID + " INTEGER NOT NULL,"                  +

                WeatherEntry.COLUMN_MIN_TEMP   + " REAL NOT NULL, "                    +
                WeatherEntry.COLUMN_MAX_TEMP   + " REAL NOT NULL, "                    +

                WeatherEntry.COLUMN_HUMIDITY   + " REAL NOT NULL, "                    +
                WeatherEntry.COLUMN_PRESSURE   + " REAL NOT NULL, "                    +

                WeatherEntry.COLUMN_WIND_SPEED + " REAL NOT NULL, "                    +
                WeatherEntry.COLUMN_DEGREES    + " REAL NOT NULL, "                    +



                " UNIQUE (" + WeatherEntry.COLUMN_DATE + ") ON CONFLICT REPLACE);";


        sqLiteDatabase.execSQL(SQL_CREATE_WEATHER_TABLE);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WeatherEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}