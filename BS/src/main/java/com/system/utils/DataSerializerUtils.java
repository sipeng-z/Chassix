package com.system.utils;


import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.commons.lang3.math.NumberUtils;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author Bob.chen
 * @date 2018年11月14日-下午4:59:50
 * @desc
 */
public class DataSerializerUtils extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if(!StringUtils.isEmpty(value)) {
            DecimalFormat df = new DecimalFormat("0.000");
            df.setRoundingMode(RoundingMode.HALF_UP);
            double _value = NumberUtils.toDouble(value);
            gen.writeString(df.format(_value));
        }else {//这个分支不要忘记了，否则将不输出这个属性的值
            gen.writeString(value);
        }
    }
}

