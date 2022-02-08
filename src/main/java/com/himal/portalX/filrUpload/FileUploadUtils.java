package com.himal.portalX.filrUpload;

import com.himal.portalX.base.httpResponse.MyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Himal Rai on 2/8/2022
 */
public class FileUploadUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadUtils.class);

    private static String url;

    public static ResponseEntity<?> uploadFile(MultipartFile multipartFile, String url,
                                               String documentName) {

        try {
            final byte[] bytes = multipartFile.getBytes();

            Path path = Paths.get(FilePath.getOSPath() + url);
            if (!Files.exists(path)) {
                new File(FilePath.getOSPath() + url).mkdirs();
            }
            // check if file under same name exits, if exists delete it
            File dir = path.toFile();
            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                for (File f : files) {
                    // remove file if exists
                    if (f.getName().toLowerCase().contains(documentName.toLowerCase())) {
                        try {
                            f.delete();
                        } catch (Exception e) {
                            logger.error("Failed to delete file {} {}", f, e);
                        }
                    }
                }

            }
            String fileExtension = "pdf";
            url = url + documentName.toLowerCase() + "." + fileExtension;

            path = Paths.get(FilePath.getOSPath() + url);
            Files.write(path, bytes);
            return new MyResponse().successResponse(url);
        } catch (IOException e) {
            logger.error("Error while saving file {}", e);
            return new MyResponse().failResponseBadRequest("Fail");
        }
    }
}
