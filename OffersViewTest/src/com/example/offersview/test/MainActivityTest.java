package com.example.offersview.test;

import android.test.ActivityInstrumentationTestCase2;


import com.example.offersview.MainActivity;
import com.example.offersview.activities.ShopListActivity;
import com.robotium.solo.Solo;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

private Solo solo;
	
	@SuppressWarnings("deprecation")
	public MainActivityTest(){
    	super("com.example.offersview", MainActivity.class);
    }
    
    
    @Override
    protected void setUp() throws Exception {
          super.setUp();
          
          this.solo = new Solo(getInstrumentation(), getActivity());

    }

public void test_ClickOnViewShopsButton () throws Exception {
    	
    	solo.waitForActivity("MainActivity", 20000);
    	solo.clickOnButton("Εμφάνιση λίστας καταστημάτων");
    	solo.waitForActivity("ShopListActivity", 10000);
    	solo.assertCurrentActivity("wrong activity", ShopListActivity.class);
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