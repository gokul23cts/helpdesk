package com.storeHelpdeskAssistant.controller;

import com.storeHelpdeskAssistant.model.SystemUser;
import com.storeHelpdeskAssistant.service.SystemUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SystemUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SystemUserService systemUserService;

    private SystemUser systemUser;

    @BeforeEach
    void setUp() {
        systemUser = SystemUser.builder()
                .name("Hari")
                .accessLevel("HD")
                .userName("hari123")
                .password("Hari12")
                .teamMemberOid(13)
                .build();
    }

    @Test
    void saveSystemUser() throws Exception {
        SystemUser inputSystemUser = SystemUser.builder()
                .name("Hari")
                .accessLevel("HD")
                .userName("hari123")
                .password("Hari12")
                .build();

        Mockito.when(systemUserService.saveSystemUser(inputSystemUser))
                .thenReturn(systemUser);

        mockMvc.perform(post("/systemUsers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\t\"name\":\"Hari\",\n" +
                                "\t\"accessLevel\":\"HD\",\n" +
                                "\t\"userName\":\"hari123\"\n" +
                                "\t\"password\":\"Hari12\"\n" +
                                "}"))
                .andExpect(status().isOk());

    }

//    @Test
//    void fetchDepartmentById() throws Exception {
//        Mockito.when(departmentService.fetchDepartmentById(1L))
//                .thenReturn(department);
//
//        mockMvc.perform(get("/departments/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.departmentName").
//                        value(department.getDepartmentName()));
//    }
}