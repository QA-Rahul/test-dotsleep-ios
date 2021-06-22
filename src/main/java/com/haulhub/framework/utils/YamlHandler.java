package com.haulhub.framework.utils;

import java.io.InputStream;
import java.io.Reader;
import java.util.Map;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

public class YamlHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(YamlHandler.class);
	private String yamlResource;
	private Map<String, Object> yamlMap;
	
	/**
	 * This method is to read data from Yaml files
	 * @param yamlResource
	 */

	public YamlHandler(String yamlResource) {
		this.yamlResource = yamlResource;
		LOGGER.info("Loading {}", yamlResource);
		loadObjectMap();
	}

	public String getData(String token) {
		return getValue(token);
	}

	public Map<String, Object> getYamlValues(String token) {
		return parseMap(yamlMap, token + ".");
	}

	private void loadObjectMap() {
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream(yamlResource);
			Reader doc = new BufferedReader(new InputStreamReader(in));
			Yaml yaml = new Yaml();
			if (Objects.isNull(yamlMap)) {
				yamlMap = (Map<String, Object>) yaml.load(doc);
			}
		} catch (NullPointerException ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
	}

	private String getValue(String token) {
		return getMapValue(yamlMap, token);
	}

	private String getMapValue(Map<String, Object> yamlMap, String token) {
		return parseMap(yamlMap, token).get(token).toString();
	}

	private Map<String, Object> parseMap(Map<String, Object> objectMap, String token) {
		if (token.contains(".")) {
			String[] st = token.split("\\.");
			objectMap = parseMap((Map<String, Object>) objectMap.get(st[0]), token.replace(st[0] + ".", ""));
		}
		return objectMap;
	}
}
