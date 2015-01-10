package coms.example.p0191_simplecalculator;

import java.math.BigDecimal;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Menu menu;
	EditText etNum1;
	EditText etNum2;
	Button btnAdd;
	Button btnSub;
	Button btnMult;
	Button btnDiv;
	TextView tvResult;
	
	final int MENU_RESET_ID = 1;
	final int MENU_QUI_ID = 2;
	
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
		
		if (TextUtils.isEmpty(etNum1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString())) {
			Toast.makeText(this, "Error: add the number!", Toast.LENGTH_LONG);
			return;
		}
		BigDecimal number1 = new BigDecimal(etNum1.getText().toString());
		BigDecimal number2 = new BigDecimal(etNum2.getText().toString());
		BigDecimal result = new BigDecimal (0);
		String znak = "";
		
		switch (v.getId()){
		case R.id.btnAdd:
			znak = "+";
			result = number1.add(number2);
			break;
		case R.id.btnSub:
			znak = "-";
			result = number1.subtract(number2);
			break;
		case R.id.btnMult:
			znak = "*";
			result = number1.multiply(number2);
			break;
		case R.id.btnDiv:
			if (Float.parseFloat(etNum2.getText().toString())==0){
				Toast.makeText(this, "Error: div for 0", Toast.LENGTH_SHORT).show();
				return;
			}
			znak = "/";
			result = number1.divide(number2);
			break;
		}
		tvResult.setText(number1.toString()+" "+znak+" "+number2.toString()+" = "+result.toString());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
				
		menu.add(0, MENU_RESET_ID, 1, "Reset");
		menu.add(0, MENU_QUI_ID, 2, "Quit");
		
		return super.onCreateOptionsMenu(menu);
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()){
		case MENU_RESET_ID:
			etNum1.setText("");
			etNum2.setText("");
			tvResult.setText("");
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
			break;
		case MENU_QUI_ID:
			Toast.makeText(this, "Quit", Toast.LENGTH_SHORT).show();
			finish();
			return true;
		}
					
		return super.onOptionsItemSelected(item);
	}


}
