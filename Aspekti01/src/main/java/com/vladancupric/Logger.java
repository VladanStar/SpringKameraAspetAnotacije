package com.vladancupric;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class Logger {
	
	@Pointcut("execution(void com.vladancupric.Kamera.fotografisi())")
	public void kameraSkljoc() {
		
	}
	@Pointcut("execution(void com.vladancupric.Kamera.posaljiFotografiju())")
	public void kameraSlanje() {
		
	}
	@Before("kameraSkljoc()")
	public void preFotogrfisanja() {
		System.out.println("Fotografija ce upravo biti napravljena");
	}
	@After("kameraSkljoc()")
	public void posleFotografisanja() {
		System.out.println("Fotografija je napravljena");
	}
	
	@After("kameraSlanje()")
	public void fotografijaJePoslata() {
		System.out.println("Fotografija je poslata");
	}
	public void aroundAdvice(ProceedingJoinPoint p) {
		System.out.println("Nalazimo se na pocetku snimanja");
		preFotogrfisanja();
		try {
			p.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("Nalazimo se na zavrsetku fotografisanja");
		posleFotografisanja();
	}

}
