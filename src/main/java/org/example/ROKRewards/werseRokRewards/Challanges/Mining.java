package org.example.ROKRewards.werseRokRewards.Challanges;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.example.ROKRewards.werseRokRewards.ProgressBar;
import org.example.ROKRewards.werseRokRewards.RewardMap;
import org.example.ROKRewards.werseRokRewards.WerseRokRewards;

import java.util.List;

public class Mining {

    private final WerseRokRewards plugin;
    private final RewardMap rewardMap;
    private List<Material> acceptedMaterials;

    public Mining(WerseRokRewards plugin) {
        this.plugin = plugin;
        this.rewardMap = plugin.getRewardMap();
    }

    public void handleMining(BlockBreakEvent event) {
        if (canAddPoints(event.getPlayer().getUniqueId().toString())) {
            loadAcceptedMaterials();

            Material material = event.getBlock().getType();

            if (material.isBlock()) {
                Block block = event.getBlock();
                if (acceptedMaterials.contains(block.getType())) {
                    Player player = event.getPlayer();
                    String UUID = player.getUniqueId().toString();

                    int playerNewScore = rewardMap.getPointsBraked(UUID) + 1;
                    rewardMap.addPointsBraked(UUID, 1);

                    plugin.getProgressBar().updateProgressBar(player,playerNewScore, plugin.getConfigurationFileConverter().getMining(), "Mining");


                    if (playerNewScore == plugin.getConfigurationFileConverter().getMining()) {
                        plugin.getProgressBar().rewardCompliteDaylieQuests(player, "Górnictwo");
                    }
                }
            }
        }
    }

    private boolean canAddPoints(String UUID) {
        if (plugin.getRewardMap().getPointsBraked(UUID) >= plugin.getConfigurationFileConverter().getMining()) {
            return false;
        } else {
            return true;
        }
    }

    private void loadAcceptedMaterials() {
        acceptedMaterials = plugin.getConfigurationFileConverter().getAcceptedMaterials();
    }
}
