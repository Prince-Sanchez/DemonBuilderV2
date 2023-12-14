package com.example.demonbuilder.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.demonbuilder.User;

@Database(entities = {User.class}, version = 2)
public abstract class DemonBuilderDatabase extends RoomDatabase {

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Migration logic
        }

    public abstract UserDAO userDAO();

    private static volatile DemonBuilderDatabase INSTANCE;

    public static DemonBuilderDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (DemonBuilderDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            DemonBuilderDatabase.class,
                            "app_database"
                    ).addCallback(new Callback() {
                        @Override
                        public void onCreate(SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            // Your onCreate logic here
                        }
                    }).build();
                }
            }
        }
        return INSTANCE;
    }
}

