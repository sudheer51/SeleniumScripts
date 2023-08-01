package org.iitwforce.automation.uclidmmp;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests_DatePicker extends BaseClass {

	@Test(description="Validate the schedule appointment for a doctor")
	public void TC_003_validate_book_appointment()
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");	 
		mmpLib.login();
		mmpLib.navigateToAModule("Schedule Appointment");
		HashMap<String,String> expectedHMap = mmpLib.bookAppointment();
		HashMap<String,String> actualHMap =mmpLib.fetchPatientPortalDetails();
		Assert.assertEquals(actualHMap, expectedHMap);
	}
	 
	
}
