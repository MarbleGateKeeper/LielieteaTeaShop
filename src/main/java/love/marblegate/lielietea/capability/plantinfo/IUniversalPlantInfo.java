package love.marblegate.lielietea.capability.plantinfo;

import love.marblegate.lielietea.datastructure.enumeration.IngredientFeature;
import love.marblegate.lielietea.datastructure.PlantInfo;

import java.util.List;

public interface IUniversalPlantInfo {

    public PlantInfo getPlant();

    public void setPlant(PlantInfo plant);

    public List<IngredientFeature> getFeatures();

    public void setFeatures(List<IngredientFeature> features);
}
