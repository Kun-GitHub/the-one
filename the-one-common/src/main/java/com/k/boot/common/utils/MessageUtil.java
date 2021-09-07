

package com.k.boot.common.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 国际化
 *
 * @author K.
 * @Email hot_kun@hotmail.com
 * @date 2021-04-20 20:28
 */
public class MessageUtil {
    private static MessageSource messageSource;
    static {
        messageSource = (MessageSource) SpringContextUtil.getBean("messageSource");
    }

    public static String getMessage(int code){
        return getMessage(code, new String[0]);
    }

    public static String getMessage(int code, String... params){
        return messageSource.getMessage(code+"", params, LocaleContextHolder.getLocale());
    }
}
