package org.example.ROKRewards.werseRokRewards.Challanges;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.example.ROKRewards.werseRokRewards.RewardMap;
import org.example.ROKRewards.werseRokRewards.WerseRokRewards;

public class Crafting {
    private final WerseRokRewards plugin;
    private final RewardMap rewardMap;

    public Crafting(WerseRokRewards plugin) {
        this.plugin = plugin;
        this.rewardMap = plugin.getRewardMap();
    }

    public void handleCraftings(CraftItemEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;
        CraftingInventory inventory = event.getInventory();
        ItemStack item = event.getCurrentItem();

        if (item == null || item.getType().isAir()) return;
        String uuid = player.getUniqueId().toString();

        if (canAddPoints(uuid)) {
            int actualScore = rewardMap.getPointsVillagerTrades(uuid);
            int maxScore = plugin.getConfigurationFileConverter().getCrafts();

            rewardMap.addPointsCraftItems(uuid, 1);
            plugin.getProgressBar().updateProgressBar(player,actualScore,maxScore,"crafting");

            if (actualScore == maxScore) {
                plugin.getProgressBar().rewardCompliteDaylieQuests(player, "Crafter");
            }
        }
    }

    private boolean canAddPoints(String UUID) {
        if (rewardMap.getPointsCraftItems(UUID) >= plugin.getConfigurationFileConverter().getCrafts()) {
            return false;
        } else {
            return true;
        }
    }
}
