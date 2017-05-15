package com.example.spring5webdemo;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.google.protobuf.Message;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtobufRestController {

	@PostMapping("/protobuf")
	Message post(@Validated @RequestBody Message message) {
		return message;
	}

	public static class Resource {

		@NotNull private String name;
		private String mail;
		private String tel;
		private LocalDate baseDate;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public LocalDate getBaseDate() {
			return baseDate;
		}

		public void setBaseDate(LocalDate baseDate) {
			this.baseDate = baseDate;
		}

	}

}
