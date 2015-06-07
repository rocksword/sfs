package com.an.sfs.crawler.gdrs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.an.sfs.crawler.AppFilePath;

public class GdyjAnalyzerMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(GdyjAnalyzerMain.class);

    public static void main(String[] args) {
        LOGGER.info("Start application.");
        AppFilePath.initDirs();
        new GdrsAnalyzer().run();
        LOGGER.info("Exit application.");
    }
}