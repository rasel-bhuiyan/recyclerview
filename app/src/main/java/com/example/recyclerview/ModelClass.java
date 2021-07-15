package com.example.recyclerview;

public class ModelClass {

    String Name;
    String Description;
    int Fimage ;

    public ModelClass(String name, String description, int image) {
        Name = name;
        Description = description;
        Fimage = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImage() {
        return Fimage;
    }

    public void setImage(int image) {
        Fimage = image;
    }
}
