package org.lukosan.salix;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SalixService {

	Set<String> scopes();
	
	List<SalixConfiguration> allConfigurations();
	
	List<SalixConfiguration> configurationsIn(String scope);
	
	List<SalixConfiguration> configurationsFor(String target);
	
	SalixConfiguration configuration(String scope, String target);
	
	SalixConfiguration save(String scope, String target, Map<String, Object> map);
	
	List<SalixUrl> activeUrls();
	
	List<SalixUrl> allUrls();
	
	List<SalixUrl> urlsIn(String scope);
	
	SalixUrl url(String url);
	
	SalixUrl url(String url, String scope);	
	
	SalixUrl save(SalixUrl salixUrl);

	SalixUrl save(String scope, String url, int status, String view, LocalDateTime published, LocalDateTime removed, Map<String, Object> map);
	
	List<SalixTemplate> allTemplates();

	SalixTemplate template(String name);

	SalixTemplate template(String name, String scope);

	SalixTemplate save(String scope, String name, String source);

	SalixResource resource(String sourceId);
	
	SalixResource resource(String sourceId, String scope);

	SalixResource save(String scope, String sourceId, String sourceUri, Map<String, Object> map);
	
	SalixResource save(String scope, String sourceId, String sourceUri, String contentType, String text);
	
	SalixResource save(String scope, String sourceId, String sourceUri, String contentType, byte[] bytes);
	
	List<SalixResource> allResources();

	List<SalixTemplate> templatesIn(String scope);
	
	List<SalixResource> resourcesIn(String scope);
	
}