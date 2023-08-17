package com.ConsumerService.AirItConsumer.Model;

import java.util.List;

public class EmployeeDto
{


    private String Name;
    private String Designation;
    private List<StackDto> stacks;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public List<StackDto> getStacks() {
        return stacks;
    }

    public void setStacks(List<StackDto> stacks) {
        this.stacks = stacks;
    }



    @Override
    public String toString() {
        return "EmployeeDto{" +
                "Name='" + Name + '\'' +
                ", Designation='" + Designation + '\'' +
                ", stacks=" + stacks +
                '}';
    }
}
