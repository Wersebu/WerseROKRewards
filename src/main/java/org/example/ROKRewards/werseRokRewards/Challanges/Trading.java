package org.example.ROKRewards.werseRokRewards.Challanges;

import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.entity.Player;
import org.example.ROKRewards.werseRokRewards.RewardMap;
import org.example.ROKRewards.werseRokRewards.WerseRokRewards;

public class Trading {

    private final WerseRokRewards plugin;
    private final RewardMap rewardMap;

    public Trading(WerseRokRewards plugin) {
        this.plugin = plugin;
        this.rewardMap = plugin.getRewardMap();
    }

    public void handleTrade(PlayerTradeEvent event) {

        Player player = event.getPlayer();
        if (event.isCancelled()) {return;}

        String uuid = player.getUniqueId().toString();

        if (canAddPoints(uuid)) {
            int actualScore = rewardMap.getPointsVillagerTrades(uuid) + 1;
            int maxScore = plugin.getConfigurationFileConverter().getTrades();
            rewardMap.addPointsVillagerTrades(uuid, 1);
            plugin.getProgressBar().updateProgressBar(player,actualScore,maxScore,"Trade");

            if (actualScore == maxScore) {
                plugin.getProgressBar().rewardCompliteDaylieQuests(player,"Handel");
            }
        }
    }

    private boolean canAddPoints(String UUID) {
        if (rewardMap.getPointsVillagerTrades(UUID) >= plugin.getConfigurationFileConverter().getTrades()) {
            return false;
        } else {
            return true;
        }
    }
}
