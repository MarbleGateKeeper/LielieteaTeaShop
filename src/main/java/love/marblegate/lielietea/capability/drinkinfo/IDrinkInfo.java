package love.marblegate.lielietea.capability.drinkinfo;

import love.marblegate.lielietea.datastructure.enumeration.IngredientFeature;
import love.marblegate.lielietea.datastructure.IngredientInfo;

import java.util.List;

public interface IDrinkInfo {
    public List<IngredientInfo> getIngredients();

    public void setIngredients(List<IngredientInfo> ingredients);

    public List<IngredientFeature> getFeatures();

    public void setFeatures(List<IngredientFeature> features);

    public int getFoodlevel();

    public void setFoodlevel(int foodlevel);

    public int getRemaining();

    public void setRemaining(int remaining);
}
