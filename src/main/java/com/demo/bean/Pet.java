package com.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;

//@Component
@ConfigurationProperties( prefix = "cat")
public class Pet {
    public Pet(String name) {
        this.name = name;
    }

    public Pet() {
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
