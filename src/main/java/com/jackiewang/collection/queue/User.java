package com.jackiewang.collection.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class User implements Delayed {
    private int id;
    private String name;
    private long endTime;

    public User(int id, String name, long endTime) {
        this.id = id;
        this.name = name;
        this.endTime = endTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {

        return this.getEndTime() - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        User other = (User) o;
        return Long.compare(this.getEndTime(), other.getEndTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", endTime=" + endTime +
                '}';
    }
}