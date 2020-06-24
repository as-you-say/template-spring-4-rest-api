package org.example.template.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Account {
    private String account_id;
    private String account_password;

    private List<Board> boardList = new ArrayList<>();
    private List<Role> roleList = new ArrayList<>();

    public String[] getRoleNameList(){
        String[] array = new String[roleList.size()];
        int size = roleList.size();
        for (int i=0; i<size; i++) {
            String roleName = roleList.get(i).getRole_name();
            array[i] = roleName;
        }
        return array;
    }
}
