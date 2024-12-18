package com.tech.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDTO {
	private Long id;
    private String name;
    private Integer moduleNumber;
    private String description;
    Long courseId;
    List<VideoDTO> videos = new ArrayList<>();
}
