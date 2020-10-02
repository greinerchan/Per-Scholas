package com.github.perscholas;

public interface EmployeeInterface {
    Long getId();
    String getName();
    String getAddress();
    Long getPhoneNumber();
    Double getBasicSalary();
    Double getSpecialAllowance();
    Double getHealthReimbursementAccount();
    Long setId(Long id);
    String setName(String name);
    String setAddress(String address);
    Long setPhoneNumber(Long phoneNumber);
    Double setBasicSalary(Double basicSalary);
    Double setSpecialAllowance(Double specialAllowance);
    Double setHealthReimbursementAccount(Double healthReimbursementAccount);
    Double calculateSalary();
}
