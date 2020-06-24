package org.example.template.model;

import lombok.Getter;
import lombok.Setter;
import org.example.template.model.common.Paging;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Role extends Paging {
    private String role_id;
    private String role_name;

    private List<AccountRole> accountRoleList = new ArrayList<>();
}
