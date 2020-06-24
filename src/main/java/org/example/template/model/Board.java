package org.example.template.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private String id;
    private String title;
    private String content;
    private Integer hits;

    private String account_id;
    private Account account;
}
