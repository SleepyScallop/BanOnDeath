package com.sleepy.banondeath;
 
import com.sleepy.banondeath.events.DeathEvents;
import java.io.File;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
 
public class BanOnDeath extends JavaPlugin implements Listener {
 
    DeathEvents deathEvents = new DeathEvents(this);
    public final File configFile = new File(getDataFolder().getPath() + "/config.yml");
    
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(deathEvents, this);
        
        if (!new File(getDataFolder().getPath() + "/config").exists()) {
            saveDefaultConfig();
            reloadConfig();
        }
    }
}