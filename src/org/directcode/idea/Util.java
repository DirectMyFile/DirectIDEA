package org.directcode.idea;

import com.intellij.openapi.diagnostic.Logger;
import org.apache.log4j.Level;

import java.io.File;

public class Util {
    public static final Logger LOG;

    static {
        LOG = Logger.getInstance("DirectIDEA");
        LOG.setLevel(Level.ALL);
    }

    public static boolean maybeMember() {
        return fileExists(home(".devtools")) || fileExists(home(".directcode"));
    }

    public static boolean fileExists(String path) {
        return new File(path).exists();
    }

    public static String home(String path) {
        return System.getProperty("user.home") + "/" + path;
    }

    public static void debug(String line) {
        LOG.debug(line);
    }
}
