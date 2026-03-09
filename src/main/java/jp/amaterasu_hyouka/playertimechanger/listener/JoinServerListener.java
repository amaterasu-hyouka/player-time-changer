package jp.amaterasu_hyouka.playertimechanger.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinServerListener implements Listener {

    private static final JoinServerListener joinServerListener = new JoinServerListener();
    private JoinServerListener(){}
    public static JoinServerListener getInstance(){return joinServerListener;}

    @EventHandler
    public void handle(PlayerJoinEvent e){
        e.getPlayer().resetPlayerTime();
    }
}
