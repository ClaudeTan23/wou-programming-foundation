package CompanyStructure;

import java.util.ArrayList;

public abstract class Employee 
{
    public String employeeName;
    public double employeeBaseSalary;
    public int employeeId;
    public Accountant accountantSupport;
    public Employee manager;
    // public String employeeStatus;
    public double bonusBudget;
    public int headCount = 0;
    public double bonus;

    // constant variable or a method that is the same for every instance of a class so it can count total of employee
    public static ArrayList<String> employee = new ArrayList<String>();
    
    // Set employee name, base salary and id in Inheritance
    public Employee(String name, double baseSalary)
    {
        employeeName = name;
        employeeBaseSalary = baseSalary;
        employee.add(name);

        employeeId = employee.size();
    }   

    // return total of employee
    public int total()
    {
        return employee.size();
    }
    
    // return employee base salary
    public double getBaseSalary()
    {
        return this.employeeBaseSalary;
    }

    // return employee name
    public String getName()
    {
        return this.employeeName;
    }

    // return employee id
    public int getEmployeeID()
    {
        return this.employeeId;
    }

    // return employee manager
    public Employee getManager()
    {
        return this.manager;
    }

    // return employee account supoort
    public Accountant getAccountantSupport() 
    {
        return this.accountantSupport;
    }

    // set and get the employee manager
    public Employee setManager(Employee manager)
    {
        this.manager = manager;

        return this.manager;
    }

    // return true if the parameter employee id is same as the current id else return false
    public boolean equals(Employee other)
    {
        return other.getEmployeeID() == this.employeeId;
    }

    // return a string of employee id and name
    public String toString()
    {
        return "Employee id:" + employeeId + " , Employee name: " + employeeName;
    }

    public abstract String employeeStatus();
}
