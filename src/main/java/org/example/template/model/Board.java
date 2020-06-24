package org.example.template.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private String board_id;
    private String board_title;
    private String board_content;
    private Integer board_hits;

    private String account_id;
    private Account account;
}
