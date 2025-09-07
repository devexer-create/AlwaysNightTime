package com.normalsmp.alwaysNightTime;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class AlwaysNightTime extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("AlwaysNightTime plugin enabled!");

        // Task repeats every 100 ticks (5 seconds)
        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : Bukkit.getWorlds()) {
                    world.setTime(20000); // Reset to morning
                    world.setStorm(false); // Clear weather
                    world.setThundering(false);
                }
            }
        }.runTaskTimer(this, 0L, 100L);
    }

    @Override
    public void onDisable() {
        getLogger().info("AlwaysNightTime plugin disabled!");
    }
}
