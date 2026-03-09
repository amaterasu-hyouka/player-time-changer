package jp.amaterasu_hyouka.playertimechanger.core;

import org.bukkit.event.player.PlayerInteractEvent;

public interface CustomItemClickListener {
    void handleItemClickEvent(PlayerInteractEvent e);
}
