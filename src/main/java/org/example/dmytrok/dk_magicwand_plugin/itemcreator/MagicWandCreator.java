package org.example.dmytrok.dk_magicwand_plugin.itemcreator;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.*;


public class MagicWandCreator {
    public static ItemStack createItem() {
        ItemStack magicWand = new ItemStack(Material.WOOD_AXE, 1);
        ItemMeta itemMeta = magicWand.getItemMeta();

        List<String> list = new ArrayList<>();
        list.add("§6The most powerful thing in the World!");

        if (itemMeta != null) {
            itemMeta.setDisplayName("Magic Wand");
            itemMeta.setLore(list);
            itemMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
            itemMeta.setUnbreakable(true);
            magicWand.setItemMeta(itemMeta);
        }
        return magicWand;

    }
    }
