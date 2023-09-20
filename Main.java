package Main;

class Main
{
    public static void main(String[] args)
    {
        // inherit new technical lead class properties
        TechnicalLead CTO = new TechnicalLead("Satya Nadella");

        // inherit new sofrware enginner class properties
        SoftwareEngineer seA = new SoftwareEngineer("Kasey");
        SoftwareEngineer seB = new SoftwareEngineer("Breana");
        SoftwareEngineer seC = new SoftwareEngineer("Eric");

        // calling method by adding report in technical lead class
        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);

        // calling method "checkincode" in software enginner class
        seA.checkInCode();
        seC.checkInCode();

        // print out the team status from technical lead class method
        System.out.println(CTO.getTeamStatus());

        // inherit new technical lead class properties
        TechnicalLead VPofENG = new TechnicalLead("Bill Gates");
        
        // inherit new sofrware enginner class properties
        SoftwareEngineer seD = new SoftwareEngineer("Winter");
        SoftwareEngineer seE = new SoftwareEngineer("Libby");
        SoftwareEngineer seF = new SoftwareEngineer("Gizan");
        SoftwareEngineer seG = new SoftwareEngineer("Zaynah");

        // calling method by adding report in technical lead class
        VPofENG.addReport(seD);
        VPofENG.addReport(seE);
        VPofENG.addReport(seF);
        VPofENG.addReport(seG);

        // calling method "checkincode" in software enginner class
        seD.checkInCode();
        seF.checkInCode();
        seF.checkInCode();
        seF.checkInCode();
        seF.checkInCode();

        // print out the team status from technical lead class method
        System.out.println(VPofENG.getTeamStatus());

        // inherit new Business Lead class properties
        BusinessLead CFO = new BusinessLead("Amy Hood");

        // inherit new accountact class properties
        Accountant actA = new Accountant("Niky");
        Accountant actB = new Accountant("Andrew");

        // calling method by adding report in business lead class
        CFO.addReport(actA, CTO);
        CFO.addReport(actB, VPofENG);

        // print out the business lead team status
        System.out.println(CFO.getTeamStatus());

        System.out.println(seB.toString() + "'s manager is " + seB.getManager().toString());
        System.out.println(seF.toString() + "'s manager is " + seF.getManager().toString());
        System.out.println(actB.toString() + "'s manager is " + actB.getManager().toString());
        System.out.println();

        System.out.println("Testing BusinessLead approvedBonus()");
        System.out.print(seA.getManager() + " is asking for $10,000 bonus for " + seA.getName() + ", (the Approval result should be TRUE): ");
        System.out.println(CTO.requestBonus(seA, 10000));
        System.out.println("Updated budget is: " + seA.getManager().getAccountantSupport().getBonusBudget() + "\n");

        System.out.print(seF.getManager() + " is asking for $5,000 bonus for " + seF.getName() + ", (the Approval result should be TRUE): ");
        System.out.println(VPofENG.requestBonus(seF, 5000));
        System.out.println("Updated budget is: " + seF.getManager().getAccountantSupport().getBonusBudget() + "\n");

        System.out.print(seF.getManager() + " is asking for $400,000 bonus  for " + seF.getName() + ", (the Approval result should be FALSE): ");
        System.out.println(VPofENG.requestBonus(seF, 400000));
        System.out.println("Updated budget is: " + seF.getManager().getAccountantSupport().getBonusBudget() + "\n");
        System.out.println();

    }
}