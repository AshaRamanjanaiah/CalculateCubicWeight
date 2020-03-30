package com.example.calculatecubicweight.data;

public class Objects
{
    private Size size;

    private String weight;

    private String category;

    private String title;

    private float cubicWeight;

    public Size getSize ()
    {
        return size;
    }

    public void setSize (Size size)
    {
        this.size = size;
    }

    public String getWeight ()
    {
        return weight;
    }

    public void setWeight (String weight)
    {
        this.weight = weight;
    }

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public float getCubicWeight() {
        return cubicWeight;
    }

    public void setCubicWeight(float cubicWeight) {
        this.cubicWeight = cubicWeight;
    }
}
