package com.example.spring5webdemo;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JsonbTests {

	@LocalServerPort private int port;

	@Autowired TestRestTemplate testRestTemplate;

	@Test
	public void testUsingRestTemplate() {
		LocalDate now = LocalDate.now();

		RestOperations restOperations = new RestTemplate();
		Resource request = new Resource();
		request.setName("kazuki43zoo");
		request.setMail("kazuki43zoo@gmail.com");
		request.setTel("09012345678");
		request.setBaseDate(now);

		Resource response = restOperations.postForObject("http://localhost:" + port + "/jsonb", request, Resource.class);

		Assertions.assertThat(response.getName()).isEqualTo("kazuki43zoo");
		Assertions.assertThat(response.getMail()).isEqualTo("kazuki43zoo@gmail.com");
		Assertions.assertThat(response.getTel()).isEqualTo("09012345678");
		Assertions.assertThat(response.getBaseDate()).isEqualTo(now);

	}

	@Test
	public void testUsingTestRestTemplate() {
		LocalDate now = LocalDate.now();

		Resource request = new Resource();
		request.setName("kazuki43zoo");
		request.setMail("kazuki43zoo@gmail.com");
		request.setTel("09012345678");
		request.setBaseDate(now);

		Resource response = testRestTemplate.postForObject("/jsonb", request, Resource.class);

		Assertions.assertThat(response.getName()).isEqualTo("kazuki43zoo");
		Assertions.assertThat(response.getMail()).isEqualTo("kazuki43zoo@gmail.com");
		Assertions.assertThat(response.getTel()).isEqualTo("09012345678");
		Assertions.assertThat(response.getBaseDate()).isEqualTo(now);

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
