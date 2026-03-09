package jp.amaterasu_hyouka.playertimechanger;

import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerTimeChanger extends JavaPlugin {

    private static PlayerTimeChanger instance;
    public static JavaPlugin getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        Log.info("PlayerTimeChangerを起動しました");
    }

    @Override
    public void onDisable() {
        Log.info("PlayerTimeChangerを停止しました");
    }
}
