/*
 * Copyright (C) 2012 ${authorName} <${authorEmail}>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ${package};

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ${artifactId} extends JavaPlugin {
    private static final Logger log = Logger.getLogger("Minecraft.${artifactId}");
        
    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();

        CommandExecutor commandExecutor = new ${artifactId}CommandExecutor(this);
        getCommand("${commandPrefix}help").setExecutor(commandExecutor);
        
        startup();

        log.info(this + " is now enabled");
    }

    @Override
    public void onDisable() {
        shutdown();

        log.info(this + " is now disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    private void startup() {
        Configuration config = getConfig();
        if (config.getKeys(true).isEmpty()) {
            config.options().copyDefaults(true);
        }
    }

    private void shutdown() {
        saveConfig();
    }
}
