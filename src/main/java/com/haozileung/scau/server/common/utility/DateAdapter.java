package com.haozileung.scau.server.common.utility;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * <p>
 * gson转换日期时的适应器，用于按特定要求转换日期
 * </p>
 * 创建时间：2013-1-8 上午11:02:33
 * 
 * @author pengjianqiang
 * @version V1.0
 */
public class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private SimpleDateFormat df;

    public DateAdapter(String pattern) {
        df = new SimpleDateFormat(pattern);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement,
     * java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
     */
    @Override
    public Date deserialize(JsonElement je, Type type, JsonDeserializationContext context) throws JsonParseException {
        String dateStr = null;
        try {
            dateStr = je.getAsJsonPrimitive().getAsString();
            return df.parse(dateStr);
        } catch (ParseException e) {
            throw new JsonParseException(dateStr + "不能按格式" + df.toPattern() + "转换成Date对象");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.google.gson.JsonSerializer#serialize(java.lang.Object,
     * java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
     */
    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(df.format(date));
    }
}