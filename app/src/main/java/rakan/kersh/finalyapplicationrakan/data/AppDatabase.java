package rakan.kersh.finalyapplicationrakan.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import rakan.kersh.finalyapplicationrakan.data.MyTaskTable.MyTask;
import rakan.kersh.finalyapplicationrakan.data.MyUserTable.MyUser;
import rakan.kersh.finalyapplicationrakan.data.MyUserTable.MyUserQuery;
import rakan.kersh.finalyapplicationrakan.data.mySubjectTable.MySubject;
import rakan.kersh.finalyapplicationrakan.data.mySubjectTable.MySubjectQuery;

@Database(entities = {MyUser.class, MySubject.class, MyTask.class}, version =1)
    public abstract class AppDatabase extends RoomDatabase{
private static AppDatabase db;
public abstract MyUserQuery getMyUserQuery();
public abstract MySubjectQuery getMySubjectQuery();
public static AppDatabase getDB(Context context) {
    if (db == null)
    {
        db = Room.databaseBuilder(context,
                        AppDatabase.class,
                        "samihDataBase")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
}
    return db;
    }
}
