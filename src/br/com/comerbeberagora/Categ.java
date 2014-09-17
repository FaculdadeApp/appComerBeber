package br.com.comerbeberagora;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Categ extends Fragment {
	
	private Spinner combo;
	
	 @Override
	    public View onCreateView(LayoutInflater inflater,
	            ViewGroup container, Bundle savedInstanceState) {
	        // The last two arguments ensure LayoutParams are inflated
	        // properly.
	        View rootView = inflater.inflate(R.layout.categ_frag,null, false);
	        Bundle args = getArguments();
	        TextView tv = (TextView) rootView.findViewById(R.id.titulo);
	        

	        String[] locais = getResources().getStringArray(R.array.locais);
			ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, locais);

	        
	        combo = (Spinner) rootView.findViewById(R.id.combo);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
	        combo.setAdapter(adapter);
	        
	        return rootView;
	    }
	}
