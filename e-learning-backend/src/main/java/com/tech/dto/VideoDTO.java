package com.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoDTO {
	private Long id;
    private String name;
    private ModuleDTO moduleDTO;
}
