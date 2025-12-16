package org.example.ROKRewards.werseRokRewards.Challanges;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.example.ROKRewards.werseRokRewards.RewardMap;
import org.example.ROKRewards.werseRokRewards.WerseRokRewards;

public class Killing {
    private final WerseRokRewards plugin;
    private final RewardMap rewardMap;

    public Killing(WerseRokRewards plugin) {
        this.plugin = plugin;
        this.rewardMap = plugin.getRewardMap();
    }

    public void handleKill(EntityDeathEvent event) {
        if (event.getEntity().getKiller() == null) return;

        if (event.getEntity().getKiller() instanceof Player) {
            Player player = (Player) event.getEntity().getKiller();
            String UUID = player.getUniqueId().toString();

            if (canAddPoints(UUID)) {
                int accualScore = rewardMap.getPointsMobsKiled(UUID) + 1;
                int maxScore = plugin.getConfigurationFileConverter().getKilling();

                rewardMap.addPointsMobsKiled(UUID,1);
                plugin.getProgressBar().updateProgressBar(player,accualScore,maxScore,"Killing");

                if (accualScore == maxScore) {
                    plugin.getProgressBar().rewardCompliteDaylieQuests(player, "Zabijanie");
                }
            }
        }
    }

    private boolean canAddPoints(String UUID) {
        if (plugin.getRewardMap().getPointsMobsKiled(UUID) >= plugin.getConfigurationFileConverter().getKilling()) {
            return false;
        } else {
            return true;
        }
    }
}
