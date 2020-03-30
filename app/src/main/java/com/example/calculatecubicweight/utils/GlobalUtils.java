package com.example.calculatecubicweight.utils;

import com.example.calculatecubicweight.data.Objects;
import com.example.calculatecubicweight.data.Size;

import java.util.ArrayList;

import static java.lang.Float.parseFloat;

/**
 * The GlobalUtils class is a util class which includes reusable static methods.
 */

public class GlobalUtils {
    private static final int CONVERSION_FACTOR = 250;

    /**
     * @param category     category of products
     * @param productsList products list
     * @return calculates and returns average cubic weight of the items belongs to a
     * particular category
     */

    public static float calculateAverageCubicWeight(String category, ArrayList<Objects> productsList) {
        float totalWeight = 0;
        int noOfItems = 0;
        ArrayList<Objects> categoryItems = getCategoryList(category, productsList);
        if (categoryItems != null && !categoryItems.isEmpty()) {
            noOfItems = categoryItems.size();
            for (Objects object : categoryItems) {
                float cubicWeight = calculateEachItemCubicWeight(object.getSize());
                totalWeight = totalWeight + cubicWeight;
                object.setCubicWeight(cubicWeight);
            }
        }
        return totalWeight / noOfItems;
    }

    /**
     *
     * @param size object includes weight, height and length of product
     * @return float value, that is calculates cubic weight of product passed to the method.
     */

    public static float calculateEachItemCubicWeight(Size size) {
        float cubicWeight = parseFloat(size.getHeight()) / 100 *
                parseFloat(size.getLength()) / 100 *
                parseFloat(size.getWidth()) / 100;
        return cubicWeight * CONVERSION_FACTOR;
    }

    /**
     *
     * @param category pass category of product
     * @param productsList list of products
     * @return ArrayList of the products in the same category
     */

    public static ArrayList<Objects> getCategoryList(String category, ArrayList<Objects> productsList) {
        ArrayList<Objects> categoryList = new ArrayList<>();
        if (productsList != null && !productsList.isEmpty()) {
            for (Objects product : productsList) {
                if (product.getCategory().equals(category)) {
                    categoryList.add(product);
                }
            }
        }
        return categoryList;
    }
}
