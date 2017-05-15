package com.example.spring5webdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;

@RestController
public class ReactiveRestController {

	@GetMapping("/reactor/mono")
	Mono<Resource> getMono() {
		return Mono.fromSupplier(() -> new Resource(new Random().nextInt())).subscribeOn(Schedulers.elastic());
	}

	@GetMapping("/reactor/flux")
	Flux<Resource> getFlux() {
		return Flux.from(Flux.range(0, 10)).zipWith(Flux.interval(Duration.ofMillis(500)))
				.map(tuple -> new Resource(tuple.getT1()));
	}

	static class Resource {
		private final int id;

		private Resource(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}

}
