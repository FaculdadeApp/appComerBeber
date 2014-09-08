package br.com.comerbeberagora;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class TelaSplash extends Activity implements Runnable {

	private final int DELAY = 300;

	// 3 Segundos
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.splash);
		Toast.makeText(this, "Aguarde o carregamento da apliacção...",
				Toast.LENGTH_SHORT).show();
		Handler h = new Handler();
		h.postDelayed(this, DELAY);
	}

	@Override
	public void run() {
		startActivity(new Intent(this, Main.class));
		finish();
	}
}
