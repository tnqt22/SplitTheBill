package net.androidbootcamp.splitthebill;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SplitPage extends Activity {
	double percentTip = 0.18;
	double totalBill;
	int numberOfPeople;
	double splitBill;
	String groupQuality;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splitpage);
		
		/** input/output and calculation for split bill */
        final EditText bill = (EditText)findViewById(R.id.txtBill);
        final EditText people = (EditText)findViewById(R.id.txtPeople);
        final Spinner group = (Spinner) findViewById(R.id.txtGroup);
        Button split = (Button) findViewById(R.id.btnSplit);
        split.setOnClickListener(new OnClickListener() {
		final TextView result = ((TextView)findViewById(R.id.txtResult));
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				totalBill = Double.parseDouble(bill.getText().toString());
				numberOfPeople = Integer.parseInt(people.getText().toString());
				splitBill = (totalBill + (totalBill * percentTip)) / numberOfPeople;
				DecimalFormat currency = new DecimalFormat("$###,###.##");
				groupQuality = group.getSelectedItem().toString();
				result.setText("Each person in your group pay (included tip) " + currency.format(splitBill)+ "\nQuality of Service: " + groupQuality);
			}
		});
	}
}
