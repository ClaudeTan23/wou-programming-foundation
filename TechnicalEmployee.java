package Main;

public class TechnicalEmployee extends Employee
{
    public int checkIns;

    // Set Technical Employee name, base salary in Inheritance
    public TechnicalEmployee(String name) 
    {
        super(name, 75000);
        this.checkIns = 0;
    }

    // return Technical employee status with Technical employee name, id and check ins
    public String employeeStatus()
    {
        return super.toString() + " has " + checkIns + " successful check ins";
    }

    // check ins increment setter
    public void setCheckin() 
    {
        checkIns++;
    }   
}
