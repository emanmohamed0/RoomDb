package demomap.al7osam.com.roomdb.view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;



import java.util.ArrayList;
import java.util.List;

import demomap.al7osam.com.roomdb.R;
import demomap.al7osam.com.roomdb.view.adapter.RecyclerViewAdapter;
import demomap.al7osam.com.roomdb.model.Item;
import demomap.al7osam.com.roomdb.view.ui.AddActivity;
import demomap.al7osam.com.roomdb.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private RecyclerViewAdapter adapter;
    private List<Item> list;
    private MainActivityViewModel mViewModel;

    // TAG for Logging
    private final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG,"_ActivityInit");

        // init views and adapter
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        fab = (FloatingActionButton) findViewById(R.id.add_btn);
        fab.setOnClickListener(this);
        list = new ArrayList<>();
        adapter = new RecyclerViewAdapter(list,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        // set view model
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mViewModel.getListItems().observe(this, observer -> {

            // update DataSet
            Log.e(TAG,"_AdapterIsUpdatedFromViewModel");
            list.clear();
            list.addAll(mViewModel.getListItems().getValue());
            adapter.notifyDataSetChanged();
        });

    }

    @Override
    public void onClick(View v) {
        // go to add activity
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}