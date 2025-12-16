package org.example.ROKRewards.werseRokRewards.Challanges;

import org.bukkit.entity.Player;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.example.ROKRewards.werseRokRewards.RewardMap;
import org.example.ROKRewards.werseRokRewards.WerseRokRewards;

public class Enchant {

    private final WerseRokRewards plugin;
    private final RewardMap rewardMap;

    public Enchant(WerseRokRewards plugin) {
        this.plugin = plugin;
        this.rewardMap = plugin.getRewardMap();
    }

    public void handleEnchant(EnchantItemEvent event) {

        Player player = event.getEnchanter();
        String uuid = player.getUniqueId().toString();
        if (canAddPoints(uuid)) {
            rewardMap.addPointsEnchantItems(uuid,1);
            int maxScore = plugin.getConfigurationFileConverter().getEnchants();
            int accualScore = rewardMap.getPointsEnchantItems(uuid);
            plugin.getProgressBar().updateProgressBar(player,accualScore,maxScore, "Zaklinanie");

            if (accualScore == maxScore) {
                plugin.getProgressBar().rewardCompliteDaylieQuests(player, "Zaklinanie");
            }
        }
    }

    private boolean canAddPoints(String UUID) {
        if (rewardMap.getPointsEnchantItems(UUID) >= plugin.getConfigurationFileConverter().getEnchants()) {
            return false;
        } else {
            return true;
        }
    }
}
