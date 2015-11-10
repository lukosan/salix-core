package org.lukosan.salix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

// TODO refactor this ugly mess; consider SpringEL
public class MapUtils {

	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	static {
		MAPPER.findAndRegisterModules();
	}
	
	@SuppressWarnings({ "unchecked" })
	public static List<String> getStrings(Map<String, Object> map, String key) {
		Map<String, Object> m = resolve(map, key);
		String k = resolveKey(key);
		if(! m.containsKey(k))
			m.put(k, new ArrayList<String>());
		return (List<String>) m.get(k);
	}

	public static String getString(Map<String, Object> map, String key) {
		Map<String, Object> m = resolve(map, key);
		String k = resolveKey(key);
		if(! m.containsKey(k))
			m.put(k, "");
		return (String) m.get(k);
	}

	@SuppressWarnings({ "unchecked" })
	public static List<Long> getLongs(Map<String, Object> map, String key) {
		Map<String, Object> m = resolve(map, key);
		String k = resolveKey(key);
		if(! m.containsKey(k))
			m.put(k, new long[0]);
		return (List<Long>) m.get(k);
	}
	
	public static Long getLong(Map<String, Object> map, String key) {
		Map<String, Object> m = resolve(map, key);
		String k = resolveKey(key);
		if(! m.containsKey(k))
			m.put(k, -1l);
		return Long.valueOf(m.get(k).toString());
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Object> resolve(Map<String, Object> map, String key) {
		String[] keys = key.split("\\.", 2);
		if(keys.length > 1) {
			if(! map.containsKey(keys[0]))
				map.put(keys[0], new HashMap<String, Object>());
			return resolve((Map<String, Object>) map.get(keys[0]), keys[1]);
		} else
			return map;
	}
	
	private static String resolveKey(String key) {
		int ixDot = key.lastIndexOf('.');
		if(ixDot > 0 && ixDot < key.length())
			return key.substring(ixDot+1);
		return key;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMap(Map<String, Object> map, String key) {
		Map<String, Object> m = resolve(map, key);
		String k = resolveKey(key);
		if(! m.containsKey(k))
			m.put(k, new HashMap<String, Object>());
		return (Map<String, Object>) m.get(k);
	}
	
	public static void put(Map<String, Object> map, String key, Object value) {
		Map<String, Object> m = resolve(map, key);
		String k = resolveKey(key);
		m.put(k, value);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> fromString(String map) {
		try {
			return MAPPER.readValue(map, HashMap.class);
		} catch (IOException e) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("json", map);
			return m;
		}
	}
}