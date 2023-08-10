package org.iitwforce.automation.uclidmmp;

import java.util.HashMap;

import org.iitwforce.lib.BaseClass;
import org.iitwforce.mmp.MMPLibrary;
import org.iitwforce.mmp.pages.HomePage;
import org.iitwforce.mmp.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests_DatePicker extends BaseClass {

	@Parameters({"doctorName"})
	@Test(description="Validate the schedule appointment for a doctor")
	public void TC_003_validate_book_appointment(String doctorName)
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchBrowser(prop.getProperty("patientURL"));	 
		mmpLib.login(prop.getProperty("patientUserName"),prop.getProperty("patientPassword"));
		mmpLib.navigateToAModule("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> expectedHMap = sPage.bookAppointment(doctorName);
		HomePage hPage = new HomePage(driver);
		HashMap<String,String> actualHMap =hPage.fetchPatientPortalDetails();
		Assert.assertEquals(actualHMap, expectedHMap);
		
	}
	 
	
}
