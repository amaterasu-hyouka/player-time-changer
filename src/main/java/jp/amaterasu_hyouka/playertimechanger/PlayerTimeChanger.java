package jp.amaterasu_hyouka.playertimechanger;

import jp.amaterasu_hyouka.playertimechanger.core.AbstractCustomInventoryClick;
import jp.amaterasu_hyouka.playertimechanger.core.CustomItemClickListener;
import jp.amaterasu_hyouka.playertimechanger.core.InventoryItem;
import jp.amaterasu_hyouka.playertimechanger.listener.ItemClickListener;
import jp.amaterasu_hyouka.playertimechanger.utils.ItemUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PlayerTimeChanger extends AbstractCustomInventoryClick implements CustomItemClickListener {
    private final Inventory inventory = Bukkit.createInventory(this, 9, Component.text("Time Select"));
    public PlayerTimeChanger(){
        setAllElement(inventory, Element.class);
        registerAllAction();

        ItemStack noneItem = ItemUtils.createItem(Material.IRON_CHAIN, 1);
        inventory.setItem(0, noneItem);
        inventory.setItem(6, noneItem);

        ItemClickListener.getInstance().register(Material.CLOCK, this);
    }
    private enum Element implements InventoryItem {
        SUNRISE(1, ItemUtils.createItem(Material.WHITE_CONCRETE, 1,  "朝焼け", NamedTextColor.WHITE)),
        MORNING(2, ItemUtils.createItem(Material.PINK_CONCRETE, 1, "朝", NamedTextColor.WHITE)),
        NOON(3, ItemUtils.createItem(Material.YELLOW_CONCRETE, 1, "昼", NamedTextColor.WHITE)),
        EVENING(4, ItemUtils.createItem(Material.ORANGE_CONCRETE, 1, "夕方", NamedTextColor.WHITE)),
        NIGHT(5, ItemUtils.createItem(Material.BLACK_CONCRETE, 1, "夜", NamedTextColor.WHITE)),

        RESET(7, ItemUtils.createItem(Material.GRASS_BLOCK, 1, "デフォルトに戻す", NamedTextColor.WHITE)),
        CLOSE(8, ItemUtils.createItem(Material.BARRIER, 1, "閉じる", NamedTextColor.WHITE));
        final int slot;
        final ItemStack item;
        Element(int slot, ItemStack item){
            this.slot = slot;
            this.item = item;
        }
        @Override public int getSlot(){return slot;}
        @Override public ItemStack getItem(){return item;}
    }

    @Override
    protected void registerAllAction() {
        registerAction(Element.SUNRISE, p -> p.setPlayerTime(23000, false)); // 朝焼け
        registerAction(Element.MORNING, p -> p.setPlayerTime(0, false));     // 朝
        registerAction(Element.NOON, p -> p.setPlayerTime(6000, false));     // 昼
        registerAction(Element.EVENING, p -> p.setPlayerTime(12000, false)); // 夕方
        registerAction(Element.NIGHT, p -> p.setPlayerTime(18000, false));   // 夜
        registerAction(Element.RESET, Player::resetPlayerTime);                    // デフォルト
        registerAction(Element.CLOSE, Player::closeInventory);
    }

    @Override
    public @NotNull Inventory getInventory(){
        return inventory;
    }
    @Override
    public void setInventory(Player p){
        p.openInventory(inventory);
    }

    @Override
    public void handleItemClickEvent(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            this.setInventory(p);
        }
    }
}
