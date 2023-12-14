/**
 * @author Prince Sanchez
 * @since December 5, 2023
 * Description: DemonBuilder part of project 2
 */
package com.example.demonbuilder.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.demonbuilder.User;

@Dao
public interface UserDAO {
    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user_table WHERE mUsername = :username AND mPassword = :password")
    User getUserByUsernameAndPassword(String username, String password);

    @Query("SELECT * FROM user_table WHERE mUsername = :username AND mPassword = :password")
    User getUserByCredentials(String username, String password);

    @Query("UPDATE user_table SET mPassword = :newPassword WHERE mUsername = :username")
    void updatePassword(String username, String newPassword);

    @Query("DELETE FROM user_table WHERE mUsername = :username")
    void deleteUserByUsername(String username);

}
