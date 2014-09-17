package br.com.comerbeberagora;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.widget.SearchView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner; 

import android.app.AlertDialog;


public class Main extends ActionBarActivity {

	//private AutoCompleteTextView actv;
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
        	public Listener(Fragment fm){
        		this.fm = fm;
        	}
        	
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
				fts.replace(R.id.fragmentTab, fm);
				fts.commit();
				
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
				fts.remove(fm);
				fts.commit();
				
			}
		};
		
	    Tab tabCateg = action.newTab();
        tabCateg.setText("Categoria");
        tabCateg.setTabListener(new Listener(new Categ()));
        action.addTab(tabCateg, false);
        
        Tab tabProximo = action.newTab();
        tabProximo.setText("Proximos");
        tabProximo.setTabListener(new Listener(new Proximo()));
        action.addTab(tabProximo, false);
        
        if(savedInstanceState != null){
        	int indiceTab = savedInstanceState.getInt("indiceTab");
        	getSupportActionBar().setSelectedNavigationItem(indiceTab);
        } else{
        	getSupportActionBar().setSelectedNavigationItem(0);
        }
		
		
		/*actv = (AutoCompleteTextView) findViewById(R.id.locais);
		actv.setAdapter(adapter);

		/************************************** BOTAO INDEX ******************************************
		
		// Campos da Index
		// Mensagem de alerta
		final AlertDialog mensagem = new AlertDialog.Builder(this).create();
		// Espaço para digitar o que irá procurar
		final AutoCompleteTextView textPesquisa = (AutoCompleteTextView) findViewById(R.id.locais);

		// Botão Pesquisar
		Button botaoPesquisar = (Button) findViewById(R.id.pesquisar);
		// Botão Cancelar
		Button button = (Button) findViewById(R.id.cancelarPesquisa);

		button.setOnClickListener(new Button.OnClickListener() {

			// Botão Cancelar
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// String texto = textPesquisa.getText().toString();
				textPesquisa.setText("");
				textPesquisa.requestFocus();
			}
		});

		// Botão Pesquisar

		botaoPesquisar.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (textPesquisa.length() == 0) {
					mensagem.setTitle("Necessário digitar algo");
					mensagem.setIcon(R.drawable.ic_launcher);
					mensagem.show();
					textPesquisa.requestFocus();

				}
			}
		});
		/************************ FIM DO BOTAO INDEX *****************************************/

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		mSearchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.opcao1));
        mSearchView.setOnQueryTextListener(new SearchFiltro());
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId()){
		case R.id.opcao1:
			mSearchView.setIconified(false);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	 public void onSaveInstaceState(Bundle outState){
	    	super.onSaveInstanceState(outState);
	    	outState.putInt("indiceTab", getSupportActionBar().getSelectedNavigationIndex());    	
	    }

}
