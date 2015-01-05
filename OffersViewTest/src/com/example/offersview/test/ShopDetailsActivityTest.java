package com.example.offersview.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.offersview.activities.OffersActivity;
import com.example.offersview.activities.ShopDetailsActivity;
import com.robotium.solo.Solo;

public class ShopDetailsActivityTest extends ActivityInstrumentationTestCase2<ShopDetailsActivity> {
	
	private Solo solo;

	@SuppressWarnings("deprecation")
	public ShopDetailsActivityTest(){
    	super("com.example.offersview.activities", ShopDetailsActivity.class);
    }
    
    
    @Override
    protected void setUp() throws Exception {
          super.setUp();
          
          this.solo = new Solo(getInstrumentation(), getActivity());
    }
    
    
    
    public void test_ClickOnShopsOffersButton () throws Exception {

    	
    	solo.waitForActivity("ShopDetailsActivity", 20000);
    	assertTrue(solo.searchText("Loading information. Please wait..."));
    	solo.clickOnButton("Display shop's offers");
    	solo.waitForActivity("OffersActivity", 20000);
    	solo.assertCurrentActivity("wrong activity", OffersActivity.class);
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
