package net.siriuser.srlm;

import java.io.IOException;
import java.util.logging.Logger;

import net.syamn.utils.Metrics;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SRLM extends JavaPlugin {
    
    public final static Logger log = Logger.getLogger("Minecraft");
    public final static String logPrefix = "[SRLM] ";

    @Override
    public void onEnable() {

        // イベントリスナー登録
        PluginManager pm = getServer().getPluginManager();

        setupMetrics();

        PluginDescriptionFile pdfFile = this.getDescription();
        log.info("[" + pdfFile.getName() + "] version " + pdfFile.getVersion() + " is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks(this);

        PluginDescriptionFile pdfFile = this.getDescription();
        log.info("[" + pdfFile.getName() + "] version " + pdfFile.getVersion() + "is disabled!");
    }
    
    /**
     * @author syamn
     * GPL v3
     */
    private void setupMetrics() {
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            log.warning(logPrefix);
        }
    }
}
