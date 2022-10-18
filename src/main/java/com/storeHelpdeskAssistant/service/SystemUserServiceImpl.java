package com.storeHelpdeskAssistant.service;


import com.storeHelpdeskAssistant.dto.SystemUserDto;
import com.storeHelpdeskAssistant.model.SystemUser;
import com.storeHelpdeskAssistant.repo.SystemUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserRepo SystemUserRepo;

    @Override
    public SystemUser saveSystemUser(SystemUser systemUser) {

        return SystemUserRepo.save(systemUser);
    }

    @Override
    public List<SystemUser> fetchSystemUserList() {
        return SystemUserRepo.findAll();
    }

    @Override
    public SystemUser fetchSystemUserById(int teamMemberOid) {

        return SystemUserRepo.findById(teamMemberOid).get();
    }

    @Override
    public void deleteSystemUserById(int teamMemberOid) {

        SystemUserRepo.deleteById(teamMemberOid);
    }

    @Override
    public SystemUser updateSystemUser(int teamMemberOid, SystemUser systemUser) {

        SystemUser sysDB = SystemUserRepo.findById(teamMemberOid) .get();
        if(Objects.nonNull(systemUser.getName())&&
        !"".equalsIgnoreCase(systemUser.getName())){
            sysDB.setName(systemUser.getName());
        }
        if(Objects.nonNull(systemUser.getAccessLevel())&&
        !"".equalsIgnoreCase(systemUser.getAccessLevel())){
            sysDB.setAccessLevel(systemUser.getAccessLevel());
        }
        if(Objects.nonNull(systemUser.getUserName())&&
        !"".equalsIgnoreCase(systemUser.getUserName())){
            sysDB.setUserName(systemUser.getUserName());
        }
        if(Objects.nonNull(systemUser.getPassword())&&
        !"".equalsIgnoreCase(systemUser.getPassword())){
            sysDB.setPassword(systemUser.getPassword());
        }


        return SystemUserRepo.save(sysDB);
    }

//    @Override
//    public SystemUserDto fetchSystemUserDtoByUserNameAndPassword(String tempUserName, String tempPassword) {
//        return null;
//    }

//    @Override
//    public SystemUserDto fetchSystemUserDtoByUserNameAndPassword(String tempUserName, String tempPassword) {
//        return null;
//    }

//    @Override
//    public ResponseEntity<SystemUserDto> loginSystemUser(SystemUserDto systemUserDto) {
//        SystemUserDto systemUserDto1 =SystemUserRepo.findByUsernameAndPassword(systemUserDto.getUserName());
//        if(systemUserDto1.getPassword().equals(systemUserDto.getPassword()))
//            return ResponseEntity.ok(systemUserDto1);
//        return (ResponseEntity<SystemUserDto>) ResponseEntity.internalServerError();
//    }

//    @Override
//    public SystemUserDto authenticateSystemUser(SystemUserDto systemUserDto) {
//        return null;
//    }

    @Override
    public SystemUserDto fetchSystemUserDtoByUserNameAndPassword(String userName, String password) {
        SystemUser systemUser = SystemUserRepo.findByUserNameAndPassword(userName, password);
        SystemUserDto systemUserDto = new SystemUserDto();

        if(null !=systemUser ){
            systemUserDto.setUserName(systemUser.getUserName());
            systemUserDto.setPassword(systemUser.getPassword());
            systemUserDto.setAccessLevel(systemUser.getAccessLevel());

            systemUserDto.setIsAuthenticated(Boolean.TRUE);

        }
        else{
            systemUserDto.setIsAuthenticated(Boolean.FALSE);
        }
        return  systemUserDto;
    }


}
