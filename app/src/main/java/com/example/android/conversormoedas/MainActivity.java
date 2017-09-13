package com.example.android.conversormoedas;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.edit_value)
    EditText editValue;
    @BindView(R.id.text_dollar)
    TextView textDollar;
    @BindView(R.id.text_euro)
    TextView textEuro;
    @BindView(R.id.button_calcular)
    Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        buttonCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button_calcular){
            convert();
        }
    }

    public void convert(){
        Double value = Double.valueOf(this.editValue.getText().toString());
        textDollar.setText("$"+String.format("%.2f",value * 3.13));
        textEuro.setText("€"+String.format("%.2f",value * 3.74));
    }
}
