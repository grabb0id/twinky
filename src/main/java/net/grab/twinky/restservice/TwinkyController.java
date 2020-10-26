package net.grab.twinky.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwinkyController {
    private static final String template = "A twinky with %s filling";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/twinky")
	public Twinky greeting(@RequestParam(value = "filling", defaultValue = "plain") String name) {
		return new Twinky(counter.incrementAndGet(), String.format(template, name));
	}
}