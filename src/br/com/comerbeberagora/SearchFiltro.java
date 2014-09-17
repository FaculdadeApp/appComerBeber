package br.com.comerbeberagora;

import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.util.Log;

class SearchFiltro implements OnQueryTextListener{

	@Override
	public boolean onQueryTextChange(String arg0) {
		// TODO Auto-generated method stub
		Log.i("Script", "onQueryTextChange -> "+arg0);
		
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String arg0) {
		// TODO Auto-generated method stub
		Log.i("Script", "onQueryTextSubmit -> "+arg0);
		
		return false;
	}
	
}
