package jp.amaterasu_hyouka.playertimechanger;

import jp.amaterasu_hyouka.playertimechanger.listener.InventoryClickListener;
import jp.amaterasu_hyouka.playertimechanger.listener.ItemClickListener;
import jp.amaterasu_hyouka.playertimechanger.listener.JoinServerListener;
import jp.amaterasu_hyouka.playertimechanger.utils.Log;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerTimeChangerPlugin extends JavaPlugin {

    private static PlayerTimeChangerPlugin instance;
    public static JavaPlugin getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        Log.info("PlayerTimeChangerを起動中...");

        Bukkit.getServer().getPluginManager().registerEvents(InventoryClickListener.getInstance(), this);
        Bukkit.getServer().getPluginManager().registerEvents(ItemClickListener.getInstance(), this);
        Bukkit.getServer().getPluginManager().registerEvents(JoinServerListener.getInstance(), this);
        new PlayerTimeChanger();

        Log.info("PlayerTimeChangerを起動しました");
    }

    @Override
    public void onDisable() {
        Log.info("PlayerTimeChangerを停止中...");
        Log.info("PlayerTimeChangerを停止しました");
    }
}
