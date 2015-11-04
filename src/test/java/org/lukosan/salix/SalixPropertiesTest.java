package org.lukosan.salix;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SalixPropertiesTest {

	private List<String> multiScopes;
	
	@Before
	public void setup() {
		multiScopes = new ArrayList<String>();
		multiScopes.add("www.mysite.org");
		multiScopes.add("www.yoursite.org");
	}
	
	@Test
	public void testMultisite() {
		
		SalixProperties props = new SalixProperties();
		
		props.setMultisite(true);
		assertThat(props.isMultisite(), is(equalTo(true)));
		
		props.setMultisite(false);
		assertThat(props.isMultisite(), is(equalTo(false)));
		
		props.setScopes(multiScopes);
		assertThat(props.isMultisite(), is(equalTo(true)));
	}
}
