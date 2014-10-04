package org.directcode.idea;

import com.intellij.json.JsonFileType;
import com.intellij.lang.javascript.JavaScriptFileType;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class JSON5FileType extends LanguageFileType {

    public static final JSON5FileType INSTANCE;

    static {
        INSTANCE = new JSON5FileType();
    }

    protected JSON5FileType() {
        super(JavaScriptFileType.INSTANCE.getLanguage());
        Util.debug("Created JSON5 File Type");
    }

    @NotNull
    @Override
    public String getName() {
        return "JSON5";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "JSON ECMAScript 5 Extension";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "json5";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return JsonFileType.INSTANCE.getIcon();
    }
}
