package com.example.admin.easyeats;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class BeefActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Food> beefList;
    FoodListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_layout_activity);

        setTitle("Beef");

        gridView = (GridView) findViewById(R.id.gridView);
        beefList = new ArrayList<>();
        adapter = new FoodListAdapter(this, R.layout.food_items, beefList);
        gridView.setAdapter(adapter);

        Cursor cursor = MainActivity.mydb.getData("SELECT * FROM RECIPES WHERE category = 'Beef'");
        beefList.clear();
        while (cursor.moveToNext()){
            String name = cursor.getString(0);
            byte[] image = cursor.getBlob(1);
            String ing1 = cursor.getString(2);
            String ing2 = cursor.getString(3);
            String ing3 = cursor.getString(4);
            String ing4 = cursor.getString(5);
            String ing5 = cursor.getString(6);
            String category = cursor.getString(7);
            String meal = cursor.getString(8);
            String fav = cursor.getString(9);

            beefList.add(new Food(name, image, ing1, ing2, ing3, ing4, ing5, category, meal, fav));
        }
        adapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String repName = beefList.get(position).getName().toString().replaceAll("\\s+","");
                String recipeName = "com.example.admin.easyeats." + repName + "Activity";
                try {
                    Class<?> c = Class.forName(recipeName);
                    startActivity(new Intent(BeefActivity.this, c));
                } catch (ClassNotFoundException e) {
                    Toast.makeText(BeefActivity.this, e.toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
