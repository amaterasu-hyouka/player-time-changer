package jp.amaterasu_hyouka.playertimechanger.core;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public interface CustomInventoryClickListener extends InventoryHolder {
    void handle(InventoryClickEvent e);
}
