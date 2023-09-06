package com.mahmoud.fouad.javaStreams;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    String name;
    Integer salary;
    List<String> phoneNo;
    
}
