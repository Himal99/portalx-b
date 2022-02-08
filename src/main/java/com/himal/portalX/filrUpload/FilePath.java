package com.himal.portalX.filrUpload;

/**
 * @author Himal Rai on 2/8/2022
 */
public class FilePath {

    public static String getOSPath() {
        final String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return UploadDir.WINDOWS_PATH;
        } else {
            return UploadDir.Linux_PATH;
        }
    }
}
