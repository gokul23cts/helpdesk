package com.storeHelpdeskAssistant.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="system_user")
public class SystemUser {

    @Id
  

   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int teamMemberOid;
    private String name;
    private String accessLevel;
    private String userName;
    private String password;

//    public int getTeamMemberOid() {
//        return teamMemberOid;
//    }
//
//    public void setTeamMemberOid(int teamMemberOid) {
//        this.teamMemberOid = teamMemberOid;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAccessLevel() {
//        return accessLevel;
//    }
//
//    public void setAccessLevel(String accessLevel) {
//        this.accessLevel = accessLevel;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public SystemUser(int teamMemberOid, String name, String accessLevel, String userName, String password) {
//        super();
//        this.teamMemberOid = teamMemberOid;
//        this.name = name;
//        this.accessLevel = accessLevel;
//        this.userName = userName;
//        this.password = password;
//    }
//
//    public SystemUser() {
//        super();
//    }
//
//    @Override
//    public String toString() {
//        return "User [teamMemberOid=" + teamMemberOid + ", name=" + name + ", accessLevel=" + accessLevel
//                + ", userName=" + userName + ", password=" + password + "]";
//    }


}
