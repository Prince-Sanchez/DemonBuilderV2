/**
 * @author Prince Sanchez
 * @since December 5, 2023
 * Description: DemonBuilder part of project 2
 */
package com.example.demonbuilder;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int mID;

    private String mUsername;
    private String mPassword;
    private boolean mIsAdmin;



    public User(String username, String password) {
        this.mUsername = username;
        this.mPassword = password;
    }

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public boolean isAdmin() {
        return mIsAdmin;
    }

    public void setIsAdmin(boolean mIsAdmin) {
        this.mIsAdmin = mIsAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + mID +
                ", mUsername='" + mUsername + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", mIsAdmin=" + mIsAdmin +
                '}';
    }
}

