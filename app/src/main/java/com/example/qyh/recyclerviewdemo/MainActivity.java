package com.example.qyh.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NumberAdapter adapter;
    List<Character> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        list = new ArrayList<Character>();
        for (int i = 'A';i<='Z';i++){
            list.add((char)i);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new NumberAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new Mydivider(this,LinearLayoutManager.HORIZONTAL));
    }
}
