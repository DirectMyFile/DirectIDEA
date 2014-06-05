package org.directcode.idea;

import com.intellij.ide.browsers.BrowserLauncher;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class OpenTeamCityAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        BrowserLauncher.getInstance().open(Configuration.TEAMCITY_URL);
    }
}
