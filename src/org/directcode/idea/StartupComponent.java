package org.directcode.idea;

import com.intellij.core.JavaCoreProjectEnvironment;
import com.intellij.externalSystem.JavaProjectData;
import com.intellij.ide.actions.CreateDirectoryOrPackageAction;
import com.intellij.ide.actions.CreateDirectoryOrPackageHandler;
import com.intellij.ide.actions.NewProjectAction;
import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.ide.impl.NewProjectUtil;
import com.intellij.ide.projectWizard.NewProjectWizard;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.ProjectManagerListener;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.roots.ui.configuration.artifacts.actions.AddNewPackagingElementAction;
import com.intellij.openapi.vcs.checkout.NewProjectCheckoutListener;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.impl.file.PsiDirectoryImpl;
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

        ProjectManager.getInstance().addProjectManagerListener(new ProjectManagerListener() {
            @Override
            public void projectOpened(Project project) {
                //noinspection PointlessBooleanExpression,ConstantConditions
                if (!Configuration.GH_PKG_ENABLED) {
                    return;
                }

                ProjectRootManager manager = ProjectRootManager.getInstance(project);

                for (VirtualFile file : manager.getContentSourceRoots()) {
                    if (file.isDirectory() && file.getChildren().length != 0) {
                        return;
                    }
                }

                VirtualFile dir = manager.getContentSourceRoots()[0];
                try {
                    dir.createChildDirectory(this, "com/github/" + GitHubUtil.username());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public boolean canCloseProject(Project project) {
                return true;
            }

            @Override
            public void projectClosed(Project project) {
            }

            @Override
            public void projectClosing(Project project) {
            }
        });
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
