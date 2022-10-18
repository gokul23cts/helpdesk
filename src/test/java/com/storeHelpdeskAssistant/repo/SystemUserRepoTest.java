package com.storeHelpdeskAssistant.repo;

import com.storeHelpdeskAssistant.model.SystemUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SystemUserRepoTest {

    @Autowired
    private SystemUserRepo systemUserRepo;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        SystemUser systemUser =
                SystemUser.builder()
                        .name("Mechanical Engineering")
                        .accessLevel("ME - 011")
                        .userName("Delhi")
                        .password("asdf")
                        .build();

        entityManager.persist(systemUser);
    }

    @Test
    public void whenFindById_thenSystemUser() {
        SystemUser systemUser = systemUserRepo.findById(13).get();
        assertEquals(systemUser.getName(), "Mechanical Engineering");
    }
}