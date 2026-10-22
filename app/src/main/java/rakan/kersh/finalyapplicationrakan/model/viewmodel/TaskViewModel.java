package rakan.kersh.finalyapplicationrakan.model.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import rakan.kersh.finalyapplicationrakan.model.MyTaskTable.MyTask;
import rakan.kersh.finalyapplicationrakan.repositories.TaskRepository;

public class TaskViewModel extends AndroidViewModel {
    private final TaskRepository repository;
    private final LiveData<List<MyTask>> allTasks;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        repository = new TaskRepository(application);
        allTasks = repository.getAllTasks();
    }

    public LiveData<List<MyTask>> getAllTasks() {
        return allTasks;
    }

    public LiveData<List<MyTask>> getTasksByUserId(long userId) {
        return repository.getTasksByUserId(userId);
    }

    public LiveData<List<MyTask>> getGetTasksByUserId (long userId){
        return getTasksByUserId(userId);
    }
    public LiveData<MyTask> getTaskById(long taskId) {
   return repository.getTaskById(taskId);
    }
    }

