package org.rgs.domain;

import lombok.Data;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;

@Data
public class Grade implements Serializable{
    @QuerySqlField
    private Integer studId;

    @QuerySqlField
    private Double grade;

}
