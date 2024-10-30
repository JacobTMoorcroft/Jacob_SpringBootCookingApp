package org.jacob_cooking_service;

import org.jacob_cooking_service.controller.DaysController;
import org.jacob_cooking_service.controller.ScheduleController;
import org.jacob_cooking_service.entity.Days;
import org.jacob_cooking_service.entity.Schedule;
import org.jacob_cooking_service.service.DaysService;
import org.jacob_cooking_service.service.ScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = DaysController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class DaysControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DaysService daysService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void ScheduleController_createSchedule_ReturnCreated() throws Exception {
        Days days = new Days();

        // Set up the schedule properties as needed...

        when(daysService.saveDays(any())).thenReturn(days);
        String jsonContent = "{\"day_name\": \"Tuesday\"}";

        mockMvc.perform(post("/api/days")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk());
    }


}