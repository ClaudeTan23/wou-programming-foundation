package Main;

import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee
{
    public ArrayList<SoftwareEngineer> team;

    // Set Technical Lead name, with base salary of 1.3 times than technical employee in Inheritance
    // Technical Lead default head count is 4
    public TechnicalLead(String name) 
    {
        super(name);
        this.employeeBaseSalary *= 1.3;
        this.headCount = 4;
        this.team = new ArrayList<SoftwareEngineer>();
    }

    // return true if the number of direct reports this manager has is less than their head count
    public boolean hasHeadCount()
    {
        if (team.size() < headCount)
        {
            return true;

        } else 
        {
            return false;
        }
    }

    // add reference to a SoftwareEngineer object
    public boolean addReport(SoftwareEngineer se)
    {
        if (hasHeadCount()) 
        {
            team.add(se); 
                       
            se.setManeger(this);

            return true;
                       
        } else {

            return false; 
        }
    }

    // return if the employee passed in the report to this manager and if their code access is currently set to true else false
    public boolean approveCheckIn(SoftwareEngineer se)
    {
        if(se.getManager().equals(this) && se.getCodeAccess())
        {
            return true;

        } else 
        {
            return false;
        }
    }

    // approval bonus from business lead
    // return true if employee get the bonus else false
    public boolean requestBonus(Employee e, double bonus)
    {
        BusinessLead businessLead = (BusinessLead) getAccountantSupport().getManager();

        if (businessLead.approveBonus(e, bonus)) 
        {
            return true;

        } else 
        {
            return false;
        }
    }

    // return a String that gives insight into this Manager and all their direct reports
    public String getTeamStatus()
    {
        if (team.size() == 0) 
        {
            return this.employeeStatus() + " and no direct reports yet";

        } else 
        {
            String teamStatus = "";

            for (int i = 0; i < team.size(); i++) 
            {
                teamStatus += ("    " + team.get(i).employeeStatus() + "\n");
            }
            
            return this.employeeStatus() + " and is managing: \n" + teamStatus;
        }
    }
    
}
