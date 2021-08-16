package com.example.multimodule.crmservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.example.multimodule.db.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
public class DemoMasterDataIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveCustomer() throws Exception {

        Customer customer = new Customer();
        customer.setFirstName("Lasath");
        customer.setLastName("Jay");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(customer);

        this.mockMvc.perform(post("/crm")
            .content(json)
                                 .contentType(MediaType.APPLICATION_JSON))

                    .andDo(print())
                    .andExpect(status().isOk());

    }

}
