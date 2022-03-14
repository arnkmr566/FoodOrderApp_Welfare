package com.example.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list= new ArrayList<>();

        list.add(new MainModel(R.drawable.fig1 ,"Vegetable","2","Checken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.fig2 ,"Burger","3","Checken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.fig3 ,"Tomato","4","Checken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.fig4 ,"Burger","5","Checken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.fig6 ,"Orange","6","Checken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.fig7 ,"Burger","7","Checken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.fig8 ,"Pizza","8","Checken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.fig9 ,"Burger","9","Checken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.fig10 ,"Portobello Mushroom","10","Meaty portoello mushroom make for the perfect vegetarian burger.."));
        list.add(new MainModel(R.drawable.fig11 ,"Pizza Burger","11","Checken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.fig12 ,"Burger","12","Checken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.fig13 ,"Burger","13","Checken Burger with Extra Cheese"));

        MainAdapter adapter =new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}