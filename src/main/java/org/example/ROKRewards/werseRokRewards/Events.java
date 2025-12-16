package org.example.ROKRewards.werseRokRewards;

import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.example.ROKRewards.werseRokRewards.Challanges.*;

public class Events implements Listener {

    private final Mining mining;
    private final Killing killing;
    private final Trading trading;
    private final Crafting crafting;
    private final Enchant enchant;
    private final Breading breading;

    public Events(WerseRokRewards plugin) {
        this.mining = new Mining(plugin);
        this.killing = new Killing(plugin);
        this.trading = new Trading(plugin);
        this.crafting = new Crafting(plugin);
        this.enchant = new Enchant(plugin);
        this.breading = new Breading(plugin);
    }

    @EventHandler
    public void onMine(BlockBreakEvent event) {
        mining.handleMining(event);
    }

    @EventHandler
    public void onKill(EntityDeathEvent event) {
        killing.handleKill(event);
    }

    @EventHandler
    public void onTrade(PlayerTradeEvent event) {
        trading.handleTrade(event);
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        crafting.handleCraftings(event);
    }

    @EventHandler
    public void onEnchant(EnchantItemEvent event) {
        enchant.handleEnchant(event);
    }

    @EventHandler
    public void onBread(EntityBreedEvent event) {
        breading.handleBreading(event);
    }

    @EventHandler
    public void onFireworkDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Firework firework)) return;
        if (!(event.getEntity() instanceof Player)) return;

        // tylko nasze fajerwerki questowe
        if (!firework.hasMetadata("rok_daily_fw")) return;

        event.setCancelled(true);
    }
}
