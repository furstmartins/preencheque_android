package br.com.furstmartins.preencheque;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prencher);

        Button btOk = (Button)findViewById(R.id.btOk);
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText editText = (EditText) findViewById(R.id.insertNumber);
                    String numeroTela = editText.getText().toString();

                    Numerals numerals = new Numerals(2);
                    String numeral = numerals.toString(new BigDecimal(numeroTela));

                    TextView resultado = (TextView) findViewById(R.id.resultado);
                    resultado.setText(numeral);
                } catch (NumberFormatException e) {
                    TextView resultado = (TextView) findViewById(R.id.resultado);
                    resultado.setText("Formato Numérico Errado");
                }
            }
        });

        Button btLimpar = (Button)findViewById(R.id.btLimpar);
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.insertNumber);
                editText.setText("");

                TextView resultado = (TextView) findViewById(R.id.resultado);
                resultado.setText("");
            }
        });

        EditText editText = (EditText) findViewById(R.id.insertNumber);
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                TextView resultado = (TextView) findViewById(R.id.resultado);
                resultado.setText("");
                return false;
            }
        });

        /*Button bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText editText = (EditText) findViewById(R.id.editTextNumber);
                    String numeroTela = editText.getText().toString();

                    Numerals numerals = new Numerals(2);
                    String numeral = numerals.toString(new BigDecimal(numeroTela));

                    TextView resultado = (TextView) findViewById(R.id.textView3);
                    resultado.setText(numeral);
                } catch (NumberFormatException e) {
                    TextView resultado = (TextView) findViewById(R.id.textView3);
                    resultado.setText("Formato Numérico Errado");
                }
            }
        });

        Button btLimpar = (Button)findViewById(R.id.btLimpar);
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editTextNumber);
                editText.setText("");

                TextView resultado = (TextView) findViewById(R.id.textView3);
                resultado.setText("");
            }
        });

        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                TextView resultado = (TextView) findViewById(R.id.textView3);
                resultado.setText("");
                return false;
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
