package com.testblog.users;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.jar.Manifest;

/**
 * Release info
 */
public final class Release {

    private static final String versionInfo;

    static {
        Manifest manifest = null;
        try {
            manifest = new Manifest(Release.class.getClassLoader().getResourceAsStream("META-INF/MANIFEST.MF"));
        } catch (IOException exception) {
            LoggerFactory.getLogger(Release.class).error("Unable to read manifest", exception);
        }
        versionInfo = manifest != null ? manifest.getMainAttributes().getValue("Implementation-Version") : null;
    }

    /**
     * Get Version of the project
     *
     * @return {@link String}
     */
    public static String getVersionInfo() {
        return versionInfo;
    }
}
