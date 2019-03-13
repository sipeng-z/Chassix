package com.utils;

import org.apache.commons.codec.binary.Base64;

import com.model.AppConsts;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * 字符串工具类。
 *
 */
public abstract class StringUtils {


	private static final Map<String, Pattern> PATTERN_CACHE = new ConcurrentHashMap<>();


	private StringUtils() {
	}

	/**
	 * 检查指定的字符串是否为空。
	 * <ul>
	 * <li>SysUtils.isEmpty(null) = true</li>
	 * <li>SysUtils.isEmpty("") = true</li>
	 * <li>SysUtils.isEmpty("   ") = true</li>
	 * <li>SysUtils.isEmpty("abc") = false</li>
	 * </ul>
	 *
	 * @param value 待检查的字符串
	 * @return true/false
	 */
	public static boolean isEmpty(String value) {
		int strLen;
		if (value == null || (strLen = value.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(value.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查对象是否为数字型字符串,包含负数开头的。
	 */
	public static boolean isNumeric(Object obj) {
		if (obj == null) {
			return false;
		}
		char[] chars = obj.toString().toCharArray();
		int length = chars.length;
		if (length < 1)
			return false;

		int i = 0;
		if (length > 1 && chars[0] == '-')
			i = 1;

		for (; i < length; i++) {
			if (!Character.isDigit(chars[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查指定的字符串列表是否不为空。
	 */
	public static boolean isNotEmpty(String... values) {
		boolean result = true;
		if (values == null || values.length == 0) {
			result = false;
		} else {
			for (String value : values) {
				result &= !isEmpty(value);
			}
		}
		return result;
	}

	/**
	 * 把通用字符编码的字符串转化为汉字编码。
	 */
	public static String unicodeToChinese(String unicode) {
		StringBuilder out = new StringBuilder();
		if (!isEmpty(unicode)) {
			for (int i = 0; i < unicode.length(); i++) {
				out.append(unicode.charAt(i));
			}
		}
		return out.toString();
	}

	/**
	 * 过滤不可见字符
	 */
	public static String stripNonValidXMLCharacters(String input) {
		if (input == null || ("".equals(input)))
			return "";
		StringBuilder out = new StringBuilder();
		char current;
		for (int i = 0; i < input.length(); i++) {
			current = input.charAt(i);
			if ((current == 0x9) || (current == 0xA) || (current == 0xD)
					|| ((current >= 0x20) && (current <= 0xD7FF))
					|| ((current >= 0xE000) && (current <= 0xFFFD))
					|| ((current >= 0x10000) && (current <= 0x10FFFF)))
				out.append(current);
		}
		return out.toString();
	}

	/**
	 * 随机生成n位随机字符串
	 */
	public static String randomString(int n) {
		Random RANDOM = new SecureRandom();
		byte[] salt = new byte[n];
		RANDOM.nextBytes(salt);
		String str = new String(Base64.encodeBase64(salt)).substring(1, 1 + n);
		return str;
	}

	/**
	 * 获取验证码
	 *
	 * @return
	 */
	public static String getRandomCode() {
		String code = "";
		Random r = new Random();
		Double d = r.nextDouble();
		code += d;
		code = code.substring(3, 3 + 6);
		return code;
	}


	public static boolean isNullOrEmpty(Object obj) {
		return obj == null || "".equals(obj.toString());
	}


	public static boolean isInt(Object obj) {
		if (isNullOrEmpty(obj))
			return false;
		if (obj instanceof Integer)
			return true;
		return obj.toString().matches("[-+]?\\d+");
	}


	public static boolean isDouble(Object obj) {
		if (isNullOrEmpty(obj))
			return false;
		if (obj instanceof Double || obj instanceof Float)
			return true;
		return compileRegex("[-+]?\\d+\\.\\d+").matcher(obj.toString()).matches();
	}


	public static final Pattern compileRegex(String regex) {
		Pattern pattern = PATTERN_CACHE.get(regex);
		if (pattern == null) {
			pattern = Pattern.compile(regex);
			PATTERN_CACHE.put(regex, pattern);
		}
		return pattern;
	}


	public static boolean isBoolean(Object obj) {
		if (obj instanceof Boolean) return true;
		String strVal = String.valueOf(obj);
		return "true".equalsIgnoreCase(strVal) || "false".equalsIgnoreCase(strVal);
	}


	public static boolean isTrue(Object obj) {
		return "true".equals(String.valueOf(obj));
	}


	public static int toInt(Object object, int defaultValue) {
		if (object instanceof Number)
			return ((Number) object).intValue();
		if (isInt(object)) {
			return Integer.parseInt(object.toString());
		}
		if (isDouble(object)) {
			return (int) Double.parseDouble(object.toString());
		}
		return defaultValue;
	}


	public static int toInt(Object object) {
		return toInt(object, 0);
	}


	public static long toLong(Object object, long defaultValue) {
		if (object instanceof Number)
			return ((Number) object).longValue();
		if (isInt(object)) {
			return Long.parseLong(object.toString());
		}
		if (isDouble(object)) {
			return (long) Double.parseDouble(object.toString());
		}
		return defaultValue;
	}


	public static long toLong(Object object) {
		return toLong(object, 0);
	}

	public static double toDouble(Object object, double defaultValue) {
		if (object instanceof Number)
			return ((Number) object).doubleValue();
		if (isNumber(object)) {
			return Double.parseDouble(object.toString());
		}
		if (null == object) return defaultValue;
		return 0;
	}


	public static double toDouble(Object object) {
		return toDouble(object, 0);
	}

	public static boolean isNumber(Object obj) {
		if (obj instanceof Number) return true;
		return isInt(obj) || isDouble(obj);
	}


	/**
	 * 判断String 是否是数字
	 * @param str
	 * @return
	 */
	public static boolean isNumberic(String str){
		for(int i = 0;i < str.length(); i++){
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * 字符串转guid
	 * @param str
	 * @return
	 */
	public static UUID StringToGuid(String str) {
		 UUID uid =UUID.fromString(AppConsts.defaultGuId);
        if (str!=null&&!str.equals("")&&str.length()==36) {
        	try {
          	   uid =UUID.fromString(str);
			} catch (Exception e) {
				// TODO: handle exception
			}
        }
        return uid;
	}



}
