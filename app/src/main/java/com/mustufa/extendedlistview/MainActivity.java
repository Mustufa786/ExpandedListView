package com.mustufa.extendedlistview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mustufa.extendedlistview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bi;

    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);


        adapter = new ListAdapter(this, Util.dataList, new ListAdapter.OnItemClick() {
            @Override
            public void onClick(Data data) {


            }
        });
        bi.list.setLayoutManager(new LinearLayoutManager(this));
        bi.list.setAdapter(adapter);

    }
}
