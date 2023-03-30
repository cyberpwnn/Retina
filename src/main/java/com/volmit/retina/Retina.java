package com.volmit.retina;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Retina extends JavaPlugin {
    public static Retina instance;

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public String getTag(String subTag) {
        return ChatColor.BOLD + "" + ChatColor.DARK_GRAY + "[" + ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Retina" + ChatColor.BOLD + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + "" + ChatColor.GRAY + ": ";
    }

    public static void warn(String string) {
        msg(ChatColor.YELLOW + string);
    }

    public static void error(String string) {
        msg(ChatColor.RED + string);
    }

    public static void verbose(String string) {
        if(RetinaConfig.get().isVerbose()) {
            msg(ChatColor.LIGHT_PURPLE + string);
        }
    }

    public static void msg(String string) {
        try {
            if (instance == null) {
                System.out.println("[Retina]: " + string);
                return;
            }

            String msg = ChatColor.GRAY + "[" + ChatColor.LIGHT_PURPLE + "Retina" + ChatColor.GRAY + "]: " + string;
            Bukkit.getConsoleSender().sendMessage(msg);
        } catch (Throwable e) {
            System.out.println("[Retina]: " + string);
        }
    }

    public static void success(String string) {
        msg(ChatColor.GREEN + string);
    }

    public static void info(String string) {
        msg(ChatColor.WHITE + string);
    }

    public File getDataFile(String... strings) {
        List<String> s = new ArrayList<>(Arrays.asList(strings));
        File f = new File(getDataFolder(), String.join(File.separator, s));
        f.getParentFile().mkdirs();
        return f;
    }

    public File getDataFolder(String... strings) {
        if (strings.length == 0) {
            return super.getDataFolder();
        }

        List<String> s = new ArrayList<>(Arrays.asList(strings));
        File f = new File(getDataFolder(), String.join(File.separator, s));
        f.mkdirs();

        return f;
    }
}
