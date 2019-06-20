package com.example.admin.easyeats;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ClassicCheeseburgerActivity extends AppCompatActivity {

    private int block = 0;

    public static DatabaseHelper mydb;
    TextView textName, textIng1, textIng2, textIng3, textIng4, textIng5, textCat, textMeal;
    ImageView foodImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2);

        init();

        mydb = new DatabaseHelper(this);

        try{
            mydb.insert(
                    textName.getText().toString().trim(),
                    imageViewToByte(foodImage),
                    textIng1.getText().toString().trim(),
                    textIng2.getText().toString().trim(),
                    textIng3.getText().toString().trim(),
                    textIng4.getText().toString().trim(),
                    textIng5.getText().toString().trim(),
                    textCat.getText().toString().trim(),
                    textMeal.getText().toString().trim()
            );
            Toast.makeText(getApplicationContext(), "Added successfully", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setTitle("Classic Cheeseburger");

        Button methodbtn = (Button) findViewById(R.id.methodbtn);
        Button ingredientbtn = (Button) findViewById(R.id.ingredientsbtn);

        final ViewSwitcher viewSwitcher = (ViewSwitcher) findViewById(R.id.viewswitcher);

        final Animation slide_in_left = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        final Animation slide_out_right = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);
        final Animation slide_in_right = AnimationUtils.loadAnimation(this,
                R.anim.slide_in_right);
        final Animation slide_out_left = AnimationUtils.loadAnimation(this,
                R.anim.slide_out_left);


        methodbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if(block == 0) {
                    viewSwitcher.setInAnimation(slide_in_right);
                    viewSwitcher.setOutAnimation(slide_out_left);
                    viewSwitcher.showPrevious();
                    block += 1;
                }
            }
        });

        ingredientbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if(block == 1) {
                    viewSwitcher.setInAnimation(slide_in_left);
                    viewSwitcher.setOutAnimation(slide_out_right);
                    viewSwitcher.showNext();
                    block -= 1;
                }
            }
        });
        ;

        ArrayList<Food> favList = new ArrayList<>();
        final ImageButton star = (ImageButton) findViewById(R.id.staroff);
        Cursor cursor = mydb.getData("SELECT * FROM RECIPES WHERE name = '" + textName.getText().toString().trim() + "'");

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

            favList.add(new Food(name, image, ing1, ing2, ing3, ing4, ing5, category, meal, fav));
        }

        if(favList.get(0).getFav().matches("No")) {
            star.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //star.setImageResource(R.drawable.btn_star_big_on);
                    mydb.updateFavourite(textName.getText().toString().trim());
                    Toast.makeText(getApplicationContext(), "Added to favourites", Toast.LENGTH_SHORT).show();
                }
            });
        }

        if(favList.get(0).getFav().matches("Yes")) {
            star.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //star.setImageResource(R.drawable.btn_star_big_on);
                    mydb.removeFavourite(textName.getText().toString().trim());
                    Toast.makeText(getApplicationContext(), "Removed from favourites", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    private void init(){
        textName = (TextView) findViewById(R.id.Name);
        foodImage = (ImageView) findViewById(R.id.foodImg);
        textIng1 = (TextView) findViewById(R.id.Ingredient1);
        textIng2 = (TextView) findViewById(R.id.Ingredient2);
        textIng3 = (TextView) findViewById(R.id.Ingredient3);
        textIng4 = (TextView) findViewById(R.id.Ingredient4);
        textIng5 = (TextView) findViewById(R.id.Ingredient5);
        textCat = (TextView) findViewById(R.id.category);
        textMeal = (TextView) findViewById(R.id.meal);
    }
}
