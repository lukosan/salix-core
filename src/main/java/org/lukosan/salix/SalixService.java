package org.lukosan.salix;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SalixService {

	Set<String> scopes();
	
	default List<SalixConfiguration> allConfigurations() {
		List<SalixConfiguration> configs = new ArrayList<SalixConfiguration>();
		for(String scope : scopes())
			configs.addAll(configurationsIn(scope));
		return configs;
	}
	
	List<SalixConfiguration> configurationsIn(String scope);
	
	List<SalixConfiguration> configurationsFor(String target);
	
	SalixConfiguration configuration(String scope, String target);
	
	SalixConfiguration save(String scope, String target, Map<String, Object> map);
	
	List<SalixUrl> activeUrls();
	
	default List<SalixUrl> allUrls() {
		List<SalixUrl> urls = new ArrayList<SalixUrl>();
		for(String scope : scopes())
			urls.addAll(urlsIn(scope));
		return urls;
	}
	
	List<SalixUrl> urlsIn(String scope);
	
	SalixUrl url(String url, String scope);	
	
	SalixUrl save(SalixUrl salixUrl);

	SalixUrl save(String scope, String url, int status, String view, LocalDateTime published, LocalDateTime removed, Map<String, Object> map);
	
	default List<SalixTemplate> allTemplates() {
		List<SalixTemplate> templates = new ArrayList<SalixTemplate>();
		for(String scope : scopes())
			templates.addAll(templatesIn(scope));
		return templates;
	}

	SalixTemplate template(String name); // relevant anymore?

	SalixTemplate template(String name, String scope);

	SalixTemplate save(String scope, String name, String source);

	SalixResource resource(String sourceId, String scope);

	SalixResource save(String scope, String sourceId, String sourceUri, Map<String, Object> map);
	
	SalixResource save(String scope, String sourceId, String sourceUri, String contentType, String text);
	
	SalixResource save(String scope, String sourceId, String sourceUri, String contentType, byte[] bytes);
	
	default List<SalixResource> allResources() {
		List<SalixResource> resources = new ArrayList<SalixResource>();
		for(String scope : scopes())
			resources.addAll(resourcesIn(scope));
		return resources;
	}

	List<SalixTemplate> templatesIn(String scope);
	
	List<SalixResource> resourcesIn(String scope);
	
}