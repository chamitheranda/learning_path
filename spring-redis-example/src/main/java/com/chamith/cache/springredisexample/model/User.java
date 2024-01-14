package com.chamith.cache.springredisexample.model;

import java.io.Serializable;

public class User implements Serializable {
    private String id ;
    private String name ;
    private long salary ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public User(String id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
