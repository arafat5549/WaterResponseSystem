package com.jqmkj.WaterResponseSystem.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;

public class HttpServerUtil {

	public static String getStringPostParams(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("UTF-8");
		StringBuffer sb = new StringBuffer();
		InputStream is = request.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String s = "";
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		String resultStr = sb.toString();
		return resultStr;

	}
	public static Map<String, Object> getMapPostParams(HttpServletRequest request) throws IOException {
		return JSONObject.parseObject(getStringPostParams(request));
	}
	public static JSONObject getJsonPostParams(HttpServletRequest request) throws IOException {
		return JSONObject.parseObject(getStringPostParams(request));
	}
	public static <T> T getBeanPostParams(HttpServletRequest request,Class<T> clazz) throws IOException {
		return JSONObject.parseObject(getStringPostParams(request), clazz);
	}


	public static String getGetParams(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		Map<String, String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			String[] array = map.get(key);
			for (String str : array) {
				sb.append(str);
			}
		}
		return sb.toString();
	}



	public static String getStringParameter(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		if (request != null) {
			Map<String, String[]> parameterMap = request.getParameterMap();
			for (String key : parameterMap.keySet()) {
				String[] value = parameterMap.get(key);
				if (value.length > 0) {
					if (key.endsWith("[]")) {
				
					} else if (/*StringUtils.hasText(value[0]) &&*/ !"token".equals(key)) {
						if (sb.length() > 0) {
							sb.append("&" + key + "=" + value[0].trim());
						} else {
							sb.append(key + "=" + value[0].trim());
						}
					}
				}
			}
		}
		return sb.toString();
	}

}
