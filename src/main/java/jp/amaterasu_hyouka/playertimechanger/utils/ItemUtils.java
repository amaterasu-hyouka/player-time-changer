package jp.amaterasu_hyouka.playertimechanger.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {

    public static ItemStack createItem(final Material material, final int amount) {
        final ItemStack item = new ItemStack(material, amount);
        final ItemMeta meta = item.getItemMeta();

        meta.itemName(Component.empty());

        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack createItem(final Material material, final int amount, final String name, final TextColor color) {
        final ItemStack item = new ItemStack(material, amount);
        final ItemMeta meta = item.getItemMeta();

        if (name != null && !name.isEmpty()) {
            meta.displayName(Component.text(name, color).decoration(TextDecoration.ITALIC, false));
        }

        item.setItemMeta(meta);
        return item;
    }
}
