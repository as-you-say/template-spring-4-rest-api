package org.example.template.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Account {
    private String id;
    private String password;

    private List<Board> boardList = new ArrayList<>();
    private List<AccountRole> accountRoleList = new ArrayList<>();

    public String[] getRoleNameList(){
        String[] array = new String[accountRoleList.size()];
        int size = accountRoleList.size();
        for (int i=0; i<size; i++) {
            String roleName = accountRoleList.get(i).getRole().getRole_name();
            array[i] = roleName;
        }
        return array;
    }
}
