package org.example.dmytrok.testplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.example.dmytrok.testplugin.events.magicwandevents.MagicWandEvent;
import org.example.dmytrok.testplugin.commands.MagicWandCommand;


public final class DK_MagicWand_Plugin extends JavaPlugin {


    @Override
    public void onEnable() {
        getLogger().info("MagicWand plugin enabled");

        getServer().getPluginManager().registerEvents(new MagicWandEvent(), this);

        if(getCommand("getSuperWand") != null) {
            getCommand("getSuperWand").setExecutor(new MagicWandCommand());
        } else {
            getLogger().info("Something WRONG");
        }

    }

    @Override
    public void onDisable() {
        getLogger().info("MagicWand plugin disabled");
    }

}
