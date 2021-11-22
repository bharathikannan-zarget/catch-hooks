package com.freshmarketer.catchhook;

import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class FileUtil {

    public String readAll(InputStream stream) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead = -1;
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            while ((bytesRead = stream.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
        } finally {
            stream.close();
        }

        return new String(out.toByteArray(), StandardCharsets.UTF_8);
    }

}
