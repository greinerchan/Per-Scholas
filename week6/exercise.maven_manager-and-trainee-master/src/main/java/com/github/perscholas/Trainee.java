package com.github.perscholas;

/**
 * Created by leon on 6/10/2020.
 */
public class Trainee extends Employee {
    private double basicSalary;
    public Trainee(long employeeId, String employeeName, String employeeAddress, long employeePhone, double basicSalary) {
        super(employeeId, employeeName, employeeAddress, employeePhone);
        this.basicSalary = basicSalary;
    }
}
