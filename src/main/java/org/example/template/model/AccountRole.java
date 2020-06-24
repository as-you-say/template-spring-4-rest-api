package org.example.template.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AccountRole {
    private Integer id;
    private Integer account_id;
    private Integer role_id;

    private Account account;
    private Role role;
}
