package com.example.admin.easyeats;

/**
 * Created by Admin on 17/04/2018.
 */

public class Food {
    private String name;
    private byte[] image;
    private String ing1;
    private String ing2;
    private String ing3;
    private String ing4;
    private String ing5;
    private String category;
    private String meal;
    private String fav;

    public Food(String name, byte[] image, String ing1, String ing2, String ing3, String ing4, String ing5,
                    String category, String meal, String fav) {
        this.name=name;
        this.image=image;
        this.ing1=ing1;
        this.ing2=ing2;
        this.ing3=ing3;
        this.ing4=ing4;
        this.ing5=ing5;
        this.category=category;
        this.meal=meal;
        this.fav=fav;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getIng1() {
        return ing1;
    }

    public void setIng1(String ing1) {
        this.ing1 = ing1;
    }

    public String getIng2() {
        return ing2;
    }

    public void setIng2(String ing2) {
        this.ing2 = ing2;
    }

    public String getIng3() {
        return ing3;
    }

    public void setIng3(String ing3) {
        this.ing3 = ing3;
    }

    public String getIng4() {
        return ing4;
    }

    public void setIng4(String ing4) {
        this.ing4 = ing4;
    }

    public String getIng5() {
        return ing5;
    }

    public void setIng5(String ing5) {
        this.ing5 = ing5;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) { this.meal = meal; }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) { this.fav=fav; }
}
