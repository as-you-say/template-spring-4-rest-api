package org.example.template.model.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
    // MySQL
    private Integer limit;
    private Integer offset;
}
