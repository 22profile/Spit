package me.skovorodka232.spit.spit;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spit extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Spit is enabled");
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        System.out.println("Spit is disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("spit")){
            if(sender instanceof Player){
                Player игрок = (Player) sender;

                Location loc = игрок.getLocation().toVector().add(игрок.getLocation().getDirection().multiply(0.8D)).toLocation(игрок.getWorld()).add(0.0D, 1.0D, 0.0D);
                Entity харчок = игрок.getWorld().spawnEntity(loc, EntityType.LLAMA_SPIT);
                харчок.setVelocity(игрок.getEyeLocation().getDirection().multiply(1));

                if(this.getConfig().getBoolean("superSpit") == true){

                    Location лок = игрок.getLocation().toVector().add(игрок.getLocation().getDirection().multiply(0.8D)).toLocation(игрок.getWorld()).add(0.0D, 1.0D, 0.0D);
                    Entity суперХарчок = игрок.getWorld().spawnEntity(лок, EntityType.LLAMA_SPIT);
                    Entity суперХарчок2 = игрок.getWorld().spawnEntity(лок, EntityType.LLAMA_SPIT);
                    суперХарчок.setVelocity(игрок.getEyeLocation().getDirection().multiply(1));
                    суперХарчок2.setVelocity(игрок.getEyeLocation().getDirection().multiply(1));
                    игрок.spawnParticle(Particle.FLAME, лок, 2);

                }

            }else if(sender instanceof ConsoleCommandSender){
                System.out.println("Команда только для игроков");
            }
        }


        return true;
    }
}
