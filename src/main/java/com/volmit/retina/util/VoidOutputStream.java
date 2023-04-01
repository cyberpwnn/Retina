package com.volmit.retina.util;

import java.io.IOException;
import java.io.OutputStream;

public class VoidOutputStream extends OutputStream {
    @Override
    public void write(int b) throws IOException {
        // poof
    }
}

