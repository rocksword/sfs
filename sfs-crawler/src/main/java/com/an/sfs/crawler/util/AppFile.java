package com.an.sfs.crawler.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.an.sfs.crawler.SfsConf;

public class AppFile {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppFile.class);

    public static void initDirs() {
        String baseDir = getBaseDir();
        if (baseDir == null || baseDir.isEmpty()) {
            LOGGER.error("Empty base directory, please set SFS_HOME.");
            System.exit(1);
        }

        List<String> dirs = new ArrayList<>();
        dirs.add(baseDir);
        dirs.add(getConfDir());
        dirs.add(getInputDir());

        dirs.add(getInputGdyjDir());
        dirs.add(getInputGdyjRawDir());
        dirs.add(getInputGdyjGdrsDir());
        dirs.add(getInputGdyjSdltgdDir());
        dirs.add(getOutputGdyjGdrsDir());
        dirs.add(getOutputGdyjSdltgdDir());

        dirs.add(getInputCwfxRawDir());
        dirs.add(getOutputCwfxDir());
        dirs.add(getOutputCwfxRonaDir());

        dirs.add(getInputGgdqDir());
        dirs.add(getOutputGgdqDir());

        dirs.add(getInputTfpggDir());
        dirs.add(getOutputTfpggDir());

        dirs.add(getInputFhrzRawDir());
        dirs.add(getInputFhrzFhfaDir());
        dirs.add(getInputFhrzZfmxDir());
        dirs.add(getOutputFhfaDir());

        dirs.add(getInputJjmcRawDir());
        dirs.add(getInputJjmcTxtDir());
        dirs.add(getOutputJjmcDir());

        dirs.add(getInputJjccRawDir());
        dirs.add(getInputJjccTxtDir());
        dirs.add(getOutputJjccDir());
        for (String season : SfsConf.getSeasonList()) {
            dirs.add(getInputJjccRawDir(season));
            dirs.add(getInputJjccTxtDir(season));
        }

        dirs.add(getInputCcjgRawDir());
        dirs.add(getInputCcjgTxtDir());
        dirs.add(getOutputCcjgDir());
        for (String season : SfsConf.getSeasonList()) {
            dirs.add(getInputCcjgRawDir(season));
            dirs.add(getInputCcjgTxtDir(season));
        }

        dirs.add(getInputYjygRawDir());
        dirs.add(getInputYjygTxtDir());
        dirs.add(getOutputYjygDir());

        dirs.add(getInputGbjgRawDir());
        dirs.add(getInputGbjgTxtDir());
        dirs.add(getOutputGbjgDir());

        dirs.add(getInputGsgkRawDir());
        dirs.add(getInputGsgkTxtDir());
        dirs.add(getOutputGsgkDir());

        dirs.add(getInputCninfoRawDir());
        dirs.add(getInputCninfoTxtDir());
        dirs.add(getOutputCninfoGdrsDir());

        for (String dirName : dirs) {
            File dir = new File(dirName);
            if (!dir.exists()) {
                dir.mkdirs();
            }
        }
    }

    /**
     * @param dirName
     */
    public static void mkdirs(String dirName) {
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    private static String getBaseDir() {
        return System.getenv("SFS_HOME");
    }

    public static String getConfDir() {
        return getBaseDir() + File.separator + "conf";
    }

    private static String getInputDir() {
        return getBaseDir() + File.separator + "input";
    }

    public static String getOutputDir() {
        return getBaseDir() + File.separator + "output";
    }

    public static String getOutputCwfxRonaDir() {
        return getOutputDir() + File.separator + "cwfx_rona";
    }

    public static String getInputGdyjDir() {
        return getInputDir() + File.separator + "gdyj";
    }

    public static String getInputGdyjRawDir() {
        return getInputGdyjDir() + File.separator + "raw";
    }

    public static String getInputGdyjGdrsDir() {
        return getInputGdyjDir() + File.separator + "gdrs";
    }

    public static String getInputGdyjSdltgdDir() {
        return getInputGdyjDir() + File.separator + "sdltgd";
    }

    public static String getInputYjbbRawDir() {
        return getInputYjbbDir() + File.separator + "raw";
    }

    public static String getInputYjbbTxtDir() {
        return getInputYjbbDir() + File.separator + "txt";
    }

    public static String getInputYjbbDir() {
        return getInputDir() + File.separator + "yjbb";
    }

    private static String getOutputGdyjDir() {
        return getOutputDir() + File.separator + "gdyj";
    }

    public static String getOutputGdyjGdrsDir() {
        return getOutputGdyjDir() + File.separator + "gdrs";
    }

    public static String getOutputGdyjSdltgdDir() {
        return getOutputGdyjDir() + File.separator + "sdltgd";
    }

    private static String getInputCwfxDir() {
        return getInputDir() + File.separator + "cwfx";
    }

    private static String getInputGfDir() {
        return getInputDir() + File.separator + "gf";
    }

    public static String getInputCwfxRawDir() {
        return getInputCwfxDir() + File.separator + "raw";
    }

    public static String getInputGfRawDir() {
        return getInputGfDir() + File.separator + "raw";
    }

    public static String getOutputCwfxDir() {
        return getOutputDir() + File.separator + "cwfx";
    }

    public static String getInputGgdqDir() {
        return getInputDir() + File.separator + "ggdq";
    }

    public static String getOutputGgdqDir() {
        return getOutputDir() + File.separator + "ggdq";
    }

    public static String getInputTfpggDir() {
        return getInputDir() + File.separator + "tfpgg";
    }

    public static String getOutputTfpggDir() {
        return getOutputDir() + File.separator + "tfpgg";
    }

    public static String getInputFhrzDir() {
        return getInputDir() + File.separator + "fhrz";
    }

    public static String getInputFhrzRawDir() {
        return getInputFhrzDir() + File.separator + "raw";
    }

    public static String getInputFhrzFhfaDir() {
        return getInputFhrzDir() + File.separator + "fhfa";
    }

    public static String getInputFhrzZfmxDir() {
        return getInputFhrzDir() + File.separator + "zfmx";
    }

    public static String getOutputFhfaDir() {
        return getOutputDir() + File.separator + "fhfa";
    }

    // Ji jin ming cheng
    public static String getInputJjmcDir() {
        return getInputDir() + File.separator + "jjmc";
    }

    public static String getInputJjmcRawDir() {
        return getInputJjmcDir() + File.separator + "raw";
    }

    public static String getInputJjmcTxtDir() {
        return getInputJjmcDir() + File.separator + "txt";
    }

    public static String getOutputJjmcDir() {
        return getOutputDir() + File.separator + "jjmc";
    }

    // Ji jin chi cang
    public static String getInputJjccDir() {
        return getInputDir() + File.separator + "jjcc";
    }

    public static String getInputJjccRawDir() {
        return getInputJjccDir() + File.separator + "raw";
    }

    public static String getInputJjccTxtDir() {
        return getInputJjccDir() + File.separator + "txt";
    }

    public static String getInputJjccRawDir(String season) {
        return getInputJjccRawDir() + File.separator + season;
    }

    public static String getInputJjccTxtDir(String season) {
        return getInputJjccTxtDir() + File.separator + season;
    }

    public static String getOutputJjccDir() {
        return getOutputDir() + File.separator + "jjcc";
    }

    // Chi cang ji gou
    public static String getInputCcjgDir() {
        return getInputDir() + File.separator + "ccjg";
    }

    public static String getInputCcjgRawDir() {
        return getInputCcjgDir() + File.separator + "raw";
    }

    public static String getInputCcjgTxtDir() {
        return getInputCcjgDir() + File.separator + "txt";
    }

    public static String getInputCcjgRawDir(String season) {
        return getInputCcjgRawDir() + File.separator + season;
    }

    public static String getInputCcjgTxtDir(String season) {
        return getInputCcjgTxtDir() + File.separator + season;
    }

    public static String getOutputCcjgDir() {
        return getOutputDir() + File.separator + "ccjg";
    }

    // Ye ji yu gao
    private static String getInputYjygDir() {
        return getInputDir() + File.separator + "yjyg";
    }

    public static String getInputYjygRawDir() {
        return getInputYjygDir() + File.separator + "raw";
    }

    public static String getInputYjygTxtDir() {
        return getInputYjygDir() + File.separator + "txt";
    }

    public static String getOutputYjygDir() {
        return getOutputDir() + File.separator + "yjyg";
    }

    // Gu Ben Jie Gou
    private static String getInputGbjgDir() {
        return getInputDir() + File.separator + "gbjg";
    }

    public static String getInputGbjgRawDir() {
        return getInputGbjgDir() + File.separator + "raw";
    }

    public static String getInputGbjgTxtDir() {
        return getInputGbjgDir() + File.separator + "txt";
    }

    public static String getOutputGbjgDir() {
        return getOutputDir() + File.separator + "gbjg";
    }

    // GongSiGaiKuang
    private static String getInputGsgkDir() {
        return getInputDir() + File.separator + "gsgk";
    }

    public static String getInputGsgkRawDir() {
        return getInputGsgkDir() + File.separator + "raw";
    }

    public static String getInputGsgkTxtDir() {
        return getInputGsgkDir() + File.separator + "txt";
    }

    public static String getOutputGsgkDir() {
        return getOutputDir() + File.separator + "gsgk";
    }

    // TDX
    public static String getInputTdxDir() {
        return getInputDir() + File.separator + "tdx";
    }

    // Cninfo
    private static String getInputCninfoDir() {
        return getInputDir() + File.separator + "cninfo";
    }

    public static String getInputCninfoRawDir() {
        return getInputCninfoDir() + File.separator + "raw";
    }

    private static String getInputCninfoDetailDir() {
        return getInputCninfoDir() + File.separator + "detail";
    }

    public static String getInputCninfoDetailDir(String code) {
        return getInputCninfoDetailDir() + File.separator + code;
    }

    public static String getInputCninfoTxtDir() {
        return getInputCninfoDir() + File.separator + "txt";
    }

    public static String getOutputCninfoDir() {
        return getOutputDir() + File.separator + "cninfo";
    }

    public static String getOutputCninfoGdrsDir() {
        return getOutputCninfoDir() + File.separator + "gdrs";
    }

    //
    public static String getConfFp(String fileName) {
        return getConfDir() + File.separator + fileName;
    }

    public static String getOutputFp(String fileName) {
        return getOutputDir() + File.separator + fileName;
    }
}
