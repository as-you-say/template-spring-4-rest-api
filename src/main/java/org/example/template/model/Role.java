package org.example.template.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {
    private String role_id;
    private String role_name;

    private String account_id;
    private Account account;
}
