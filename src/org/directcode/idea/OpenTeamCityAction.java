package org.directcode.idea;

import com.intellij.ide.browsers.BrowserLauncher;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class OpenTeamCityAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Util.LOG.debug("Launching TeamCity");
        BrowserLauncher.getInstance().open(Configuration.TEAMCITY_URL);
    }
}
