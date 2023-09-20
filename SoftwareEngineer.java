package Main;

public class SoftwareEngineer extends TechnicalEmployee
{
    public boolean CodeAccess;

    // Set Software Employee name, with base salary of 75000 from technical employee class in Inheritance
    // Set code access as true
    public SoftwareEngineer(String name) 
    {
        super(name);
        setCodeAccess(true);

    }

    // return boolean from code access 
    public boolean getCodeAccess()
    {
        return this.CodeAccess;
    }


    // set and get boolean of code access
    // allowing an external piece of code to update
    public boolean setCodeAccess(boolean codeAccess)
    {
        this.CodeAccess = codeAccess;
        
        return this.CodeAccess;
    }

    // return the current count of how many times this SoftwareEngineer has successfully checked in
    public int getSuccessfulCheckIns()
    {
        return this.checkIns;
    }

    // set the Software employee manager
    public void setManeger(TechnicalEmployee manager) 
    {
        super.manager = manager;
    }

    // check if this SoftwareEngineer's manager approves of their check in
    // If the check in is approved their successful checkin then the count it will increased and the method should return true
    // If the manager does not approve it will return false
    public boolean checkInCode()
    {
        TechnicalLead manager = (TechnicalLead) this.getManager();

        if (manager.approveCheckIn(this)) 
        {
            this.checkIns++;

            return true;

        } else 
        {
            CodeAccess = false;

            return false;
        }
    }

    
}
