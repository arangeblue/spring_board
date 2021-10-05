package com.orangeblue.myboard.controller;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
    

@SpringBootTest
@AutoConfigureMockMvc
@NoArgsConstructor
@Slf4j
@Transactional
public class BoardApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    public void api_with_findByTitle() throws Exception {

        ResultActions testResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/api/boards?title=wer").contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> {
                    MockHttpServletResponse response = result.getResponse();
                    log.info(response.getContentAsString());
                });

        log.info(testResult.toString());
    }


    



}

    