package com.lwl.project.admin.util;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;

public class StringUtils {

    private static Converter<String, String> camelToUnderscoreConverter = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);

    /**
     * 驼峰转下划线
     * @param str 驼峰字符串
     * @return String
     */
    public static String camelToUnderscore(String str) {
        return str != null && !"".equals(str) ? camelToUnderscoreConverter.convert(str) : null;
    }
}
