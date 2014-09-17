package br.com.comerbeberagora;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

public class Main extends ActionBarActivity {

	// private AutoCompleteTextView actv;
	private Spinner combo;
	private SearchView mSearchView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Faz com que o Nome na ActionBar seja um Botão
		ActionBar action = getSupportActionBar();
		action.setDisplayHomeAsUpEnabled(true);
		action.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		action.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg));

		class Listener implements ActionBar.TabListener {
			private Fragment fm;

			public Listener(Fragment fm) {
				this.fm = fm;
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				FragmentTransaction fts = getSupportFragmentManager()
						.beginTransaction();
				fts.replace(R.id.fragmentTab, fm);
				fts.commit();

			}

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				FragmentTransaction fts = getSupportFragmentManager()
						.beginTransaction();
				fts.remove(fm);
				fts.commit();

			}
		}
		;

		Tab tabCateg = action.newTab();
		tabCateg.setText("Categoria");
		tabCateg.setTabListener(new Listener(new Categ()));
		action.addTab(tabCateg, false);

		Tab tabProximo = action.newTab();
		tabProximo.setText("Proximos");
		tabProximo.setTabListener(new Listener(new Proximo()));
		action.addTab(tabProximo, false);

		if (savedInstanceState != null) {
			int indiceTab = savedInstanceState.getInt("indiceTab");
			getSupportActionBar().setSelectedNavigationItem(indiceTab);
		} else {
			getSupportActionBar().setSelectedNavigationItem(0);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);

		mSearchView = (SearchView) MenuItemCompat.getActionView(menu
				.findItem(R.id.opcao1));
		mSearchView.setOnQueryTextListener(new SearchFiltro());
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.opcao1:
			mSearchView.setIconified(false);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onSaveInstaceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("indiceTab", getSupportActionBar()
				.getSelectedNavigationIndex());
	}

}
