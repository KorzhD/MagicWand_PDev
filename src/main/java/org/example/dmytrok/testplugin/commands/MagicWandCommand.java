package org.example.dmytrok.testplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.example.dmytrok.testplugin.itemcreator.MagicWandCreator;

public class MagicWandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You must be a player");
            return false;
        }

        Player player = (Player) commandSender;

        if(!(player.hasPermission("getMagicWand.admin"))) {
            commandSender.sendMessage("You must be an admin");
            return false;
        }

        ItemStack itemStack = MagicWandCreator.createItem();

        player.getInventory().addItem(itemStack);
        player.sendMessage("§5Your hands are fully of magic power..!");

        return true;
    }
}
