package com.rgs.ignite.hello.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AddNumbersTaskArg implements Serializable {
    private int number1;
    private int number2;
}
