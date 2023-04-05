package com.volmit.retina;

import art.arcane.source.ui.Visualizer;
import com.volmit.retina.generator.RetinaBiome;
import com.volmit.retina.generator.RetinaChunkGenerator;
import com.volmit.retina.generator.RetinaWorld;
import com.volmit.retina.generator.property.RetinaProperty;
import com.volmit.retina.generator.tag.RetinaTag;
import com.volmit.retina.util.IO;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public final class Retina extends JavaPlugin {
    public static Retina instance;
    private World defWorld = null;
    public static File jarFile;

    @Override
    public void onEnable() {
        jarFile = getFile();

        for(World i : Bukkit.getWorlds()) {
            if(i.getName().startsWith("r/")) {
                continue;
            }

            defWorld = i;
            break;
        }

        World world = WorldCreator.name("r/" + UUID.randomUUID()).seed(1337).generator(new RetinaChunkGenerator()).createWorld();

       getServer().getScheduler().scheduleSyncDelayedTask(this, () -> {
           for(Player i : Bukkit.getOnlinePlayers()) {
               i.teleport(new Location(world, 0, 128, 0));
               i.setGameMode(GameMode.SPECTATOR);
               i.setFlySpeed(1);
           }

           getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
               for(Player i : Bukkit.getOnlinePlayers()) {
                   System.out.println("@debug world " + i.getWorld().getName());
                   if(i.getLocation().getWorld().getName().startsWith("r/")) {
                       RetinaChunkGenerator g = (RetinaChunkGenerator) i.getLocation().getWorld().getGenerator();
                       RetinaBiome b = g.getR().getBiome(i.getLocation().getBlockX(), i.getLocation().getBlockZ());

                       System.out.println("@debug t " + b.getWorld().getTags().getValues().size());

                       for(RetinaTag j : b.getWorld().getTags().getValues()) {
                           System.out.println("@debug TAG_" + j.getKey() + " " + b.getReal(j.getClass()) + " (" + b.getReal(j.getClass()) + ")");
                       }

                       for(RetinaProperty j : b.getWorld().getProperties().getValues()) {
                           System.out.println("@debug " + j.getKey() + " " + b.getProperty(j.getClass()));
                       }

                       System.out.println("@debug spike " + b.getBlockSpike());
                   }
               }
           }, 0, 20);
       });
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks(this);
        for(World i : Bukkit.getWorlds()) {
            if(i.getName().startsWith("r/")) {
                for(Player j : i.getPlayers()) {
                    j.teleport(defWorld.getSpawnLocation());
                }

                for(Chunk j : i.getLoadedChunks()) {
                    j.unload(false);
                }

                Bukkit.unloadWorld(i, false);
            }
        }

        IO.delete(new File("r"));
        new File("r").deleteOnExit();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("retina")) {
            try {
                if(args.length == 2) {
                    if(args[0].equalsIgnoreCase("tag") || args[0].equalsIgnoreCase("t")) {
                        for(RetinaTag i : RetinaWorld.debugLast.getTags().getValues()) {
                            if(i.getKey().equalsIgnoreCase(args[1])) {
                                Visualizer.launch(i.toPlane());
                                return true;
                            }
                        }
                    }

                    else if(args[0].equalsIgnoreCase("property") || args[0].equalsIgnoreCase("p")) {
                        for(RetinaProperty i : RetinaWorld.debugLast.getProperties().getValues()) {
                            if(i.getKey().equalsIgnoreCase(args[1])) {
                                Visualizer.launch(i.toPlane(RetinaWorld.debugLast));
                                return true;
                            }
                        }
                    }
                }
            }

            catch(Throwable e)
            {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new RetinaChunkGenerator();
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
