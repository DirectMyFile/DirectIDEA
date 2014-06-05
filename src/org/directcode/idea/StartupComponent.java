package org.directcode.idea;

import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class StartupComponent implements ApplicationComponent {

    @Override
    public void initComponent() {
        Util.debug("Initializing Startup Component");
    }

    @Override
    public void disposeComponent() {
        Util.debug("Disposing Startup Component");
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "DirectIDEA Startup";
    }
}
