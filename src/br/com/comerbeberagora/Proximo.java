package br.com.comerbeberagora;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Proximo extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.telacomentarios, null, false);
		Bundle args = getArguments();
		TextView tv = (TextView) rootView.findViewById(R.id.titulo);
		tv.setText("fragment 2");

		return rootView;
	}
}
