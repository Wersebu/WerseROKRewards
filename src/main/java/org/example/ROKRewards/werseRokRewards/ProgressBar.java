package org.example.ROKRewards.werseRokRewards;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

public class ProgressBar {

    private final JavaPlugin plugin;

    public ProgressBar(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void updateProgressBar(Player player, int accualScore, int maxScore, String type) {
        switch (type) {
            case "Mining" -> player.sendActionBar("Górnik: " + accualScore + "/" + maxScore);
            case "Killing" -> player.sendActionBar("Zabijanie: " + accualScore + "/" + maxScore);
            case "Trade" -> player.sendActionBar("Handel: " + accualScore + "/" + maxScore);
            case "crafting" -> player.sendActionBar("Crafter: " + accualScore + "/" + maxScore);
            case "Zaklinanie" -> player.sendActionBar("Zaklinanie: " + accualScore + "/" + maxScore);
            case "Rozmnażanie" -> player.sendActionBar("Rozmnażanie: " + accualScore + "/" + maxScore);
        }
    }

    public void rewardCompliteDaylieQuests(Player player, String Type) {
        player.sendTitle(
                ChatColor.GOLD + "" + ChatColor.BOLD + "ZADANIE DZIENNE UKOŃCZONE!",
                Type,
                10, 60, 10
        );

        Location location = player.getLocation();
        World world = location.getWorld();



        player.playSound(location, Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0f, 1.0f);
        player.playSound(location, Sound.ENTITY_PLAYER_LEVELUP, 0.8f, 1.6f);

        for (double t = 0; t < Math.PI * 2; t += Math.PI / 10) {
            double x = Math.cos(t) * 1.5;
            double z = Math.sin(t) * 1.5;
            world.spawnParticle(
                    Particle.HAPPY_VILLAGER,
                    location.clone().add(x, 0.2, z),
                    4,
                    0, 0, 0, 0
            );
        }

        spawnQuestFirework(location.clone().add(0, 2, 0));
    }

    private void spawnQuestFirework(Location loc) {
        World world = loc.getWorld();
        if (world == null) return;

        Firework firework = (Firework) world.spawnEntity(loc, EntityType.FIREWORK_ROCKET);
        FireworkMeta meta = firework.getFireworkMeta();

        meta.clearEffects();
        meta.addEffect(FireworkEffect.builder()
                .with(FireworkEffect.Type.BALL_LARGE)
                .withColor(Color.AQUA, Color.LIME)
                .withFade(Color.FUCHSIA, Color.PURPLE)
                .flicker(true)
                .trail(true)
                .build()
        );
        meta.setPower(1);

        firework.setMetadata("rok_daily_fw", new FixedMetadataValue(plugin, true));

        firework.setFireworkMeta(meta);
    }

}
