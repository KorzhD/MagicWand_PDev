package org.example.dmytrok.dk_magicwand_plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.example.dmytrok.dk_magicwand_plugin.events.magicwandevents.MagicWandEvent;
import org.example.dmytrok.dk_magicwand_plugin.commands.MagicWandCommand;


public final class DK_MagicWand_Plugin extends JavaPlugin {


    @Override
    public void onEnable() {
        getLogger().info("MagicWand plugin enabled");

        getServer().getPluginManager().registerEvents(new MagicWandEvent(), this);

        if(getCommand("getMagicWand") != null) {
            getCommand("getMagicWand").setExecutor(new MagicWandCommand());
        } else {
            getLogger().info("Something WRONG");
        }

    }

    @Override
    public void onDisable() {
        getLogger().info("MagicWand plugin disabled");
    }

}
