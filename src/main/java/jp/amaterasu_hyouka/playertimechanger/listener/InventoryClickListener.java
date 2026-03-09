package jp.amaterasu_hyouka.playertimechanger.listener;

import jp.amaterasu_hyouka.playertimechanger.core.CustomInventoryClickListener;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class InventoryClickListener implements Listener {

    private static final InventoryClickListener inventoryClickListener = new InventoryClickListener();
    private InventoryClickListener(){}
    public static InventoryClickListener getInstance(){return inventoryClickListener;}

    @EventHandler
    public void handle(InventoryClickEvent e){
        if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)return;

        Inventory clickedInventory = e.getClickedInventory();
        if(clickedInventory == null)return;

        Inventory topInventory = e.getView().getTopInventory();
        if(!clickedInventory.equals(topInventory))return;

        InventoryHolder holder = topInventory.getHolder();
        if (!(holder instanceof CustomInventoryClickListener listener)) return;

        e.setCancelled(true);
        listener.handle(e);
    }
}
