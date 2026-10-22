package rakan.kersh.finalyapplicationrakan.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import rakan.kersh.finalyapplicationrakan.model.AppDatabase;
import rakan.kersh.finalyapplicationrakan.model.MyUserTable.MyUser;
import rakan.kersh.finalyapplicationrakan.model.MyUserTable.MyUserQuery;

public class UserRepository {
    private MyUserQuery userQuery;
    private LiveData <List<MyUser>> allUser;
    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDB(application);
        userQuery = db.myUserQuery();
        allUser = userQuery.getAllUsers();
    }

    public LiveData<List<MyUser>> getAll() {
        return allUser; //userIds
    }
        public LiveData<List<MyUser>> getUsersByUserId(long userIds) {
            return userQuery.getUsersByUserId(userIds);
        }
        public LiveData<List<MyUser>> getUserByEmail(String myEmail){
            return userQuery.getUsersByEmail(myEmail);
        }
    public LiveData<List<MyUser>> getUserByPassw(String myPassw){
        return userQuery.getUsersByPassw(myPassw);
    }
    public LiveData<MyUser> getUserById(long userId) {
        return userQuery.getUserById(userId);
    }

    public void insertUser(MyUser myUser)
    {
        userQuery.insert(myUser);
    }
    public void deleteUser(MyUser myUser){
        userQuery.delete(myUser);
    }
    public void  checkEmailPassw(String myEmail, String myPassw){
        userQuery.checkEmailPassw(myEmail,myPassw);
    }
    }