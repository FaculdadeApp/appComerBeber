package br.com.comerbeberagora;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.annotation.SuppressLint;
import android.app.AlertDialog;

@SuppressLint("CutPasteId")
public class Main extends FragmentActivity {

	private AutoCompleteTextView actv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		String[] locais = getResources().getStringArray(R.array.locais);
		ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(this,
				android.R.layout.simple_list_item_1, locais);

		actv = (AutoCompleteTextView) findViewById(R.id.locais);
		actv.setAdapter(adapter);

		/******************************************************************/

		// Campos da Index
		// Mensagem de alerta
		final AlertDialog mensagem = new AlertDialog.Builder(this).create();
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
		/*****************************************************************/

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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
