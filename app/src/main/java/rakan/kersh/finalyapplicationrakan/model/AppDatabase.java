package rakan.kersh.finalyapplicationrakan.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import rakan.kersh.finalyapplicationrakan.model.MyTaskTable.MyTask;
import rakan.kersh.finalyapplicationrakan.model.MyTaskTable.MyTaskQuery;
import rakan.kersh.finalyapplicationrakan.model.MyUserTable.MyUser;
import rakan.kersh.finalyapplicationrakan.model.MyUserTable.MyUserQuery;
import rakan.kersh.finalyapplicationrakan.model.mySubjectTable.MySubject;
import rakan.kersh.finalyapplicationrakan.model.mySubjectTable.MySubjectQuery;

@Database(entities = {MyUser.class, MySubject.class, MyTask.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase db;

    public abstract MyUserQuery getMyUserQuery();

    public abstract MySubjectQuery getMySubjectQuery();

    public abstract MyTaskQuery getMyTaskQuery();

    public static synchronized AppDatabase getDB(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,
                            "samihDataBase")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }

    public MyTaskQuery myTaskQuery() {
        return getMyTaskQuery();
    }

    public MyUserQuery myUserQuery() {
        return getMyUserQuery();
    }

    public MySubjectQuery mySubjectQuery() {
        return getMySubjectQuery();
    }
}
