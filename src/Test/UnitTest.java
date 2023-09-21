package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import CompanyStructure.*;

public class UnitTest 
{
    private Accountant ac;
	private SoftwareEngineer se;
    private SoftwareEngineer seCheck_1;
    private SoftwareEngineer seCheck_2;
	private TechnicalLead tl;
	private BusinessLead bl;

    // Inherit the object before start test each method/component
    @BeforeEach
	public void StartUp() throws Exception 
    {
        System.out.println("Start testing...");

		ac = new Accountant("alice");
		se = new SoftwareEngineer("john");
		tl = new TechnicalLead("henry");
		bl = new BusinessLead("willian");

        seCheck_1 = new SoftwareEngineer("ben");
        seCheck_2 = new SoftwareEngineer("david");
		
		tl.addReport(se);
		bl.addReport(ac, tl);
		ac.supportTeam(tl);
		
	}
    

    // Testing Software Engineer can check in code?
    // By set code access to false and add into tech lead and check the code access and check in through teah lead if return false
    @Test 
    public void SoftwareEngineer_CheckCode_1()
    {
        Boolean codeAccess;

        seCheck_1.setCodeAccess(false);
        tl.addReport(seCheck_1);

        codeAccess = tl.approveCheckIn(seCheck_1);

        assertFalse(codeAccess);

        System.out.println("Software enginner code access test 1 return " + codeAccess);
    }


    // Testing Software Engineer can check in code?
    // By set code access to true and add into tech lead and check the code access and check in through teah lead if return true
    @Test 
    public void SoftwareEngineer_CheckCode_2()
    {
        Boolean codeAccess;

        seCheck_2.setCodeAccess(true);
        tl.addReport(seCheck_2);

        codeAccess = tl.approveCheckIn(seCheck_2);

        assertTrue(codeAccess);

        System.out.println("Software enginner code access test 2 return " + codeAccess);
    }


    // Testing Accountant can approve bonus?
    // Request for $20000000 through the method to expect return false
	@Test
	public void AC_approve_bonus_test_1() 
    {
		Boolean approveBonus;

		approveBonus = ac.canApproveBonus(20000000);
		assertFalse(approveBonus);

        System.out.println("Accountant approve bonus test1 return " + approveBonus);
	}


	// Testing Accountant can approve bonus?
    // Request for $1000 through the method to expect return true
	@Test
	public void AC_approve_bonus_test_2() 
    {
		Boolean approveBonus;

		approveBonus = ac.canApproveBonus(1000);
		assertTrue(approveBonus);

        System.out.println("Accountant approve bonus test2 return " + approveBonus);
	}


	// Testing Software Engineer can get bonus?
    // Request for $20000000 through the method to expect return false
	@Test
	public void SE_get_bonus_test_1() 
    {
		Boolean getBonus;

		getBonus = tl.requestBonus(se, 20000000);
		assertFalse(getBonus);

        System.out.println("Software Engineer bonus test1 return " + getBonus);
    }
	

    // Testing Software Engineer can get bonus?
    // Request for $1000 through the method to expect return true
	@Test
	public void SE_get_bonus_test_2() 
    {
		Boolean getBonus;
        
		getBonus = tl.requestBonus(se, 1000);
		assertTrue(getBonus);
        
        System.out.println("Software Engineer bonus test2 return " + getBonus);
    }


    // Print out when finished testing each component
    @AfterEach
    public void Finished()
    {
        System.out.println("test finished...");
    }

}
