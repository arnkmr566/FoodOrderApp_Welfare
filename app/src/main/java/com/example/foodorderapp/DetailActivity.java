package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderapp.databinding.ActivityDetailBinding;


public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type",0) == 1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.nameLbl.setText(name);
            binding.detailDescription.setText(description);

            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = helper.insertOrder(
                            binding.edtName.getText().toString(),
                            binding.edtPhone.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );
                    if (isInserted)
                        Toast.makeText(DetailActivity.this, "Data Success.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            final  int image = cursor.getInt(4);
            binding.detailImage.setImageResource(image);

            //     OR
        //    binding.detailImage.setImageResource(cursor.getInt(4));

            binding.priceLbl.setText(String.format("%d", cursor.getInt(3)));
            binding.nameLbl.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(5));

            binding.edtName.setText(cursor.getString(1));
            binding.edtPhone .setText(cursor.getString(2));
            binding.insertButton.setText("Update Now");
            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isUpdated = helper.UpdateOrder(
                            binding.edtName.getText().toString(),
                            binding.edtPhone.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.nameLbl.getText().toString(),
                            1,
                            id
                    );

                    if (isUpdated)
                        Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                }
            });

        //    Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();

        }


//     String name = getIntent().getStringExtra("name");
//     int price = Integer.parseInt(getIntent().getStringExtra("price"));



    }
}