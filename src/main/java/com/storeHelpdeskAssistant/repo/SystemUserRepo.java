package com.storeHelpdeskAssistant.repo;

import com.storeHelpdeskAssistant.dto.SystemUserDto;
import com.storeHelpdeskAssistant.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface SystemUserRepo extends JpaRepository <SystemUser, Integer> {
   public SystemUser findByUserNameAndPassword(String userName, String password);

   //SystemUser findByUsernameAndPassword(String userName, String password);


   // public SystemUserDto findByUsernameAndPassword(String userName);
    //List<SystemUserDto> findByUsernameAndPassword(String userName, String password);


    //  List<SystemUserDto> findAll(String userName, String password);

   // public SystemUser findByUsernameAndPassword(String userName , String password);
}
