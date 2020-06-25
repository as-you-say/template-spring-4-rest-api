package org.example.template.model;

import lombok.Getter;
import lombok.Setter;
import org.example.template.model.common.Paging;

@Getter
@Setter
public class Board extends Paging {
    private Long id;
    private String title;
    private String content;
    private int hits;

    private Long account_id;
    private Account account;
}
