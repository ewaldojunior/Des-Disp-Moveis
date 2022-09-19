package com.example.atv1_componentes_basicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {

    private Button btnVoltar;
    private Button btnEnviar;
    private Button btnNumbers;
    private Spinner spinner_sexo;
    private ArrayAdapter adapter;
    private RadioButton radio_sim;
    private RadioButton radio_nao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Tela Login");

        btnVoltar = findViewById(R.id.btnVoltar);
        btnEnviar = findViewById(R.id.btnEnviarLogin);
        btnNumbers = findViewById(R.id.btnNumbers);
        spinner_sexo = findViewById(R.id.spinnerSexo);
        radio_sim = findViewById(R.id.radio_sim);
        radio_nao = findViewById(R.id.radio_nao);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genero, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner_sexo.setAdapter(adapter);
        spinner_sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radio_nao.isChecked()){
                    Snackbar.make(view, "Aproveite esse app para estudar!", Snackbar.LENGTH_SHORT).setAction("Action", null).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                    startActivity(intent);
                }else{
                    Snackbar.make(view, "Este app é muito simples para você, aprenda de outras formas", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                }

            }
        });

        btnNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AutoComplete.class);
                startActivity(intent);
            }
        });
    }
}