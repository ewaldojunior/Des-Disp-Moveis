package com.example.atv1_componentes_basicos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private Button botao;
    private Button sair;
    private ToggleButton opcao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.txtView);
        botao = findViewById(R.id.btnEnviar);
        opcao = findViewById(R.id.toggleButton);
        sair = findViewById(R.id.button2);


        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        opcao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                texto.setText(converteParaTexto(isChecked));
            }
        });

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcao.isChecked()){
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);
                }
                else{
                    setTitle("Aceite o termo");
                }
            }
        });

        botao.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Você ativou a versão premium!!!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }



    private String converteParaTexto(boolean isChecked){
        return (isChecked)? "Termo aceito" : "Termo não aceito";
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Bluetooth ativado", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Toast.makeText(this, "Sobre Android", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Toast.makeText(this, "Sobre Nativo", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.subitem1:
                Toast.makeText(this, "Sobre Java", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.subitem2:
                Toast.makeText(this, "Sobre Kotlin", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}