package rakan.kersh.finalyapplicationrakan.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import rakan.kersh.finalyapplicationrakan.data.AppDatabase;
import rakan.kersh.finalyapplicationrakan.data.MyTaskTable.MyTask;
import rakan.kersh.finalyapplicationrakan.data.MyTaskTable.MyTaskQuery;

public class TaskRepository {
    private MyTaskQuery taskQuery;
    private LiveData<List<MyTask>> allTasks;

    public TaskRepository(Application application) {
        AppDatabase db = AppDatabase.getDB(application);
        taskQuery = db.myTaskQuery();
        allTasks = taskQuery.getAllTasks();
    }

    public LiveData<List<MyTask>> getAllTasks() {
        return allTasks;
    }

    public LiveData<MyTask> getTaskById(long taskId) {
        return taskQuery.getTaskById(taskId);
    }

    public LiveData<List<MyTask>> getTasksByTitle(String title) {
        return taskQuery.getTasksByTitle(title);
    }

    public LiveData<List<MyTask>> getTasksByPriority(int priority) {
        return taskQuery.getTasksByPriority(priortiy);
    }

    public LiveData<List<MyTask>> getTasksByUserIdAndTitle(
            long userId, String title) {
        return taskQuery.getTasksByUserIdAndTitle(userId, title);
    }

    public void insert(MyTask... tasks) {
        taskQuery.insert(tasks);
    }

    public void update(MyTask... tasks) {
        taskQuery.update(tasks);
    }

    public void updateTask(long taskId, String title, String description,
                           int priority) {
        taskQuery.updateTask(taskId, title, description, priority);
    }

    public void delete(Mytask... tasks) {
        taskQuery.delete(tasks);
    }

    public void deleteTaskById(long Id) {
        taskQuery.deleteTaskById(taskId);
    }
}


}
