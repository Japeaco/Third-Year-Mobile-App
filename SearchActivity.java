package com.example.admin.easyeats;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SearchActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addListenerOnButton();

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

    public void addListenerOnButton() {

        Button button1 = (Button) findViewById(R.id.searchbtn);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                EditText editText1 = (EditText)findViewById(R.id.ingText1);
                EditText editText2 = (EditText)findViewById(R.id.ingText2);
                EditText editText3 = (EditText)findViewById(R.id.ingText3);
                EditText editText4 = (EditText)findViewById(R.id.ingText4);
                EditText editText5 = (EditText)findViewById(R.id.ingText5);

                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText3.getText().toString();
                String text4 = editText4.getText().toString();
                String text5 = editText5.getText().toString();

                Intent myIntent = new Intent(SearchActivity.this ,ResultsActivity.class);
                myIntent.putExtra("text1", text1);
                myIntent.putExtra("text2", text2);
                myIntent.putExtra("text3", text3);
                myIntent.putExtra("text4", text4);
                myIntent.putExtra("text5", text5);

                startActivity(myIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.favourites, menu);
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
            Intent myIntent = new Intent(SearchActivity.this,
                    MainActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_favourites) {
            // Start NewActivity.class
            Intent myIntent = new Intent(SearchActivity.this,
                    FavouritesActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_all) {
            // Start NewActivity.class
            Intent myIntent = new Intent(SearchActivity.this,
                    AllActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_category) {
            // Start NewActivity.class
            Intent myIntent = new Intent(SearchActivity.this,
                    CategoryActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_search) {
            // Start NewActivity.class
            Intent myIntent = new Intent(SearchActivity.this,
                    SearchActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_breakfast) {
            // Start NewActivity.class
            Intent myIntent = new Intent(SearchActivity.this,
                    BreakfastActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_lunch) {
            // Start NewActivity.class
            Intent myIntent = new Intent(SearchActivity.this,
                    LunchActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_dinner) {
            // Start NewActivity.class
            Intent myIntent = new Intent(SearchActivity.this,
                    DinnerActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_dessert) {
            // Start NewActivity.class
            Intent myIntent = new Intent(SearchActivity.this,
                    DessertActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_vegetarian) {
            // Start NewActivity.class
            Intent myIntent = new Intent(SearchActivity.this,
                    VegetarianActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_about) {
            // Start NewActivity.class
            Intent myIntent = new Intent(SearchActivity.this,
                    AboutActivity.class);
            startActivity(myIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
