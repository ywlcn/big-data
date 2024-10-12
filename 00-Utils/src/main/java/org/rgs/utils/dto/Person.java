package org.rgs.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;

    private int id;

    private String name;

}