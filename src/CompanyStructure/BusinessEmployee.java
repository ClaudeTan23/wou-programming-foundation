package CompanyStructure;


public class BusinessEmployee extends Employee
{
    // Set Businsess Employee name, base salary in Inheritance
    public BusinessEmployee(String name) 
    {
        super(name, 50000);
    }

    // Set and get the Businsess employee bonus budget
    public double setBonusBudget(double bonusBudget)
    {
        this.bonusBudget = bonusBudget;
        return this.bonusBudget;
    }

    // return Businsess employee bonus budget
    // budget is determined will depend on which type of Business Employee it is
    public double getBonusBudget()
    {
        return this.bonusBudget;
    }

    // return Businsess employee status with Businsess employee name, id and bonus budget
    public String employeeStatus()
    {
        String budgetFormat = String.format("%.2f", this.bonusBudget);

        return super.toString() + " with a budget of " + budgetFormat;
    }
    
}
