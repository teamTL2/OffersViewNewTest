package com.example.offersview.test;



import android.test.ActivityInstrumentationTestCase2;
import com.example.offersview.activities.ShopDetailsActivity;
import com.example.offersview.activities.ShopListActivity;
import com.robotium.solo.Solo;

public class ShopListActivityTest extends ActivityInstrumentationTestCase2<ShopListActivity> {

private Solo solo;
	
	@SuppressWarnings("deprecation")
	public ShopListActivityTest(){
    	super("com.example.offersview.activities", ShopListActivity.class);
    }
    
    
    @Override
    protected void setUp() throws Exception {
          super.setUp();
          
          this.solo = new Solo(getInstrumentation(), getActivity());
    }

    
    public void test_ClickOnShopList () throws Exception {

    	
    	solo.waitForActivity("ShopListActivity", 20000);
    	assertTrue(solo.searchText("Loading shops. Please wait..."));
    	solo.clickInList(1);
    	if(solo.waitForText("There are no shops")){
	    	solo.goBack();
		}else{
			assertTrue(solo.searchText("Loading information. Please wait..."));
    		solo.waitForActivity("ShopDetailsActivity", 20000);
    		solo.assertCurrentActivity("wrong activity", ShopDetailsActivity.class);
    	    solo.goBack();
    	}    	
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
