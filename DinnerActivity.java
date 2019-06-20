package com.example.admin.easyeats;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class DinnerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GridView gridView;
    ArrayList<Food> dinnerList;
    FoodListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView = (GridView) findViewById(R.id.gridView);
        dinnerList = new ArrayList<>();
        adapter = new FoodListAdapter(this, R.layout.food_items, dinnerList);
        gridView.setAdapter(adapter);

        Cursor cursor = MainActivity.mydb.getData("SELECT * FROM RECIPES WHERE meal = 'Dinner'");
        dinnerList.clear();
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

            dinnerList.add(new Food(name, image, ing1, ing2, ing3, ing4, ing5, category, meal, fav));
        }
        adapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String repName = dinnerList.get(position).getName().toString().replaceAll("\\s+","");
                String recipeName = "com.example.admin.easyeats." + repName + "Activity";
                try {
                    Class<?> c = Class.forName(recipeName);
                    startActivity(new Intent(DinnerActivity.this, c));
                } catch (ClassNotFoundException e) {
                    Toast.makeText(DinnerActivity.this, e.toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dinner, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Start NewActivity.class
            Intent myIntent = new Intent(DinnerActivity.this,
                    MainActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_favourites) {
            // Start NewActivity.class
            Intent myIntent = new Intent(DinnerActivity.this,
                    FavouritesActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_all) {
            // Start NewActivity.class
            Intent myIntent = new Intent(DinnerActivity.this,
                    AllActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_category) {
            // Start NewActivity.class
            Intent myIntent = new Intent(DinnerActivity.this,
                    CategoryActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_search) {
            // Start NewActivity.class
            Intent myIntent = new Intent(DinnerActivity.this,
                    SearchActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_breakfast) {
            // Start NewActivity.class
            Intent myIntent = new Intent(DinnerActivity.this,
                    BreakfastActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_lunch) {
            // Start NewActivity.class
            Intent myIntent = new Intent(DinnerActivity.this,
                    LunchActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_dinner) {
            // Start NewActivity.class
            Intent myIntent = new Intent(DinnerActivity.this,
                    DinnerActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_dessert) {
            // Start NewActivity.class
            Intent myIntent = new Intent(DinnerActivity.this,
                    DessertActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_vegetarian) {
            // Start NewActivity.class
            Intent myIntent = new Intent(DinnerActivity.this,
                    VegetarianActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_about) {
            // Start NewActivity.class
            Intent myIntent = new Intent(DinnerActivity.this,
                    AboutActivity.class);
            startActivity(myIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
