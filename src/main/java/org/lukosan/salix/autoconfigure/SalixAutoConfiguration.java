package org.lukosan.salix.autoconfigure;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lukosan.salix.MasterPublisher;
import org.lukosan.salix.SalixPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SalixAutoConfiguration {

	@Configuration
	public static class SalixPublisherConfiguration {

		private static final Log logger = LogFactory.getLog(SalixPublisherConfiguration.class);
		
		@PostConstruct
		public void postConstruct() {
			if(logger.isInfoEnabled())
				logger.info("PostConstruct " + getClass().getSimpleName());
		}

		@Bean
		@Primary
		public SalixPublisher masterPublisher(List<SalixPublisher> publishers) {
			return new MasterPublisher(publishers);
		}
		
	}
	
}