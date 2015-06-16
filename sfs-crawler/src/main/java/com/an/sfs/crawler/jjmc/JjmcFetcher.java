package com.an.sfs.crawler.jjmc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.an.sfs.crawler.AppFilePath;
import com.an.sfs.crawler.FileUtil;

public class JjmcFetcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(JjmcFetcher.class);
    // page=1
    // type= 0-全部, 1-股票型, 2-混合型, 3-债券型 4-LOF, 5-ETF,6-QDII
    private final String URL = "http://hq2data.eastmoney.com/fund/fundlist.aspx?jsName=fundListObj&fund=0&type=%s&page=%s";
    private static final String FLAG = "<a href=\"http://fund.eastmoney.com/";
    private static final String FILE_NAME = "jjmc.txt";

    public void run() {
        download();
        convert();
        export();
    }

    private void download() {
        List<JjType> jjTypes = JjTypeLoader.getJjTypes();
        for (JjType jj : jjTypes) {
            int pageCount = jj.getPageCount();
            for (int i = 0; i < pageCount; i++) {
                int typeVal = jj.getValue();
                String url = String.format(URL, typeVal, i + 1);
                String filePath = AppFilePath.getInputJjmcDir() + File.separator + typeVal + "_" + i + ".txt";
                if (!FileUtil.isFileExist(filePath)) {
                    // AppUtil.download_rest(url, filePath);
                    // AppUtil.download(url, filePath);
                }
            }
        }
    }

    private void convert() {
        List<File> fileList = new ArrayList<>();
        FileUtil.getFilesUnderDir(AppFilePath.getInputJjmcRawDir(), fileList);
        for (File f : fileList) {
            FileUtil.formatHtmlFile(AppFilePath.getInputJjmcTxtDir(), ".txt", f.getPath(), "gb2312");
        }
    }

    private void export() {
        List<File> fileList = new ArrayList<>();
        FileUtil.getFilesUnderDir(AppFilePath.getInputJjmcTxtDir(), fileList);

        List<JjmcVo> jjmcList = new ArrayList<>();
        for (File f : fileList) {
            String fn = FileUtil.getFileName(f.getPath());
            int jjType = Integer.parseInt(fn.substring(0, fn.indexOf("-")));
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                int count = 0;
                String line = null;
                String code = null;
                while ((line = br.readLine()) != null) {
                    if (line.contains(FLAG)) {
                        int startIndex = line.indexOf(">");
                        int endIndex = line.indexOf("<", startIndex);
                        String val = line.substring(startIndex + 1, endIndex);
                        if ((count + 1) % 3 == 1) {
                            code = val;
                        } else if ((count + 1) % 3 == 2) {
                            jjmcList.add(new JjmcVo(jjType, code, val));
                        }
                        count++;
                    }
                }
            } catch (IOException e) {
                LOGGER.error("Error ", e);
            }
        }

        Collections.sort(jjmcList);

        StringBuilder text = new StringBuilder();
        for (JjmcVo vo : jjmcList) {
            text.append(vo.getStr()).append("\n");
        }
        FileUtil.writeFile(getJjmcFile(), text.toString());
    }

    public String getJjmcFile() {
        return AppFilePath.getOutputJjmcDir() + File.separator + FILE_NAME;
    }
}
