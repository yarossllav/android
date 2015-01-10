package coms.example.p0191_simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	Menu menu;
	EditText etNum1;
	EditText etNum2;
	Button btnAdd;
	Button btnSub;
	Button btnMult;
	Button btnDiv;
	TextView tvResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		etNum1 = (EditText) findViewById(R.id.etNum1);
		etNum2 = (EditText) findViewById(R.id.etNum2);
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnSub = (Button) findViewById(R.id.btnSub);
		btnMult = (Button) findViewById(R.id.btnMult);
		btnDiv = (Button) findViewById(R.id.btnDiv);
		tvResult = (TextView) findViewById(R.id.tvResult);
		
		btnAdd.setOnClickListener(this);
		btnAdd.setText("+");
		btnSub.setOnClickListener(this);
		btnSub.setText("-");
		btnMult.setOnClickListener(this);
		btnMult.setText("*");
		btnDiv.setOnClickListener(this);
		btnDiv.setText("/");
		//menu = new Menu();
		
	}
	
	@Override
	public void onClick(View v) {
		
		float number1 = Float.parseFloat(etNum1.getText().toString());
		float number2 = Float.parseFloat(etNum2.getText().toString());
		float result = 0;
		String znak = " ";
						
		switch (v.getId()){
		case R.id.btnAdd:
			znak = "+";
			result = number1 + number2;
			break;
		case R.id.btnSub:
			znak = "-";
			result = number1 - number2;
			break;
		case R.id.btnMult:
			znak = "*";
			result = number1 * number2;
			break;
		case R.id.btnDiv:
			znak = "/";
			result = number1 / number2;
			break;
		}
		tvResult.setText(String.valueOf(number1)+" "+znak+" "+String.valueOf(number2)+" = "+String.valueOf(result));
		
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
