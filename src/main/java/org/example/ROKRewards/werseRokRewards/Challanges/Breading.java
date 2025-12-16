package org.example.ROKRewards.werseRokRewards.Challanges;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityBreedEvent;
import org.example.ROKRewards.werseRokRewards.RewardMap;
import org.example.ROKRewards.werseRokRewards.WerseRokRewards;

public class Breading {

    private final WerseRokRewards plugin;
    private final RewardMap rewardMap;

    public Breading(WerseRokRewards plugin) {
        this.plugin = plugin;
        this.rewardMap = plugin.getRewardMap();
    }

    public void handleBreading(EntityBreedEvent event) {

        plugin.getLogger().info("[BREED] fired: entity=" + event.getEntity().getType()
                + " breeder=" + (event.getBreeder() == null ? "null" : event.getBreeder().getType()));

        if (!(event.getBreeder() instanceof Player player)) {
            plugin.getLogger().info("[BREED] breeder is not a player -> ignored");
        }

        LivingEntity livingEntity = event.getBreeder();

        if (livingEntity instanceof Player) {
            Player player = (Player) livingEntity;
            String uuid = player.getUniqueId().toString();

            if (canAddPoints(uuid)) {
                rewardMap.addPointsBreadAnimals(uuid,1);
                plugin.getLogger().info("[BREED] added points to " + player.getName());
                int maxScore = plugin.getConfigurationFileConverter().getBreed();
                int accualScore = rewardMap.getPointsBreadAnimals(uuid);
                plugin.getProgressBar().updateProgressBar(player,accualScore,maxScore, "Rozmnażanie");

                if (accualScore == maxScore) {
                    plugin.getProgressBar().rewardCompliteDaylieQuests(player, "Rozmnażanie");
                }
            } else {
                plugin.getLogger().info("[BREED] limit reached -> ignored");
            }
        }
    }

    private boolean canAddPoints(String UUID) {
        if (rewardMap.getPointsBreadAnimals(UUID) >= plugin.getConfigurationFileConverter().getBreed()) {
            return false;
        } else {
            return true;
        }
    }

}
