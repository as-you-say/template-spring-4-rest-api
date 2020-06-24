package org.example.template.model.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
    private String pageNo;      // 1 ~ N
    private String pageSize;    // 10, 20, 50

    // MySQL
    private Integer limit;
    private Integer offset;

    public Integer getLimit() {
        return Integer.parseInt(pageSize);
    }

    public Integer getOffset() {
        Integer no = Integer.parseInt(pageNo);
        Integer size = Integer.parseInt(pageSize);
        return (no-1)*size;
    }
}
