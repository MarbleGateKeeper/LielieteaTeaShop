package love.marblegate.lielietea.capability.drinkinfo;

import love.marblegate.lielietea.util.datastructure.IngredientFeature;
import love.marblegate.lielietea.util.datastructure.IngredientInfo;

import java.util.ArrayList;
import java.util.List;

public class DrinkInfoStandardImpl implements IDrinkInfo{
    //Ingredient List
    List<IngredientInfo> ingredients;
    //Special Feature List
    List<IngredientFeature> features;
    //Food Level
    int foodlevel;
    //Remaining Drink
    int remaining;

    public DrinkInfoStandardImpl() {
        this.ingredients = new ArrayList<>();
        this.features = new ArrayList<>();
        this.foodlevel = 1;
        this.remaining = 500;
    }

    public List<IngredientInfo> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientInfo> ingredients) {
        this.ingredients = ingredients;
    }

    public List<IngredientFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<IngredientFeature> features) {
        this.features = features;
    }

    public int getFoodlevel() {
        return foodlevel;
    }

    public void setFoodlevel(int foodlevel) {
        this.foodlevel = foodlevel;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
