package com.example.admin.easyeats;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.ImageButton;

public class CategoryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        ImageButton pastabtn = (ImageButton)findViewById(R.id.buttonPasta);
        ImageButton fishbtn = (ImageButton)findViewById(R.id.buttonFish);
        ImageButton beefbtn = (ImageButton)findViewById(R.id.buttonBeef);
        ImageButton chickenbtn = (ImageButton)findViewById(R.id.buttonChicken);
        ImageButton lambbtn = (ImageButton)findViewById(R.id.buttonLamb);
        ImageButton eggsbtn = (ImageButton)findViewById(R.id.buttonEggs);
        ImageButton porkbtn = (ImageButton)findViewById(R.id.buttonPork);
        ImageButton saladsbtn = (ImageButton)findViewById(R.id.buttonSalads);

        ImageButton pastabtngray = (ImageButton)findViewById(R.id.pastagray);
        ImageButton fishbtngray = (ImageButton)findViewById(R.id.fishgray);
        ImageButton beefbtngray = (ImageButton)findViewById(R.id.beefgray);
        ImageButton chickenbtngray = (ImageButton)findViewById(R.id.chickengray);
        ImageButton lambbtngray = (ImageButton)findViewById(R.id.lambgray);
        ImageButton eggsbtngray = (ImageButton)findViewById(R.id.eggsgray);
        ImageButton porkbtngray = (ImageButton)findViewById(R.id.porkgray);
        ImageButton saladsbtngray = (ImageButton)findViewById(R.id.saladsgray);

        pastabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, PastaActivity.class));
            }
        });
        fishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, FishActivity.class));
            }
        });
        beefbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, BeefActivity.class));
            }
        });
        chickenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, ChickenActivity.class));
            }
        });
        lambbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, LambActivity.class));
            }
        });
        eggsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, EggsActivity.class));
            }
        });
        porkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, PorkActivity.class));
            }
        });
        saladsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, SaladsActivity.class));
            }
        });

        pastabtngray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, PastaActivity.class));
            }
        });
        fishbtngray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, FishActivity.class));
            }
        });
        beefbtngray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, BeefActivity.class));
            }
        });
        chickenbtngray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, ChickenActivity.class));
            }
        });
        lambbtngray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, LambActivity.class));
            }
        });
        eggsbtngray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, EggsActivity.class));
            }
        });
        porkbtngray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, PorkActivity.class));
            }
        });
        saladsbtngray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this, SaladsActivity.class));
            }
        });
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
        getMenuInflater().inflate(R.menu.category, menu);
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
            Intent myIntent = new Intent(CategoryActivity.this,
                    MainActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_favourites) {
            // Start NewActivity.class
            Intent myIntent = new Intent(CategoryActivity.this,
                    FavouritesActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_all) {
            // Start NewActivity.class
            Intent myIntent = new Intent(CategoryActivity.this,
                    AllActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_category) {
            // Start NewActivity.class
            Intent myIntent = new Intent(CategoryActivity.this,
                    CategoryActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_search) {
            // Start NewActivity.class
            Intent myIntent = new Intent(CategoryActivity.this,
                    SearchActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_breakfast) {
            // Start NewActivity.class
            Intent myIntent = new Intent(CategoryActivity.this,
                    BreakfastActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_lunch) {
            // Start NewActivity.class
            Intent myIntent = new Intent(CategoryActivity.this,
                    LunchActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_dinner) {
            // Start NewActivity.class
            Intent myIntent = new Intent(CategoryActivity.this,
                    DinnerActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_dessert) {
            // Start NewActivity.class
            Intent myIntent = new Intent(CategoryActivity.this,
                    DessertActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_vegetarian) {
            // Start NewActivity.class
            Intent myIntent = new Intent(CategoryActivity.this,
                    VegetarianActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_about) {
            // Start NewActivity.class
            Intent myIntent = new Intent(CategoryActivity.this,
                    AboutActivity.class);
            startActivity(myIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
