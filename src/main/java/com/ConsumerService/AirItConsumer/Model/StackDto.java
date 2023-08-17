package com.ConsumerService.AirItConsumer.Model;

public class StackDto {

    private String Name;
    private String Tool;

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getTool() {
        return Tool;
    }
    public void setTool(String tool) {
        Tool = tool;
    }

    @Override
    public String toString() {
        return "StackDto{" +
                "Name='" + Name + '\'' +
                ", Tool='" + Tool + '\'' +
                '}';
    }
}
