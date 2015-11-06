package org.lukosan.salix;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MasterPublisher implements SalixPublisher {

	private List<SalixPublisher> publishers;
	
	@Autowired
	public MasterPublisher(List<SalixPublisher> publishers) {
		this.publishers = publishers;
	}

	@Override
	public void publish() {
		publishers.forEach(p -> p.publish());
	}
}
