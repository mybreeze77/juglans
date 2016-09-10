package com.juglans.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;

/**
 * File operation
 * @author Junlong Wu
 *
 */
public class FileUtil {
	
	public static File copyFile(String srcFileName) throws IOException {
        InputStream inputStream;

        File originalFile = new File(srcFileName);
        if (originalFile.exists()) return originalFile;

        inputStream = FileUtil.class.getResourceAsStream(srcFileName);
        if (inputStream == null) return null;

        File outputFile = new File(Paths.get(srcFileName).getFileName().toString());
        OutputStream outputStream = new FileOutputStream(outputFile);
        IOUtils.copy(inputStream, outputStream);

        inputStream.close();
        outputStream.close();

        return outputFile;
    }
	
}
