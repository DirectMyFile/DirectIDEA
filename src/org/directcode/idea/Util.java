package org.directcode.idea;

import com.intellij.openapi.diagnostic.Logger;
import org.apache.log4j.Level;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static final Logger LOG;

    static {
        LOG = Logger.getInstance("DirectIDEA");
        LOG.setLevel(Level.ALL);
    }

    public static boolean maybeMember() {
        return fileExists(home(".devtools")) || fileExists(home(".directcode")) || fileExists(home("DirectCode"));
    }

    public static boolean fileExists(@NotNull String path) {
        return new File(path).exists();
    }

    @NotNull
    public static String home(String path) {
        return System.getProperty("user.home") + "/" + path;
    }

    public static void debug(String line) {
        LOG.debug(line);
    }

    public static String toString(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        List<String> lines = new ArrayList<String>();

        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        return DefaultGroovyMethods.join((Iterable<String>) lines, System.lineSeparator());
    }
}
