package org.example.dmytrok.dk_magicwand_plugin.events.magicwandevents;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MagicWandEvent implements Listener {

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }

        ItemStack itemStack = player.getInventory().getItemInMainHand();


        if (itemStack.getType() != Material.WOOD_AXE || !itemStack.hasItemMeta()) {
            return;
        }

        ItemMeta meta = itemStack.getItemMeta();

        if (meta == null || !meta.hasDisplayName() || !meta.getDisplayName().equals("Magic Wand")) {
            return;
        }


        World world = player.getWorld();

        if (player.getInventory().getItemInOffHand().equals(new ItemStack(Material.TNT))) {
            player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
            world.createExplosion(player.getLocation(), 10F, false);
            player.sendMessage("§cBoom boom bakudan!");
        }

        if (player.getInventory().getItemInOffHand().equals(new ItemStack(Material.WHEAT))) {
            player.getInventory().getItemInOffHand().setAmount(player.getInventory().getItemInOffHand().getAmount() - 1);
            Chunk currChunk = world.getChunkAt(player.getLocation());
            long players = Arrays.stream(currChunk.getEntities()).filter(entity -> entity instanceof Player).count();
            if (players == 1) {
                player.sendMessage("There are " + players + " player in this chunk");
            } else {
                player.sendMessage("There are " + players + " players in this chunk");
            }
        }

        if(player.getInventory().getItemInOffHand().equals(new ItemStack(Material.NETHER_STAR))) {
            world.spawnEntity(player.getLocation().add(2, 2, 2), EntityType.WITHER_SKULL);
        }

        if(player.getInventory().getItemInOffHand().equals(new ItemStack(Material.BOOK))) {
            world.spawnEntity(player.getLocation().add(2,0,0), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(3,0,0), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(4,0,0), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(-2,0,0), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(-3,0,0), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(-4,0,0), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(0,0,2), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(0,0,3), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(0,0,4), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(0,0,-2), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(0,0,-3), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(0,0,-4), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(4,0,4), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(-4,0,-4), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(-4,0,4), EntityType.EVOKER_FANGS);
            world.spawnEntity(player.getLocation().add(4,0,-4), EntityType.EVOKER_FANGS);
        }

    }
}
