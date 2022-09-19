package com.example.atv1_componentes_basicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    Button btn_add;
    EditText et_addname;
    ListView lv_listofnames;
    Button btnShare;

    List<String> friends = new ArrayList<>();
    String [] startingList = {"Pedro", "Ana", "Marcos", "Diego"};

    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn_add = findViewById(R.id.btn_add);
        et_addname = findViewById(R.id.et_addname);
        lv_listofnames = findViewById(R.id.lv_listofnames);
        btnShare = findViewById(R.id.btnShare);

        //inicializar a lista
        friends = new ArrayList<String>(Arrays.asList(startingList));

        ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, friends);

        lv_listofnames.setAdapter(ad);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = et_addname.getText().toString();
                friends.add(newName);

                Collections.sort(friends);

                ad.notifyDataSetChanged();
            }
        });

        lv_listofnames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity3.this, "pos = " + i + " name = " + friends.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}