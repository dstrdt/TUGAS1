package com.example.user.resep_masakan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 01/10/2017.
 */

public class DetailActivity extends AppCompatActivity {
    private ArrayList<Integer> mImageID;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
        addImageID();
        bindData();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void bindData(){
        int position;
        String judul;
        String bahan [] = getResources().getStringArray(R.array.detail_resep);
        String cara [] = getResources().getStringArray(R.array.cara_resep);
        Intent intent = getIntent();
        judul = intent.getStringExtra(Intent.EXTRA_TEXT);
        position = intent.getIntExtra(MainActivity.POSITION, 0);
        TextView tv_judul = (TextView) findViewById(R.id.judul);
        TextView tv_bahan = (TextView) findViewById(R.id.bahan);
        TextView tv_keterangan = (TextView) findViewById(R.id.keterangan);
        ImageView image = (ImageView) findViewById(R.id.gambar);
        tv_judul.setText(judul);
        tv_bahan.setText(bahan[position]);
        tv_keterangan.setText(cara[position]);
        image.setImageResource(mImageID.get(position));

    }
    private void addImageID(){
        mImageID = new ArrayList<>();
        mImageID.add(R.drawable.terong);
        mImageID.add(R.drawable.popcorn);
        mImageID.add(R.drawable.sirloin);
        mImageID.add(R.drawable.roti);
        mImageID.add(R.drawable.rotikorea);
        mImageID.add(R.drawable.tteok);
        mImageID.add(R.drawable.king);
        mImageID.add(R.drawable.mango);
    }
}
