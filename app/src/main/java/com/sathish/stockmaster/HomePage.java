package com.sathish.stockmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    EditText itemname,noofitem;
    Button addButton;
    ListView listView;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        noofitem = (EditText) findViewById(R.id.noofitem);
        itemname = (EditText) findViewById(R.id.itemname);
        addButton = (Button) findViewById(R.id.addItem);
        listView = (ListView) findViewById(R.id.listView);
        listItems = new ArrayList<String>();
       // listItems.add("First Item - added on Activity Create");
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String Item = itemname.getText().toString();
                String noitem = noofitem.getText().toString();

                String newitem = "ITEM NAME:    " +Item+ " " + "NO. OF ITEMS:      "+noitem;

                listItems.add(newitem);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                Toast.makeText(HomePage.this, "Clicked", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}




