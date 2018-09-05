package com.example.dopa.harjoitus4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String LOG_CAT = MainActivity.class.getSimpleName();
    public DataClass data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new DataClass();
        data.readFromFile(this);

        // Plus operation functionality
        Button plusButton = findViewById(R.id.plusButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.d(LOG_CAT, "+ nappulaa painettu");
                    EditText num1 = findViewById(R.id.plusNumber1);
                    EditText num2 = findViewById(R.id.plusNumber2);
                    int result = Integer.parseInt(num1.getText().toString());
                    result += Integer.parseInt(num2.getText().toString());

                    Log.d(LOG_CAT, "Summa on "+ result);
                    TextView res = findViewById(R.id.plusResult);
                    res.setText("" + result);

                    // Save calculation sentence to log
                    String sentence = num1.getText()+"+"+num2.getText()+"="+result;
                    String tmp = data.getData()+"\n"+sentence;
                    data.setData(tmp);
                }
                catch (Exception e) {
                    Log.d(LOG_CAT, "Error: " + e.getMessage());
                    showToast();
                }
            }
        });

        // Minus operation functionality
        Button minusButton = findViewById(R.id.minusButton);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.d(LOG_CAT, "- nappulaa painettu");
                    EditText num1 = findViewById(R.id.minusNumber1);
                    EditText num2 = findViewById(R.id.minusNumber2);
                    int result = Integer.parseInt(num1.getText().toString());
                    result -= Integer.parseInt(num2.getText().toString());

                    Log.d(LOG_CAT, "Erotus on "+ result);
                    TextView res = findViewById(R.id.minusResult);
                    res.setText("" + result);

                    // Save calculation sentence to log
                    String sentence = num1.getText()+"-"+num2.getText()+"="+result;
                    String tmp = data.getData()+"\n"+sentence;
                    data.setData(tmp);
                }
                catch (Exception e) {
                    Log.d(LOG_CAT, "Error: " + e.getMessage());
                    showToast();
                }
            }
        });

        // Multiplication operation functionality
        Button multiplicationButton = findViewById(R.id.multiplicationButton);
        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.d(LOG_CAT, "* nappulaa painettu");
                    EditText num1 = findViewById(R.id.multiplicationNumber1);
                    EditText num2 = findViewById(R.id.multiplicationNumber2);
                    int result = Integer.parseInt(num1.getText().toString());
                    result *= Integer.parseInt(num2.getText().toString());

                    Log.d(LOG_CAT, "Tulo on "+ result);
                    TextView res = findViewById(R.id.multiplicationResult);
                    res.setText("" + result);

                    // Save calculation sentence to log
                    String sentence = num1.getText()+"*"+num2.getText()+"="+result;
                    String tmp = data.getData()+"\n"+sentence;
                    data.setData(tmp);
                }
                catch (Exception e) {
                    Log.d(LOG_CAT, "Error: " + e.getMessage());
                    showToast();
                }
            }
        });

        // Division operation functionality
        Button divisionButton = findViewById(R.id.divisionButton);
        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.d(LOG_CAT, "/ nappulaa painettu");
                    EditText num1 = findViewById(R.id.divisionNumber1);
                    EditText num2 = findViewById(R.id.divisionNumber2);

                    double result = Integer.parseInt(num1.getText().toString());
                    result /= Integer.parseInt(num2.getText().toString());
                    Log.d(LOG_CAT, "Jakotulos on "+ result);
                    TextView res = findViewById(R.id.divisionResult);
                    res.setText("" + String.format("%.2f", result));

                    // Save calculation sentence to log
                    String sentence = num1.getText()+"/"+num2.getText()+"="+String.format("%.2f", result);
                    String tmp = data.getData()+"\n"+sentence;
                    data.setData(tmp);
                }
                catch (Exception e) {
                    Log.d(LOG_CAT, "Error: " + e.getMessage());
                    showToast();
                }

            }
        });

        // Emptying all fields
        Button emptyButton = findViewById(R.id.emptyButton);
        emptyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Empty numbers
                ((EditText) findViewById(R.id.plusNumber1)).getText().clear();
                ((EditText) findViewById(R.id.plusNumber2)).getText().clear();
                ((EditText) findViewById(R.id.minusNumber1)).getText().clear();
                ((EditText) findViewById(R.id.minusNumber2)).getText().clear();
                ((EditText) findViewById(R.id.multiplicationNumber1)).getText().clear();
                ((EditText) findViewById(R.id.multiplicationNumber2)).getText().clear();
                ((EditText) findViewById(R.id.divisionNumber1)).getText().clear();
                ((EditText) findViewById(R.id.divisionNumber2)).getText().clear();

                // Empty results
                ((TextView) findViewById(R.id.plusResult)).setText("");
                ((TextView) findViewById(R.id.minusResult)).setText("");
                ((TextView) findViewById(R.id.multiplicationResult)).setText("");
                ((TextView) findViewById(R.id.divisionResult)).setText("");

                // Empty log
                data.setData("");
            }
        });

        // Logging
        Button logButton = findViewById(R.id.logButton);
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.writeToFile(getBaseContext());
                Intent i = new Intent(getBaseContext(), LogActivity.class);
                startActivity(i);
            }
        });
    }

    private void showToast() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, R.string.error, duration);
        toast.show();
    }
}
