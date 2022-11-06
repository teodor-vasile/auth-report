package com.teodor.authreport;

import com.teodor.authreport.repostiory.AuthorizationsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class AuthReportApplication implements CommandLineRunner
{

	private static final Logger log = LoggerFactory.getLogger(AuthReportApplication.class);


	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("authorizationsRepository")
	private AuthorizationsRepository authorizationsRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthReportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		countAuthorizations();

	}

	void countAuthorizations() {

		log.info("[COUNT] Total authorizations: {}", authorizationsRepository.countAllAuthorizations());
		log.info("[COUNT] Total PaymentRequest authorizations: {}", authorizationsRepository.countPaymentRequestAuthorizations());
	}
}
