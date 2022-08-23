package com.lamp.guide.sdk;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class GuideService {

	private static final Map<String, Map<Class<?>, Class<?>>> OPERATION_CLASS_BY_CLOUD_NAME = new ConcurrentHashMap<>();

	private Map<String, Map<Class<?>, Object>> operationMapByCloudName = new ConcurrentHashMap<>();

	private Map<String, CloudConfig> cloudConfigMap = new ConcurrentHashMap<>();

	public void cloudConfigs(List<CloudConfig> cloudConfigList) {
		for (CloudConfig cloudConfig : cloudConfigList) {
			cloudConfigMap.put(cloudConfig.getConfigName(), cloudConfig);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getOperation(String name, Class<?> clazz) throws InstantiationException, IllegalAccessException {
		Map<Class<?>, Object> operationMap = operationMapByCloudName.get(name);
		if (Objects.isNull(operationMap)) {
			operationMap = operationMapByCloudName.computeIfAbsent(name, key -> new ConcurrentHashMap<>());
		}
		Object object = operationMap.get(clazz);
		if (Objects.isNull(object)) {
			CloudConfig cloudConfig = cloudConfigMap.get(name);
			if (Objects.isNull(cloudConfig)) {

			}
			Map<Class<?>, Class<?>> operationClassMap = OPERATION_CLASS_BY_CLOUD_NAME.get(cloudConfig.getCloudName());
			Class<?> operationClass = operationClassMap.get(clazz);
			object = operationClass.newInstance();
			((Initialization) object).initialization(cloudConfig);
			operationMap.put(clazz, object);
		}
		return (T) object;

	}
}
