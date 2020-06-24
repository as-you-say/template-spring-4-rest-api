package org.example.template.model;

import lombok.Getter;
import lombok.Setter;
import org.example.template.model.common.Paging;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AccountRole extends Paging {
    private Integer id;
    private Integer account_id;
    private Integer role_id;

    private Account account;
    private Role role;
}
