package com.chen.baida.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ShiQing_Chen 2018-12-06
 * @since 0.0.1
 */
public class FileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);
    private FileUtils(){
        //default
    }

    public static String getFileExt(final String filename) {
        return filename.substring(filename.lastIndexOf('.')).toLowerCase();
    }

    /**
     * image/png
     * @param contentType
     * @return 文件后缀,带‘.’ 如‘.jpg’
     */
    public static String getExtFromContent(final String contentType) {
        String ext = contentType.substring(contentType.lastIndexOf('/')).toLowerCase();
        return ext.replace('/','.');
    }

    public static void main(String[] args){
        LOGGER.debug(FileUtils.getFileExt("a.jpg"));
    }
}
