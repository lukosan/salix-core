package org.lukosan.salix;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public class SalixScopeRegistry {

	@Autowired
	private SalixService salixService;
	
	public Set<String> all() {
		Set<String> scopes = salixService.scopes();
		scopes.add(SalixScope.SHARED);
		return Collections.unmodifiableSet(scopes);
	}
}
