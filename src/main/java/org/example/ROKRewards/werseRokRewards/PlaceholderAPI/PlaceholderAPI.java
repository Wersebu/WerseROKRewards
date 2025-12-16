package org.example.ROKRewards.werseRokRewards.PlaceholderAPI;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.example.ROKRewards.werseRokRewards.WerseRokRewards;
import org.jetbrains.annotations.NotNull;

public class PlaceholderAPI extends PlaceholderExpansion {

    private final WerseRokRewards plugin;

    public PlaceholderAPI(WerseRokRewards plugin) {
        this.plugin = plugin;
    }


    @Override
    public @NotNull String getIdentifier() {
        return "werse-rok-rewards";
    }

    @Override
    public @NotNull String getAuthor() {
        return "xxWersebuxx";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        String uuid = player.getUniqueId().toString();
        return switch (params) {
            case "mining" -> String.valueOf(plugin.getRewardMap().getPointsBraked(uuid));
            case "killing" -> String.valueOf(plugin.getRewardMap().getPointsMobsKiled(uuid));
            case "trading" -> String.valueOf(plugin.getRewardMap().getPointsVillagerTrades(uuid));
            case "crafting" -> String.valueOf(plugin.getRewardMap().getPointsCraftItems(uuid));
            case "enchants" -> String.valueOf(plugin.getRewardMap().getPointsEnchantItems(uuid));
            case "breads" -> String.valueOf(plugin.getRewardMap().getPointsBreadAnimals(uuid));
            default -> null;
        };
    }
}
