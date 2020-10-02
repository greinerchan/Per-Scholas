package com.github.perscholas;

public class Employee extends AbstractEmployee{
    private long employeeId;
    private String employeeName;
    private String employeeAddress;
    private long employeePhone;
    private double basicSalary;
    private double specialAllowance = 250.8;
    private double Hra = 1000.5;

    public Employee(long employeeId, String employeeName, String employeeAddress, long employeePhone) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
    }

    public double calculateSalary(double basicSalary, double specialAllowance, double Hra) {
        return basicSalary + (basicSalary * specialAllowance / 100) + (basicSalary * Hra / 100);
    }
}
