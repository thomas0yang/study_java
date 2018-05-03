package com.thomas.products.fsm.schedule;

/**
 * Created by yangyang32 on 16/11/24.
 */
public class InstanceContext {
    private int taskId;
    private int taskInstanceId;

    public InstanceContext(int taskId, int taskInstanceId) {
        this.taskId = taskId;
        this.taskInstanceId = taskInstanceId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskInstanceId() {
        return taskInstanceId;
    }

    public void setTaskInstanceId(int taskInstanceId) {
        this.taskInstanceId = taskInstanceId;
    }

    @Override
    public String toString() {
        return "InstanceContext{" +
                "taskId=" + taskId +
                ", taskInstanceId=" + taskInstanceId +
                '}';
    }
}
