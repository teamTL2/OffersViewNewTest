package com.example.offersview.test;

import com.example.offersview.MainActivity;
import com.example.offersview.activities.LoginActivity;
import com.example.offersview.activities.RegisterActivity;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {
	
	private Solo solo;
	
	

	
    @SuppressWarnings("deprecation")
	public LoginActivityTest(){
    	super("com.example.offersview.activities", LoginActivity.class);
    }
    
    
    @Override
    protected void setUp() throws Exception {
          super.setUp();
          
          this.solo = new Solo(getInstrumentation(), getActivity());

    }

    
    public void test_FieldsAreEmpty() throws Exception {
    	
    	solo.waitForActivity("LoginActivity", 20000);
    	solo.assertCurrentActivity("wrong activity", LoginActivity.class);
    	solo.clickOnButton("Login");
    	assertTrue(solo.waitForText("Please make sure to fill all the fields"));
    
    }
    
    
    public void test_ClickOnRegisterButton () throws Exception {
    	
    	solo.clickOnButton("Register");
    	solo.waitForActivity("RegisterActivity", 20000);
    	solo.assertCurrentActivity("wrong activity", RegisterActivity.class);
    	solo.goBack();
    }
    
    
   /* public void TestWrongUserInfo() throws Exception {
    	
    	solo.waitForActivity("LoginActivity", 20000);
    	solo.assertCurrentActivity("wrong activity", LoginActivity.class);
    	String strName = "dsgdsgdsgdsg";
    	String strPass = "dgdsgdsgds";
    	solo.clickOnEditText(0);
        solo.enterText(0,strName); //username
        solo.clickOnEditText(1);
        solo.enterText(1,strPass); //password
        solo.clickOnButton("Login");
        assertTrue(solo.searchText("Checking your information... Please wait..."));
        assertTrue(solo.waitForText("Invalid username or password")); 
    } */
  
  
     public void test_CorrectUserInfo() throws Exception {
  	
	  	solo.waitForActivity("LoginActivity", 20000);
	  	solo.assertCurrentActivity("wrong activity", LoginActivity.class);
	  	String strName = "ko";
	  	String strPass = "ko";
	  	solo.clickOnEditText(0);
	    solo.enterText(0,strName); //username
	    solo.clickOnEditText(1);
	    solo.enterText(1,strPass); //password
	    solo.clickOnButton("Login");
	    assertTrue(solo.searchText("Checking your information... Please wait..."));
	    assertTrue(solo.waitForText("Welcome"));
	    solo.waitForActivity("MainActivity", 20000);
    	solo.assertCurrentActivity("wrong activity", MainActivity.class);
    	solo.goBack();
    } 
    
    
    
    @Override
    protected void tearDown() throws Exception{
          try {
                this.solo.finalize();
                } catch (Throwable e) {
                e.printStackTrace();
                }
                getActivity().finish();
                super.tearDown();
                }
    
    
}
