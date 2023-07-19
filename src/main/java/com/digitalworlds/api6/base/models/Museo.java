package com.digitalworlds.api6.base.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Museo {
    private Long count;
    private String next;
    private String previous;
    private MuseoList[] results;
}
