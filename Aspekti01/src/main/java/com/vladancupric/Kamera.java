package com.vladancupric;

import org.springframework.stereotype.Component;

@Component
public class Kamera{
	
	
	public void fotografisi() {	
		System.out.println("Skljoc");
	}
	public void posaljiFotografiju() {
		System.out.println("Fotografija je poslata");
	}
}
