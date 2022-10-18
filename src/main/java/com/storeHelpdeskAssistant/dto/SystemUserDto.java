package com.storeHelpdeskAssistant.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//@Builder
public class SystemUserDto {

    private String userName;

    private String password;

    private String accessLevel;

    private Boolean isAuthenticated;
}



