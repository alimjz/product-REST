package com.digipay.productrest.unit;

import com.digipay.productrest.conf.BasicAuthenticationConfig;
import com.digipay.productrest.controller.CustomerController;
import com.digipay.productrest.service.CustomerService;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerUnitTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private CustomerService customerService;

    @MockBean
    private BasicAuthenticationConfig basicAuthenticationConfig;
    private String createdCustomer = "http://localhost:8081/api/v1/customers/2c948a878424ae1a018424ae43060000";

    private final String basicDigestHeaderValue = "Basic " +
            new String(Base64.encodeBase64(("admin:password").getBytes()));

    @Test
    public void customerControllerTest() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(createdCustomer)
                .header("Authorization",basicDigestHeaderValue)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(401, status);
    }
}
