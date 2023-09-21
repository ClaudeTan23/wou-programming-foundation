package CompanyStructure;

import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee
{
    public ArrayList<Accountant> team;

    // Set Business Lead name, set head count as 10 and set base salary twice than accountant to 0 from Business Lead class in Inheritance
    public BusinessLead(String name) 
    {
        super(name);

        this.employeeBaseSalary = getBaseSalary() * 2;
        this.headCount = 10;
        this.team = new ArrayList<Accountant>();
    }

    // return true if the number of direct reports this manager has is less than their headcount
    public boolean hasHeadCount()
    {
        if (this.team.size() < this.headCount)
        {
            return true;

        } else 
        {
            return false;
        }
    }

    // set reference to an Accountant object, and if the BusinessLead has head count left should add this employee to their list of direct reports
    // after added to the BusinessLead's direct reports true should be returned else return false
    // everytime a report is added the BusinessLead's bonus budget will be increased by 1.1 times.
    public boolean addReport(Accountant ac, TechnicalLead supportTeam)
    {
        if (hasHeadCount()) 
        {
            team.add(ac);

            ac.setManager(this);

            this.bonusBudget += ac.employeeBaseSalary * 1.1;
            ac.supportTeam(supportTeam);
            supportTeam.accountantSupport = ac;

            return true;

        } else 
        {
            return false;
        }
    }

    // return true the BusinessLeader's budget have be deducted else false
    public boolean requestBonus(Employee e, double bonus)
    {
        if (bonus <= getBonusBudget()) 
        {
            this.bonusBudget -= bonus;
            e.bonusBudget += bonus;

            return true;

        } else 
        {
            return false;
        }
    }

    // return true if bonus have rewareded else false
    public boolean approveBonus(Employee e, double bonus)
    {
        for (int i = 0; i < team.size(); i++) 
        {
            if ((team.get(i).getTeamSupported()).equals(e.manager) && team.get(i).canApproveBonus(bonus)) 
            {
                e.bonus += bonus;
                team.get(i).bonusBudget -= bonus;

                return true;
            }
        }

        return false;

    }

    // return a string of employee name, salary and bonus budget
    public String getTeamStatus() 
    {
        String bonusFormat = String.format("%.2f", this.bonusBudget);

        return this.toString() + " with a budget of " + bonusFormat;
    }
        
}
