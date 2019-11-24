package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Lingsheng extends AppCompatActivity {

    private ListView list;
    ListAdapter adapter;

    Intent intent=getIntent();
    String hours=intent.getStringExtra("hour");
    String minutes=intent.getStringExtra("minute");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingsheng);

        final String[] filename = {"hhh", "yyy", "aaa"};

        adapter = new ArrayAdapter<String>(Lingsheng.this, android.R.layout.simple_expandable_list_item_1, filename);
        list = (ListView)findViewById(R.id.lingshengList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Lingsheng.this, AddClock.class);
                intent.putExtra("lingsheng", filename[position]);
                intent.putExtra("hours",hours);
                intent.putExtra("minutes",minutes);
                startActivity(intent);
            }
        });

    }
}
