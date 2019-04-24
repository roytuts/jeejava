package com.jeejava.springboot.actuator.endpoint;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeejava.springboot.actuator.vo.Greeting;

@Component
@Endpoint(id = "hello-endpoint")
public class GreetingEndpoint {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@ReadOperation
	public Greeting sayHello(@RequestParam(defaultValue = "Stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
