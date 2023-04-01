package com.volmit.retina.generator.block;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

public class B {
    public static BlockData block(String name) {
        try {
            return Bukkit.createBlockData("minecraft:" + name);
        }

        catch(Throwable e) {
            try {
                return Bukkit.createBlockData(name);
            }

            catch(Throwable ex) {
                try {
                    return Material.valueOf(name).createBlockData();
                }

                catch(Throwable exx) {
                    return Material.STONE.createBlockData();
                }
            }
        }
    }
}
