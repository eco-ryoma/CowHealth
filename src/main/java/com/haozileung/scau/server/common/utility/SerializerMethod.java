package com.haozileung.scau.server.common.utility;

import java.lang.reflect.Type;
import java.text.DateFormat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * <p>序列化方法</p>
 * 创建时间：2011-11-14 下午05:45:27 
 * @author chenxiaoqiang
 * @version V1.0
 */
public class SerializerMethod {
    
    /**
     * 序列化方法
     */
    public static String bean2json(Object bean, Type type,String format) {
        Gson gson = new GsonBuilder().registerTypeAdapter(java.util.Date.class, new UtilDateSerializer())
                .setDateFormat(format).create();
        return gson.toJson(bean);
    }
    
    /**
     * 反序列化方法
     */

    @SuppressWarnings("unchecked")
	public static <T> T json2bean(String json, Type type) {
        Gson gson = new GsonBuilder().registerTypeAdapter(java.util.Date.class, new UtilDateDeserializer())
                .setDateFormat(DateFormat.LONG).create();
        return (T)gson.fromJson(json, type);
    }

}
