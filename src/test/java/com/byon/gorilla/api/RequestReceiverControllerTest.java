package com.byon.gorilla.api;

import org.hamcrest.core.StringContains;
import org.junit.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest

public class RequestReceiverControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void health_endpoint_is_up() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(content().string(StringContains.containsString("up")));
    }

    @Test
    public void hit_graphql_server() throws Exception {
        mockMvc.perform(get("/request"))
                .andExpect(status().isOk());
    }
}
