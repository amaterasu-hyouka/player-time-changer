package jp.amaterasu_hyouka.playertimechanger.listener;

import jp.amaterasu_hyouka.playertimechanger.core.CustomItemClickListener;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class ItemClickListener implements Listener {

    private static final ItemClickListener itemClickListener = new ItemClickListener();
    private ItemClickListener(){}
    public static ItemClickListener getInstance(){return itemClickListener;}

    private final Map<Material, CustomItemClickListener> materialToCustomItemClickListener = new HashMap<>();

    public void register(Material material, CustomItemClickListener listener){
        materialToCustomItemClickListener.put(material, listener);
    }

    @EventHandler
    public void handleItemClickEvent(PlayerInteractEvent e){
        ItemStack item = e.getItem();
        if(item == null)return;
        CustomItemClickListener listener = materialToCustomItemClickListener.get(item.getType());
        if(listener == null)return;
        e.setCancelled(true);
        listener.handleItemClickEvent(e);
    }
}
