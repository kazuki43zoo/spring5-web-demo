package com.example.spring5webdemo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@RestController
public class ImmutableObjectRestController {

	@GetMapping("/immutable")
	Query search(@Validated Query query, BindingResult bindingResult) {
		System.out.println(bindingResult);
		return query;
	}

	public static class Query {

		@NotNull private final String name;
		private final String mail;
		private final String tel;
		private final LocalDate baseDate;

		public Query(String name, String mail, String tel,
				@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate baseDate) {
			this.name = name;
			this.mail = mail;
			this.tel = tel;
			this.baseDate = baseDate;
		}

		public String getName() {
			return name;
		}

		public String getMail() {
			return mail;
		}

		public String getTel() {
			return tel;
		}

		public LocalDate getBaseDate() {
			return baseDate;
		}

	}

}
