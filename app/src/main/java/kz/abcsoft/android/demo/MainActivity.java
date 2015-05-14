package kz.abcsoft.android.demo;


import android.app.Activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;


public class MainActivity extends ActionBarActivity implements ActionBar.OnNavigationListener
//implements ActionBar.TabListener
{

    final String LOG_TAG = "myLogs";

    String[] data = new String[] { "one", "two", "three" };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

//        ActionBar bar = getSupportActionBar() ;
//        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//        ActionBar.Tab tab1 = bar.newTab() ;
//        tab1.setText("Tab 1") ;
//        tab1.setTabListener(this) ;
//        bar.addTab(tab1);
//
//        ActionBar.Tab tab2 = bar.newTab() ;
//        tab2.setText("Tab 2") ;
//        tab2.setTabListener(this) ;
//        bar.addTab(tab2);

        ActionBar bar = getSupportActionBar() ;
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                data) ;
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bar.setListNavigationCallbacks(adapter, this);

    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        Log.d(LOG_TAG, "selected: position = " + itemPosition + ", id = "
                + itemId + ", " + data[itemPosition]);
        return false;
    }

//    @Override
//    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//        Log.d(LOG_TAG, "selected tab: " + tab.getText());
//    }
//
//    @Override
//    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//        Log.d(LOG_TAG, "unselected tab: " + tab.getText());
//    }
//
//    @Override
//    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//        Log.d(LOG_TAG, "reselected tab: " + tab.getText());
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
