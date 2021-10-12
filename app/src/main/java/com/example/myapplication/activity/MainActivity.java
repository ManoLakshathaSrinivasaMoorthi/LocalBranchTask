package com.example.myapplication.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.adapter.UsersAdapter;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.db.SignupDatabase;
import com.example.myapplication.viewmodel.SignupViewModel;

public class MainActivity extends AppCompatActivity {

    private UsersAdapter adapter;
    private SignupViewModel viewModel;
    SignupDatabase database;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        database = SignupDatabase.getDatabase(this);
        viewModel = ViewModelProviders.of(MainActivity.this).get(SignupViewModel.class);
        //create the adapter
        initUI();

    }

    private void initUI() {
        //setting the value to recycle view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
       binding.recyclerView.setLayoutManager(layoutManager);
        binding.btnBack.setOnClickListener(v -> finish());

        viewModel.getDatas().observe(MainActivity.this, datas -> {
            if (datas.size() > 0) {
                adapter = new UsersAdapter( datas,MainActivity.this);
                binding.recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

    }

}