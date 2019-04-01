package com.magazineapp.service;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ZipService {
    public static Path createFromPaths(List<Path> inPaths) throws IOException {
        Path outPath = FileSystemService.getZipFilePath();        

        Map<String, String> env = new HashMap<>();
        env.put("create", "true");//create zip if not exists, prob not necessary

        //using .zip extension should automatically use zipfs provider
        try (FileSystem zipfs = FileSystems.newFileSystem(outPath.toUri(), env)) {
            //Just to know if environment lack provider
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(zipfs.provider().toString());
            
            for (Path curPath : inPaths) {
                Path pathInZipfile = zipfs.getPath(curPath.getFileName().toString());

                Files.copy(curPath, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        
        return outPath;
    }
}
