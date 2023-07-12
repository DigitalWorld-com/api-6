package com.digitalworlds.api6.base.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MuseoResultList {
    private List<MuseoResultDTO> results;

}
