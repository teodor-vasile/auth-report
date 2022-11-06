package com.teodor.authreport.repostiory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorizationsRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int countAllAuthorizations() {
        return jdbcTemplate
                .queryForObject("SELECT count(*) FROM CUSTOMER_GROUP_USER_ARRANGEMENT_SETTING_SNAPSHOT", Integer.class);
    }

    public int countPaymentRequestAuthorizations() {
        return jdbcTemplate
                .queryForObject("SELECT count(*) FROM CUSTOMER_GROUP_USER_ARRANGEMENT_SETTING_SNAPSHOT cguass WHERE SETTING_NAME = 'Payments:CreditCards:ViewTransaction'", Integer.class);
    }

}
