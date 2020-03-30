package com.example.calculatecubicweight.data;

public class Size
{
    private String width;

    private String length;

    private String height;

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getLength ()
    {
        return length;
    }

    public void setLength (String length)
    {
        this.length = length;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [width = "+width+", length = "+length+", height = "+height+"]";
    }
}
