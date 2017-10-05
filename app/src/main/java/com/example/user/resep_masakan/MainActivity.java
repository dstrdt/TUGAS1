package com.example.user.resep_masakan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import static com.example.user.resep_masakan.R.id.judul;

public class MainActivity extends AppCompatActivity implements ResepAdapter.ResepListener {
    private ResepAdapter adapter;
    public static final String POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        String judul [] = getResources().getStringArray(R.array.judul_resep);
        Log.v("Main",judul[0]);
        String ket [] =  getResources().getStringArray(R.array.keterangan_resep);
        adapter = new ResepAdapter(judul, ket, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,adapter.getJudul(position));
        intent.putExtra(POSITION,position);
        startActivity(intent);
    }
}