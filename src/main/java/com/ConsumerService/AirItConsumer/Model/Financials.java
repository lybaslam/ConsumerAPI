package com.ConsumerService.AirItConsumer.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity(name="t_financials")
public class Financials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;

    @Column(name="employee_id")
    private int Employee_Id;

    @Column(name = "employee_salary")
    private String Employee_Salary;

    @Column(name="employee_name")
    private String Employee_Name;

    @Column(name="employee_designation")
    private String Employee_Designation;

    @Column(name="employee_stack")
    private String Employee_Stack;

    @Column(name="company_address")
    private String Company_Address;


    @Column(name="company_email")
    private String Company_Email;

    @Column(name="company_contact")
    private String Company_Contact;


    public Financials() {
    }

    public Financials(String employee_Salary) {
        Employee_Salary = employee_Salary;
    }

    public Financials(int employee_Id, String employee_Salary, String employee_Name, String employee_Designation, String employee_Stack, String company_Address, String company_Email, String company_Contact) {
        Employee_Id = employee_Id;
        Employee_Salary = employee_Salary;
        Employee_Name = employee_Name;
        Employee_Designation = employee_Designation;
        Employee_Stack = employee_Stack;
        Company_Address = company_Address;
        Company_Email = company_Email;
        Company_Contact = company_Contact;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getEmployee_Id() {
        return Employee_Id;
    }

    public void setEmployee_Id(int employee_Id) {
        Employee_Id = employee_Id;
    }

    public String getEmployee_Salary() {
        return Employee_Salary;
    }
    @JsonProperty("Employee_Salary")
    public void setEmployee_Salary(String employee_Salary) {
        Employee_Salary = employee_Salary;
    }

    public String getEmployee_Name() {
        return Employee_Name;
    }

    public void setEmployee_Name(String employee_Name) {
        Employee_Name = employee_Name;
    }

    public String getEmployee_Designation() {
        return Employee_Designation;
    }

    public void setEmployee_Designation(String employee_Designation) {
        Employee_Designation = employee_Designation;
    }

    public String getEmployee_Stack() {
        return Employee_Stack;
    }

    public void setEmployee_Stack(String employee_Stack) {
        Employee_Stack = employee_Stack;
    }

    public String getCompany_Address() {
        return Company_Address;
    }

    public void setCompany_Address(String company_Address) {
        Company_Address = company_Address;
    }

    public String getCompany_Email() {
        return Company_Email;
    }

    public void setCompany_Email(String company_Email) {
        Company_Email = company_Email;
    }

    public String getCompany_Contact() {
        return Company_Contact;
    }

    public void setCompany_Contact(String company_Contact) {
        Company_Contact = company_Contact;
    }

    @Override
    public String toString() {
        return "Financials{" +
                "Id=" + Id +
                ", Employee_Id=" + Employee_Id +
                ", Employee_Salary='" + Employee_Salary + '\'' +
                ", Employee_Name='" + Employee_Name + '\'' +
                ", Employee_Designation='" + Employee_Designation + '\'' +
                ", Employee_Stack='" + Employee_Stack + '\'' +
                ", Company_Address='" + Company_Address + '\'' +
                ", Company_Email='" + Company_Email + '\'' +
                ", Company_Contact='" + Company_Contact + '\'' +
                '}';
    }
}
