package com.yahoo.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public EditText etTotalAmount;
	public TextView tvTip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
		tvTip = (TextView) findViewById(R.id.tvTip);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void showInvalidMsgToast() {
		Toast.makeText(this, "Please enter valid amount", Toast.LENGTH_SHORT).show();
	}


	/**
	 * Convert to 2 decimal format
	 * @param d - input double number
	 * @return - return double number with 2 decimal format
	 */
	double roundTwoDecimals(double d) {
		DecimalFormat twoDecimalForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDecimalForm.format(d));
	}


	public void onClick(View v) {
		tvTip.setText(""); // clear off
		if(etTotalAmount.getText().toString().isEmpty()) {
			showInvalidMsgToast();
			return;
		}
		Double fieldValue = Double.parseDouble(etTotalAmount.getText().toString());

		String btnId = (String) v.getTag();
		Double tip = 0.0;
		if(btnId.equalsIgnoreCase("btn10Percent")) {
			//calculate 10% tip
			tip = roundTwoDecimals(fieldValue * 0.1);			
		} else if(btnId.equalsIgnoreCase("btn15Percent")) {
			//calculate 15% tip
			tip = roundTwoDecimals(fieldValue * 0.15);			
		} else if(btnId.equalsIgnoreCase("btn20Percent")) {
			//calculate 20% tip
			tip = roundTwoDecimals(fieldValue * 0.2);			
		}
		tvTip.setText("Tip is: $" + tip.toString());
	}
}
