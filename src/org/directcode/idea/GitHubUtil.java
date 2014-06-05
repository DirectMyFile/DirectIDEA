package org.directcode.idea;

import org.jetbrains.plugins.github.util.GithubSettings;

public class GitHubUtil {
    public static GithubSettings settings() {
        return GithubSettings.getInstance();
    }
}
