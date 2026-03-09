package jp.amaterasu_hyouka.playertimechanger.core;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.*;
import java.util.function.Consumer;

public abstract class AbstractCustomInventoryClick implements CustomInventoryClickListener {
    protected final Map<Integer, Map<Material, Consumer<Player>>> actionMap = new HashMap<>();
    protected <E extends Enum<E> & InventoryItem> void setAllElement(Inventory inventory, Class<E> elementClass){
        for(E element: elementClass.getEnumConstants())inventory.setItem(element.getSlot(), element.getItem());
    }

    protected abstract void registerAllAction();
    protected <E extends Enum<E> & InventoryItem> void registerAction(E element, Consumer<Player> action){
        actionMap.computeIfAbsent(element.getSlot(), k -> new HashMap<>()).put(element.getItem().getType(), action);
    }

    protected Consumer<Player> getAction(int slot, Material material){
        Map<Material, Consumer<Player>> slotActions = actionMap.get(slot);
        return slotActions != null ? slotActions.get(material) : null;
    }

    @Override
    public void handle(InventoryClickEvent e){
        Consumer<Player> action = getAction(e.getRawSlot(), Objects.requireNonNull(e.getCurrentItem()).getType());
        if(action != null)action.accept((Player)e.getWhoClicked());
    }

    public abstract void setInventory(Player p);
}
