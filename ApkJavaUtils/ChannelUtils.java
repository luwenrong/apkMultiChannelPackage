package com.xiaoniu.earn.utils;

import android.content.pm.ApplicationInfo;

import com.xiaoniu.commoncore.utils.ContextUtils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


/**
 * Desc:
 * <p>
 *
 * @Author: ten.lu
 * @Date: 2020/6/17 20:18
 * @Copyright: Copyright (c) 2016-2020
 * @Company: 
 * @Version: 1.0
 */
public class ChannelUtils {
    public static final String[] sMarketChannel = new String[]{"yingyongbao", "vivo", "xiaomi", "oppo"
            , "huawei", "baidu", "360", "wandoujia",
            "meizu", "sanxing", "yingyonghui", "anzhi", "lianxiang", "sougou"
            , "mumayi", "liqu", "jifeng"
    };

    /**
     * 获取市场渠道名
     *
     * @return channel
     */
    public static String getChannelId() {
        String defaultChannel = "xiaoNiuTest";
        ApplicationInfo appInfo = ContextUtils.getContext().getApplicationInfo();
        String sourceDir = appInfo.sourceDir;
        String ret = "";
        ZipFile zipfile = null;
        try {
            zipfile = new ZipFile(sourceDir);
            Enumeration<?> entries = zipfile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String entryName = entry.getName();
                if (entryName.startsWith("META-INF/uuchannel")) {
                    ret = entryName;
                    break;
                }
            }
        } catch (Exception e) {
            return defaultChannel;
        } finally {
            if (zipfile != null) {
                try {
                    zipfile.close();
                } catch (IOException e) {
                    return defaultChannel;
                }
            }
        }
        if (!isEmpty(ret)) {
            String[] split = ret.split("_");
            if (split != null && split.length >= 2) {
                return ret.substring(split[0].length() + 1);
            } else {
                return defaultChannel;
            }
        } else {
            return defaultChannel;
        }
    }

    private static boolean isEmpty(String str) {
        if (str == null || str.length() == 0 || "null".equals(str)) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isMarketChannel() {
        String channel = getChannelId();
        for (int i = 0; i < sMarketChannel.length; i++) {
            String curChannel = sMarketChannel[i];
            if (channel.contains(curChannel)) {
                return true;
            }
        }
        return false;
    }
}

