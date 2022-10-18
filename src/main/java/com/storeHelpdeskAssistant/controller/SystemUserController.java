package com.storeHelpdeskAssistant.controller;

import com.storeHelpdeskAssistant.dto.SystemUserDto;
import com.storeHelpdeskAssistant.model.SystemUser;
import com.storeHelpdeskAssistant.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 @CrossOrigin(origins = "http://localhost:4200" )
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;


    @PostMapping("/systemUsers")
    public SystemUser saveSystemUser(@RequestBody SystemUser systemUser) {

            return systemUserService.saveSystemUser(systemUser);
    }
   @GetMapping("/systemUsers")
    public List<SystemUser> fetchSystemUserList(){

        return systemUserService.fetchSystemUserList();
      }

    @GetMapping("/systemUsers/{id}")
      public SystemUser fetchSystemUserById(@PathVariable("id") int teamMemberOid){
        return systemUserService.fetchSystemUserById(teamMemberOid);
    }
    @DeleteMapping("/systemUsers/{id}")
    public String deleteSystemUserById(@PathVariable("id") int teamMemberOid){
        systemUserService.deleteSystemUserById(teamMemberOid);
        return "SystemUser Deleted Successfully ";
}
    @PutMapping( "/systemUsers/{id}")
    public SystemUser updateSystemUser(@PathVariable("id") int teamMemberOid,
                                       @RequestBody SystemUser systemUser){
        return systemUserService.updateSystemUser(teamMemberOid , systemUser );
    }

    @PostMapping("/authenticateduser")
    public SystemUserDto authenticateSystemUser(@RequestBody SystemUserDto systemUserDto)   {
        String tempUserName = systemUserDto.getUserName();
        String tempPassword = systemUserDto.getPassword();

        SystemUserDto systemUserDtoObj = null;

        if(tempUserName != null && tempPassword != null){
            systemUserDtoObj = systemUserService.fetchSystemUserDtoByUserNameAndPassword(tempUserName, tempPassword );
        }
        return systemUserDtoObj;
    }

//    @GetMapping("/authenticateduser")
//    List<SystemUserDto> findByUserNameAndPassword(@RequestBody String userName, String password) {
//        return systemUserService.fetchByUserNameAndPassword(userName , password);
//    }

//    @PostMapping("/login")
//    public ResponseEntity<SystemUserDto>  loginSystemUser(@RequestBody SystemUserDto systemUserDto){
//        return systemUserService.loginSystemUser(systemUserDto);
//    }



}
