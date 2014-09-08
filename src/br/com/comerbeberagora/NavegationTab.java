package br.com.comerbeberagora;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBar.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

public class NavegationTab implements ActionBar.TabListener {

	private Fragment frag;
	public NavegationTab(Fragment frag){
		this.frag = frag;
	}

	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		if ("Categoria".equals(tab.getText().toString())) {
           // pager.setCurrentItem(0);        
            //Toast.makeText(getApplication(), "ok", Toast.LENGTH_SHORT).show();

        }
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

}
