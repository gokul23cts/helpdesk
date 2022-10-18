package com.storeHelpdeskAssistant.service;

import com.storeHelpdeskAssistant.dto.SystemUserDto;
import com.storeHelpdeskAssistant.model.SystemUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SystemUserService {
    public SystemUser saveSystemUser(SystemUser systemUser);

   public List<SystemUser> fetchSystemUserList();

   public SystemUser fetchSystemUserById(int teamMemberOid);

    public void deleteSystemUserById(int teamMemberOid);

    public SystemUser updateSystemUser(int teamMemberOid, SystemUser systemUser);

  //  public  SystemUserDto fetchSystemUserDtoByUserNameAndPassword(String tempUserName, String tempPassword); 123

    // public ResponseEntity<SystemUserDto> loginSystemUser(SystemUserDto systemUserDto);


    //SystemUserDto authenticateSystemUser(SystemUserDto systemUserDto);

    SystemUserDto fetchSystemUserDtoByUserNameAndPassword(String tempUserName, String tempPassword);
}
