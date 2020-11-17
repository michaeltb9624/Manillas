package com.example.manillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner combo_material;
    private Spinner combo_dije;
    private Spinner combo_tipo;
    private Spinner combo_moneda;
    private  String opciones_material[];
    private  String opciones_dije[];
    private  String opciones_tipo[];
    private  String opciones_moneda[];
    private ArrayAdapter<String> adapter_material;
    private ArrayAdapter<String> adapter_dije;
    private ArrayAdapter<String> adapter_tipo;
    private ArrayAdapter<String> adapter_moneda;
    private EditText cantidad;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cantidad = findViewById(R.id.editTextCantidad);
        resultado = findViewById(R.id.txtResultado);

        combo_material = findViewById(R.id.cmbMaterial);
        opciones_material = getResources().getStringArray(R.array.material);
        adapter_material = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones_material);
        combo_material.setAdapter(adapter_material);

        combo_dije = findViewById(R.id.cmbDije);
        opciones_dije = getResources().getStringArray(R.array.dije);
        adapter_dije = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones_dije);
        combo_dije.setAdapter(adapter_dije);

        combo_tipo = findViewById(R.id.cmbTipo);
        opciones_tipo = getResources().getStringArray(R.array.tipo);
        adapter_tipo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones_tipo);
        combo_tipo.setAdapter(adapter_tipo);

        combo_moneda = findViewById(R.id.cmbMoneda);
        opciones_moneda = getResources().getStringArray(R.array.moneda);
        adapter_moneda = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones_moneda);
        combo_moneda.setAdapter(adapter_moneda);


    }

    public void calcularPrecio (View v){

        if (validate()) {

        int material = combo_material.getSelectedItemPosition();
        int dije = combo_dije.getSelectedItemPosition();
        int tipo = combo_tipo.getSelectedItemPosition();
        int moneda = combo_moneda.getSelectedItemPosition();
        double precio = 0;
        switch (material) {
            case 0:
                switch (dije) {
                    case 0:
                        switch (tipo) {
                            case 0:
                            case 1:
                                precio=100;
                                break;
                            case 2:
                                precio=80;
                                break;
                            case 3:
                                precio=70;
                                break;

                        }

                    case 1:
                        switch (tipo) {
                            case 0:
                            case 1:
                                precio=120;
                                break;
                            case 2:
                                precio=100;
                                break;
                            case 3:
                                precio=90;
                                break;
                        }
                }
                break;
            case 1:
                switch (dije) {
                    case 0:
                        switch (tipo) {
                            case 0:
                            case 1:
                                precio=90;
                                break;
                            case 2:
                                precio=70;
                                break;
                            case 3:
                                precio=50;
                                break;

                        }

                    case 1:
                        switch (tipo) {
                            case 0:
                            case 1:
                                precio=110;
                                break;
                            case 2:
                                precio=90;
                                break;
                            case 3:
                                precio=80;
                                break;
                        }
                }
                break;

        }

        if(moneda==0){
            resultado.setText(""+String.format("%.0f",precio*Double.parseDouble(cantidad.getText().toString()))+ " " + getString(R.string.dolares));
        }else {
            resultado.setText(""+String.format("%.0f",precio*3200*Double.parseDouble(cantidad.getText().toString()))+" " +getString(R.string.pesos));
        }

        }
    }

    public boolean validate () {
        if (cantidad.getText().toString().isEmpty()) {
            cantidad.setError(getString(R.string.error_ingrese_cantidad));
            cantidad.requestFocus();
            return false;
        }
        return true;
    }

}