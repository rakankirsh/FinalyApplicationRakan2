package rakan.kersh.finalyapplicationrakan.model.MyTaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyTask {
    @PrimaryKey(autoGenerate = true)
    public long taskId;
    public String title;
    public String description;
    public int priority;
    public long keyId;
    public int importance;
    public String shortTitle;
    public String Text;
    public long time;
    public boolean isCompleted;
    public long subjId;
    public long userId;
}
