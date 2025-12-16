package org.example.ROKRewards.werseRokRewards;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.ROKRewards.werseRokRewards.Config.ConfigurationFileConverter;
import org.example.ROKRewards.werseRokRewards.PlaceholderAPI.PlaceholderAPI;

public final class WerseRokRewards extends JavaPlugin {

    private RewardMap rewardMap;
    private ConfigurationFileConverter configurationFileConverter;
    private ProgressBar progressBar;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        rewardMap = new RewardMap();
        configurationFileConverter = new ConfigurationFileConverter();
        progressBar = new ProgressBar(this);
        configurationFileConverter.loadConfigurationFile(this);
        Bukkit.getPluginManager().registerEvents(new Events(this), this);

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) { //
            new PlaceholderAPI(this).register();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public RewardMap getRewardMap() {
        return rewardMap;
    }

    public ConfigurationFileConverter getConfigurationFileConverter() {
        return configurationFileConverter;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

}
