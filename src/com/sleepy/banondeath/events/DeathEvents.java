package com.sleepy.banondeath.events;

import com.sleepy.banondeath.BanOnDeath;
import java.time.Instant;
import java.util.Date;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvents implements Listener {
        
    private final BanOnDeath pl;
    public DeathEvents(BanOnDeath plugin) {
        this.pl = plugin;
    }
        @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player p = (Player) event.getEntity();
        Bukkit.getBanList(BanList.Type.NAME).addBan(p.getDisplayName(), pl.getConfig().getString("BanReason"), Date.from(Instant.now().plusSeconds(pl.getConfig().getInt("BanTimer"))), null);
        p.kickPlayer(pl.getConfig().getString("BanKickReason"));
        }
    
}
