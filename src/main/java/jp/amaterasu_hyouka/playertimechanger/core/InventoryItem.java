package jp.amaterasu_hyouka.playertimechanger.core;

import org.bukkit.inventory.ItemStack;

public interface InventoryItem {
    int getSlot();
    ItemStack getItem();
}