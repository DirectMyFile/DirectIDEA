package org.directcode.idea;

import com.intellij.openapi.diagnostic.Logger;
import org.apache.log4j.Level;

public class Util {
    public static final Logger LOG;

    static {
        LOG = Logger.getInstance("DirectIDEA");
        LOG.setLevel(Level.ALL);
    }
}
