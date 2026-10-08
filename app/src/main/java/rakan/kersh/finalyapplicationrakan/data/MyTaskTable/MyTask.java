package rakan.kersh.finalyapplicationrakan.data.MyTaskTable;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyTask {
    @PrimaryKey(autoGenerate = true)
    private long taskId;
    private String title;
    private String description;
    private int priority;
    public long keyId;
    public int importance;
    public String shortTitle;
    public String Text;
    public long time;
    public boolean isCompleted;
    public long subjId;
    public long userId;
}


