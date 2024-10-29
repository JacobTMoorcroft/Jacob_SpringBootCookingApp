package org.jacob_cooking_service;

import org.jacob_cooking_service.controller.ScheduleController;
import org.jacob_cooking_service.entity.Schedule;
import org.jacob_cooking_service.service.ScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ScheduleControllerTest {
/*
    @Mock
    private MockMvc mockMvc;

    @Mock
    private ScheduleService scheduleService;

    @Autowired
    private ScheduleController scheduleController;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testSaveSchedule() throws Exception {
        Schedule schedule = new Schedule();
        // Set up the schedule properties as needed...

        when(scheduleService.createSchedule(any())).thenReturn(schedule);

        mockMvc.perform(post("/api/schedules")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"days\": {\"id\": 1}, \"profiles\": {\"id\": 2}, \"dishes\": {\"id\": 3}}"))
                .andExpect(status().isOk());
    }

*/
}

