package CompanyStructure;

public class Accountant extends BusinessEmployee
{
    public TechnicalLead teamSupported;

    // Set Accountant name and set bonus budget to 0 from Accountant class in Inheritance
    public Accountant(String name) 
    {
        super(name);
        this.bonusBudget = 0;
    }
    
    // return technical lead that this Accountant is currently supporting
    public TechnicalLead getTeamSupported()
    {
        return this.teamSupported;
    }

    // set a reference to a TechnicalLead.
    // Once this happens the Accountant's bonus budget should be updated to be the total of each SoftwareEngineer's base salary that reports to that TechnicalLead plus 10%
    public void supportTeam(TechnicalLead lead)
    {
        this.teamSupported = lead;

        for (int i = 0; i < lead.team.size(); i++) 
        {
            this.bonusBudget += lead.team.get(i).getBaseSalary() * 1.1;
        }
    }

    // return true if the bonus is more than the remaining budget else false
    public boolean canApproveBonus(double bonus) 
    {
        double requestedBonus = bonus;

        if (requestedBonus <= getBonusBudget()) 
        {
            return true;

        } else 
        {
            System.out.print(" Rejected because Budget not sufficient : ");

            return false;
        }

    }

    // return a string of the employee name, base salary, bonus budget and the team support
    public String employeeStatus()
    {
        return this.toString() + " with a budget of " + getBonusBudget() + " is supporting " + this.getTeamSupported();
    }
    
}
