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
    private Long courseId;
    private Long moduleId;
    private String content;
    private Long videoNumber;
    private String description;
    private String originalFileName;
}
