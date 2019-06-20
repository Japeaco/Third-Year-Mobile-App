package com.example.admin.easyeats;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Food> resultsList;
    FoodListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        setTitle("Results");

        gridView = (GridView) findViewById(R.id.gridView);
        resultsList = new ArrayList<>();
        adapter = new FoodListAdapter(this, R.layout.food_items, resultsList);
        gridView.setAdapter(adapter);

        String ingr1 = getIntent().getStringExtra("text1");
        String ingr2 = getIntent().getStringExtra("text2");
        String ingr3 = getIntent().getStringExtra("text3");
        String ingr4 = getIntent().getStringExtra("text4");
        String ingr5 = getIntent().getStringExtra("text5");

        if(ingr2.matches("") && ingr3.matches("") && ingr4.matches("") && ingr5.matches("")){

            String ingr1u = ingr1.substring(0,1).toUpperCase() + ingr1.substring(1).toLowerCase();

            Cursor cursor = MainActivity.mydb.getData("SELECT * FROM RECIPES WHERE " +
                    "(ing1 = '" + ingr1u + "' " + "OR ing2 = '" + ingr1u + "'" + "OR ing3 = '" + ingr1u + "'" + "OR ing4 = '" + ingr1u + "'" + "OR ing5 = '" + ingr1u + "')");

            resultsList.clear();
            while (cursor.moveToNext()) {
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

                resultsList.add(new Food(name, image, ing1, ing2, ing3, ing4, ing5, category, meal, fav));
            }
            adapter.notifyDataSetChanged();

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    String repName = resultsList.get(position).getName().toString().replaceAll("\\s+","");
                    String recipeName = "com.example.admin.easyeats." + repName + "Activity";
                    try {
                        Class<?> c = Class.forName(recipeName);
                        startActivity(new Intent(ResultsActivity.this, c));
                    } catch (ClassNotFoundException e) {
                        Toast.makeText(ResultsActivity.this, e.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        else if(ingr3.matches("") && ingr4.matches("") && ingr5.matches("")){

            String ingr1u = ingr1.substring(0,1).toUpperCase() + ingr1.substring(1).toLowerCase();
            String ingr2u = ingr2.substring(0,1).toUpperCase() + ingr2.substring(1).toLowerCase();

            Cursor cursor = MainActivity.mydb.getData("SELECT * FROM RECIPES WHERE " +
                    "(ing1 = '" + ingr1u + "' " + "OR ing2 = '" + ingr1u + "'" + "OR ing3 = '" + ingr1u + "'" + "OR ing4 = '" + ingr1u + "'" + "OR ing5 = '" + ingr1u + "') AND " +
                    "(ing1 = '" + ingr2u + "' " + "OR ing2 = '" + ingr2u + "'" + "OR ing3 = '" + ingr2u + "'" + "OR ing4 = '" + ingr2u + "'" + "OR ing5 = '" + ingr2u + "')");

            resultsList.clear();
            while (cursor.moveToNext()) {
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

                resultsList.add(new Food(name, image, ing1, ing2, ing3, ing4, ing5, category, meal, fav));
            }
            adapter.notifyDataSetChanged();

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    String repName = resultsList.get(position).getName().toString().replaceAll("\\s+","");
                    String recipeName = "com.example.admin.easyeats." + repName + "Activity";
                    try {
                        Class<?> c = Class.forName(recipeName);
                        startActivity(new Intent(ResultsActivity.this, c));
                    } catch (ClassNotFoundException e) {
                        Toast.makeText(ResultsActivity.this, e.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        else if(ingr4.matches("") && ingr5.matches("")){

            String ingr1u = ingr1.substring(0,1).toUpperCase() + ingr1.substring(1).toLowerCase();
            String ingr2u = ingr2.substring(0,1).toUpperCase() + ingr2.substring(1).toLowerCase();
            String ingr3u = ingr3.substring(0,1).toUpperCase() + ingr3.substring(1).toLowerCase();

            Cursor cursor = MainActivity.mydb.getData("SELECT * FROM RECIPES WHERE " +
                    "(ing1 = '" + ingr1u + "' " + "OR ing2 = '" + ingr1u + "'" + "OR ing3 = '" + ingr1u + "'" + "OR ing4 = '" + ingr1u + "'" + "OR ing5 = '" + ingr1u + "') AND " +
                    "(ing1 = '" + ingr2u + "' " + "OR ing2 = '" + ingr2u + "'" + "OR ing3 = '" + ingr2u + "'" + "OR ing4 = '" + ingr2u + "'" + "OR ing5 = '" + ingr2u + "') AND " +
                    "(ing1 = '" + ingr3u + "' " + "OR ing2 = '" + ingr3u + "'" + "OR ing3 = '" + ingr3u + "'" + "OR ing4 = '" + ingr3u + "'" + "OR ing5 = '" + ingr3u + "')");

            resultsList.clear();
            while (cursor.moveToNext()) {
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

                resultsList.add(new Food(name, image, ing1, ing2, ing3, ing4, ing5, category, meal, fav));
            }
            adapter.notifyDataSetChanged();

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    String repName = resultsList.get(position).getName().toString().replaceAll("\\s+","");
                    String recipeName = "com.example.admin.easyeats." + repName + "Activity";
                    try {
                        Class<?> c = Class.forName(recipeName);
                        startActivity(new Intent(ResultsActivity.this, c));
                    } catch (ClassNotFoundException e) {
                        Toast.makeText(ResultsActivity.this, e.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        else if(ingr5.matches("")){

            String ingr1u = ingr1.substring(0,1).toUpperCase() + ingr1.substring(1).toLowerCase();
            String ingr2u = ingr2.substring(0,1).toUpperCase() + ingr2.substring(1).toLowerCase();
            String ingr3u = ingr3.substring(0,1).toUpperCase() + ingr3.substring(1).toLowerCase();
            String ingr4u = ingr4.substring(0,1).toUpperCase() + ingr4.substring(1).toLowerCase();

            Cursor cursor = MainActivity.mydb.getData("SELECT * FROM RECIPES WHERE " +
                    "(ing1 = '" + ingr1u + "' " + "OR ing2 = '" + ingr1u + "'" + "OR ing3 = '" + ingr1u + "'" + "OR ing4 = '" + ingr1u + "'" + "OR ing5 = '" + ingr1u + "') AND " +
                    "(ing1 = '" + ingr2u + "' " + "OR ing2 = '" + ingr2u + "'" + "OR ing3 = '" + ingr2u + "'" + "OR ing4 = '" + ingr2u + "'" + "OR ing5 = '" + ingr2u + "') AND " +
                    "(ing1 = '" + ingr3u + "' " + "OR ing3 = '" + ingr3u + "'" + "OR ing3 = '" + ingr3u + "'" + "OR ing4 = '" + ingr3u + "'" + "OR ing5 = '" + ingr3u + "') AND " +
                    "(ing1 = '" + ingr4u + "' " + "OR ing2 = '" + ingr4u + "'" + "OR ing3 = '" + ingr4u + "'" + "OR ing4 = '" + ingr4u + "'" + "OR ing5 = '" + ingr4u + "')");

            resultsList.clear();
            while (cursor.moveToNext()) {
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

                resultsList.add(new Food(name, image, ing1, ing2, ing3, ing4, ing5, category, meal, fav));
            }
            adapter.notifyDataSetChanged();

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    String repName = resultsList.get(position).getName().toString().replaceAll("\\s+","");
                    String recipeName = "com.example.admin.easyeats." + repName + "Activity";
                    try {
                        Class<?> c = Class.forName(recipeName);
                        startActivity(new Intent(ResultsActivity.this, c));
                    } catch (ClassNotFoundException e) {
                        Toast.makeText(ResultsActivity.this, e.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        else{

            String ingr1u = ingr1.substring(0,1).toUpperCase() + ingr1.substring(1).toLowerCase();
            String ingr2u = ingr2.substring(0,1).toUpperCase() + ingr2.substring(1).toLowerCase();
            String ingr3u = ingr3.substring(0,1).toUpperCase() + ingr3.substring(1).toLowerCase();
            String ingr4u = ingr4.substring(0,1).toUpperCase() + ingr4.substring(1).toLowerCase();
            String ingr5u = ingr5.substring(0,1).toUpperCase() + ingr5.substring(1).toLowerCase();

            Cursor cursor = MainActivity.mydb.getData("SELECT * FROM RECIPES WHERE " +
                    "(ing1 = '" + ingr1u + "' " + "OR ing2 = '" + ingr1u + "'" + "OR ing3 = '" + ingr1u + "'" + "OR ing4 = '" + ingr1u + "'" + "OR ing5 = '" + ingr1u + "') AND " +
                    "(ing1 = '" + ingr2u + "' " + "OR ing2 = '" + ingr2u + "'" + "OR ing3 = '" + ingr2u + "'" + "OR ing4 = '" + ingr2u + "'" + "OR ing5 = '" + ingr2u + "') AND " +
                    "(ing1 = '" + ingr3u + "' " + "OR ing3 = '" + ingr3u + "'" + "OR ing3 = '" + ingr3u + "'" + "OR ing4 = '" + ingr3u + "'" + "OR ing5 = '" + ingr3u + "') AND " +
                    "(ing1 = '" + ingr4u + "' " + "OR ing3 = '" + ingr4u + "'" + "OR ing3 = '" + ingr4u + "'" + "OR ing4 = '" + ingr4u + "'" + "OR ing5 = '" + ingr4u + "') AND " +
                    "(ing1 = '" + ingr5u + "' " + "OR ing2 = '" + ingr5u + "'" + "OR ing3 = '" + ingr5u + "'" + "OR ing4 = '" + ingr5u + "'" + "OR ing5 = '" + ingr5u + "')");

            resultsList.clear();
            while (cursor.moveToNext()) {
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

                resultsList.add(new Food(name, image, ing1, ing2, ing3, ing4, ing5, category, meal, fav));
            }
            adapter.notifyDataSetChanged();

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    String repName = resultsList.get(position).getName().toString().replaceAll("\\s+","");
                    String recipeName = "com.example.admin.easyeats." + repName + "Activity";
                    try {
                        Class<?> c = Class.forName(recipeName);
                        startActivity(new Intent(ResultsActivity.this, c));
                    } catch (ClassNotFoundException e) {
                        Toast.makeText(ResultsActivity.this, e.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}
