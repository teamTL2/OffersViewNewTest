package com.example.offersview.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.offersview.activities.LoginActivity;
import com.example.offersview.activities.RegisterActivity;
import com.robotium.solo.Solo;

public class RegisterActivityTest extends ActivityInstrumentationTestCase2<RegisterActivity> {

	private Solo solo;
	
	@SuppressWarnings("deprecation")
	public RegisterActivityTest(){
    	super("com.example.offersview.activities", RegisterActivity.class);
    }
    
    
    @Override
    protected void setUp() throws Exception {
          super.setUp();
          
          this.solo = new Solo(getInstrumentation(), getActivity());

    }

    
    public void test_FieldsAreEmpty() throws Exception {
    	
    	solo.waitForActivity("RegisterActivity", 20000);
    	solo.assertCurrentActivity("wrong activity", RegisterActivity.class);
    	solo.clickOnButton("Register");
    	assertTrue(solo.waitForText("Please make sure you fill in all required fields"));
    
    }
    
    public void test_NotEqualsPass() throws Exception {
      	
	  	solo.waitForActivity("RegisterActivity", 20000);
	  	solo.assertCurrentActivity("wrong activity", RegisterActivity.class);
	  	String strName = "alekos";
	  	String strPass = "123";
	  	String strRePass = "12345";
	  	solo.clickOnEditText(0);
	    solo.enterText(0,strName); //username
	    solo.clickOnEditText(1);
	    solo.enterText(1,strPass); //password
	    solo.clickOnEditText(2);
	    solo.enterText(2,strRePass); //repassword
	    solo.clickOnButton("Register");
	    assertTrue(solo.waitForText("Please make sure that your passwords match"));	    
    }   
    
    public void test_SymbolsInUsername() throws Exception {
      	
	  	solo.waitForActivity("RegisterActivity", 20000);
	  	solo.assertCurrentActivity("wrong activity", RegisterActivity.class);
	  	String strName = "@lekos";
	  	String strPass = "123";
	  	String strRePass = "123";
	  	solo.clickOnEditText(0);
	    solo.enterText(0,strName); //username
	    solo.clickOnEditText(1);
	    solo.enterText(1,strPass); //password
	    solo.clickOnEditText(2);
	    solo.enterText(2,strRePass); //repassword
	    solo.clickOnButton("Register");
	    assertTrue(solo.waitForText("Please make sure that you are not using any symbols in your username"));	    
    }  
    
    public void test_RegistrationFailed() throws Exception {
      	
	  	solo.waitForActivity("RegisterActivity", 20000);
	  	solo.assertCurrentActivity("wrong activity", RegisterActivity.class);
	  	String strName = "ko";
	  	String strPass = "ko";
	  	String strRePass = "ko";
	  	solo.clickOnEditText(0);
	    solo.enterText(0,strName); //username
	    solo.clickOnEditText(1);
	    solo.enterText(1,strPass); //password
	    solo.clickOnEditText(2);
	    solo.enterText(2,strRePass); //repassword
	    solo.clickOnButton("Register");
	    assertTrue(solo.waitForText("Registration failed"));	    
    } 
    
    /*public void test_RegistrationCompleted() throws Exception {
      	
	  	solo.waitForActivity("RegisterActivity", 20000);
	  	solo.assertCurrentActivity("wrong activity", RegisterActivity.class);
	  	String strName = "alekos";
	  	String strPass = "123";
	  	String strRePass = "123";
	  	solo.clickOnEditText(0);
	    solo.enterText(0,strName); //username
	    solo.clickOnEditText(1);
	    solo.enterText(1,strPass); //password
	    solo.clickOnEditText(2);
	    solo.enterText(2,strRePass); //repassword
	    solo.clickOnButton("Register");
	    assertTrue(solo.waitForText("Registration completed"));	 
	    solo.waitForActivity("LoginActivity", 20000);
    	solo.assertCurrentActivity("wrong activity", LoginActivity.class);
    	solo.goBack();
    } */
    
    public void test_ClickOnReturnButton () throws Exception {
    	
    	solo.waitForActivity("RegisterActivity", 20000);
    	solo.clickOnButton("Back");
    	solo.waitForActivity("LoginActivity", 10000);
    	solo.assertCurrentActivity("wrong activity", LoginActivity.class);
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