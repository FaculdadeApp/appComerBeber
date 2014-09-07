package br.com.comerbeberagora;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


public class Main extends FragmentActivity {

	 private AutoCompleteTextView actv;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Faz com que o Nome na ActionBar seja um Bot�o
        ActionBar action = getActionBar();
        action.setDisplayHomeAsUpEnabled(true);
        action.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg));
        
        //Criando um ARRAY e preenchendo com o array usado no XML para o autoComplete
        String[] locais = getResources().getStringArray(R.array.locais);
        ArrayAdapter adapter = 
                new ArrayAdapter(this, android.R.layout.simple_list_item_1, locais);
        actv =  (AutoCompleteTextView) findViewById(R.id.locais);
        actv.setAdapter(adapter);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.opcao2) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
