package org.example.ROKRewards.werseRokRewards;

import java.util.HashMap;

public class RewardMap {

    private final HashMap<String,Integer> globalPoints = new HashMap();
    private final HashMap<String,Integer> blocksBraked = new HashMap();
    private final HashMap<String,Integer> mobsKilled = new HashMap();
    private final HashMap<String,Integer> villagerTrades = new HashMap();
    private final HashMap<String,Integer> craftItems = new HashMap();
    private final HashMap<String,Integer> enchantItems = new HashMap();
    private final HashMap<String,Integer> breadAnimals = new HashMap();

    //GLOBAL POINTS
    public Integer getPointsglobalPoints(String uuid) {
        return globalPoints.getOrDefault(uuid, 0);
    }

    public void addPointsglobalPoints(String uuid, Integer points) {
        globalPoints.put(uuid,getPointsglobalPoints(uuid) + points);
    }

    //MINING POINTS
    public Integer getPointsBraked(String uuid) {
        return blocksBraked.getOrDefault(uuid,0);
    }

    public void addPointsBraked(String uuid, Integer points) {
        blocksBraked.put(uuid,getPointsBraked(uuid) + points);
    }

    //HUNTING POINTS
    public Integer getPointsMobsKiled(String uuid) {
        return mobsKilled.getOrDefault(uuid,0);
    }

    public void addPointsMobsKiled(String uuid, Integer points) {
        mobsKilled.put(uuid,getPointsMobsKiled(uuid) + points);
    }

    //TRADES POINTS
    public Integer getPointsVillagerTrades(String uuid) {
        return villagerTrades.getOrDefault(uuid,0);
    }

    public void addPointsVillagerTrades(String uuid, Integer points) {
        villagerTrades.put(uuid,getPointsVillagerTrades(uuid) + points);
    }

    //CRAFT POINTS
    public Integer getPointsCraftItems(String uuid) {
        return craftItems.getOrDefault(uuid,0);
    }
    public void addPointsCraftItems(String uuid, Integer points) {
        craftItems.put(uuid,getPointsCraftItems(uuid) + points);
    }

    //ENCHANT POINTS
    public Integer getPointsEnchantItems(String uuid) {
        return enchantItems.getOrDefault(uuid,0);
    }
    public void addPointsEnchantItems(String uuid, Integer points) {
        enchantItems.put(uuid,getPointsEnchantItems(uuid) + points);
    }

    //BREAD POINTS
    public Integer getPointsBreadAnimals(String uuid) {
        return breadAnimals.getOrDefault(uuid, 0);
    }

    public void addPointsBreadAnimals(String uuid, Integer points) {
        breadAnimals.put(uuid,getPointsBreadAnimals(uuid) + points);
    }
}
