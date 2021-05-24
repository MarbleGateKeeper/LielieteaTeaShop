package love.marblegate.lielietea.capability.plantinfo;

import love.marblegate.lielietea.datastructure.enumeration.IngredientFeature;
import love.marblegate.lielietea.datastructure.PlantInfo;

import java.util.ArrayList;
import java.util.List;

public class UniversalPlantInfoStandardImpl implements IUniversalPlantInfo {
    PlantInfo plant;
    List<IngredientFeature> features;

    public UniversalPlantInfoStandardImpl() {
        this.plant = new PlantInfo();
        this.features = new ArrayList<>();
    }

    public PlantInfo getPlant() {
        return plant;
    }

    public void setPlant(PlantInfo plant) {
        this.plant = plant;
    }

    public List<IngredientFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<IngredientFeature> features) {
        this.features = features;
    }
}
