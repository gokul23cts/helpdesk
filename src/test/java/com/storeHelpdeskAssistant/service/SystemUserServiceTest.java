package com.storeHelpdeskAssistant.service;

import com.storeHelpdeskAssistant.dto.SystemUserDto;
import com.storeHelpdeskAssistant.model.SystemUser;
import com.storeHelpdeskAssistant.repo.SystemUserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SystemUserServiceTest {

    @Autowired
    private SystemUserService systemUserService;
    @MockBean
    private SystemUserRepo systemUserRepo;
    @BeforeEach
    void setUp() {

        SystemUser systemUser = SystemUser.builder()
                .teamMemberOid(13)
                .name("Hari")
                .accessLevel("HD")
                .userName("hari123")
                .password("Hari12")
                .build();
        Mockito.when(systemUserRepo.findById(13))
                .thenReturn(Optional.ofNullable(systemUser));

        // .thenReturn(Optional.ofNullable(systemUser));
//        SystemUser systemUserDto =
//                SystemUser.builder()
//                         .userName("hari123")
//                         .password("Hari12")
//                         .build();
        Mockito.when(systemUserRepo.findByUserNameAndPassword("hari123", "Hari12"))
                .thenReturn(systemUser);

    }
    @Test
    @DisplayName("Get Data Based On Valid Systemuser Id")
    public void whenValidSystemUserId_thenSystemUserShouldFound(){
       int teamMemberOid =13;
        SystemUser found=
                systemUserService.fetchSystemUserById(teamMemberOid);
        assertEquals(teamMemberOid, found.getTeamMemberOid());
    }
    @Test
    public void whenValidUsernameAndPassword_ThenDepartmentDtoFound(){
        String userName = "hari123";
        String password = "Hari12";
        SystemUserDto found = systemUserService.fetchSystemUserDtoByUserNameAndPassword(userName , password);

        assertEquals(userName , found.getUserName());
        assertEquals(password , found.getPassword());

    }



}