package org.example.ROKRewards.werseRokRewards.Config;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConfigurationFileConverter {

    private int mining;
    private int killing;
    private int trades;
    private int crafts;
    private int enchants;
    private int breed;
    private List<Material> acceptedMaterials;

    public void loadConfigurationFile(JavaPlugin plugin) {
        FileConfiguration config = plugin.getConfig();

        mining = config.getInt("mining.amount");
        killing = config.getInt("killing");
        trades = config.getInt("trades");
        crafts = config.getInt("craft");
        enchants = config.getInt("enchant");
        breed = config.getInt("breed");

        acceptedMaterials = new ArrayList<>();

        // pobieramy listę STRINGÓW, nie Objectów
        List<String> allowed = config.getStringList("mining.allowed");

        if (allowed == null || allowed.isEmpty()) {
            plugin.getLogger().warning("[WerseROKRewards]: mining.allowed list is empty");
            return;
        }

        for (String name : allowed) {
            if (name == null) continue;

            // na wszelki wypadek uppercase
            String normalized = name.toUpperCase(Locale.ROOT);

            Material material = Material.matchMaterial(normalized);
            if (material != null) {
                acceptedMaterials.add(material);
            } else {
                plugin.getLogger().warning("[WerseROKRewards]: " + name + " is not a valid material");
            }
        }

        plugin.getLogger().info("[WerseROKRewards]: Loaded " + acceptedMaterials.size() + " allowed materials for mining.");
    }

    public int getMining() {
        return mining;
    }

    public int getKilling() {
        return killing;
    }

    public int getTrades() {
        return trades;
    }

    public int getCrafts() {
        return crafts;
    }

    public int getEnchants() {
        return enchants;
    }

    public int getBreed() {
        return breed;
    }

    public List<Material> getAcceptedMaterials() {
        return acceptedMaterials;
    }
}
