package love.marblegate.lielietea.capability.plantinfo;

import love.marblegate.lielietea.util.datastructure.IngredientFeature;
import love.marblegate.lielietea.util.datastructure.IngredientInfo;
import love.marblegate.lielietea.util.datastructure.PlantInfo;

import java.util.List;

public interface IUniversalPlantInfo {

    public PlantInfo getPlant();

    public void setPlant(PlantInfo plant);

    public List<IngredientFeature> getFeatures();

    public void setFeatures(List<IngredientFeature> features);
}
