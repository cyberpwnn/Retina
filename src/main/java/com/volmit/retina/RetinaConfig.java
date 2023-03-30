package com.volmit.retina;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.volmit.retina.util.IO;
import lombok.Getter;

import java.io.File;
import java.io.IOException;

@Getter
public class RetinaConfig {
    private static RetinaConfig config = null;
    private boolean verbose = false;
    private boolean metrics = true;

    public static RetinaConfig get() {
        if(config == null) {
            RetinaConfig dummy = new RetinaConfig();
            File l = Retina.instance.getDataFile("config.json");


            if(!l.exists()) {
                try {
                    IO.writeAll(l, new GsonBuilder().setPrettyPrinting().create().toJson(dummy));
                } catch(IOException e) {
                    e.printStackTrace();
                    config = dummy;
                    return dummy;
                }
            }

            try {
                config = new Gson().fromJson(IO.readAll(l), RetinaConfig.class);
                IO.writeAll(l, new GsonBuilder().setPrettyPrinting().create().toJson(config));
            } catch(IOException e) {
                e.printStackTrace();
                config = new RetinaConfig();
            }
        }

        return config;
    }
}
