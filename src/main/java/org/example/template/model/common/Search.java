package org.example.template.model.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Search extends Paging {
    private Integer type;
    private String keyword;
}
