package org.directcode.idea;

import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class StartupComponent implements ApplicationComponent {

    @Override
    public void initComponent() {
        Util.debug("Initializing Startup Component");

        FileTemplate template = FileTemplateManager.getInstance().addTemplate("Basic PubSpec", "yaml");

        try {
            template.setText(Util.toString(StartupComponent.class.getResourceAsStream("templates/default_pubspec.yaml")));
        } catch (IOException e) {
            Util.LOG.error("Failed to load the default pubspec template!", e);
        }
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
