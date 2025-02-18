package com.someone.util;

/*
 * @Author Someone
 * @Date 2024/11/09 14:58
 */

import android.content.ClipData;
import android.content.ClipboardManager;

public class ClipBoardUtils {
    private static final ClipboardManager clipboardManager = (ClipboardManager) GlobalContextUtil.getContext().getSystemService("cl" + "i" + "pb" + "oa" + "rd");

    public static void clip(String text) {
        ClipData clipData = ClipData.newPlainText("la" + "bel", text);
        clipboardManager.setPrimaryClip(clipData);
    }

}
