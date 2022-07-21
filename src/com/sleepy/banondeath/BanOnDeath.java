package com.sleepy.banondeath;
 
import com.sleepy.banondeath.events.DeathEvents;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
 
public class BanOnDeath extends JavaPlugin implements Listener {
 
    DeathEvents deathEvents = new DeathEvents(this);
    
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(deathEvents, this);
    }
}