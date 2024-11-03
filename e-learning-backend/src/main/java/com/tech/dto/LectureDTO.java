package com.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LectureDTO {
    private Long id;
    private String name;
    private String designation;
    private String profileImage;
    private String facebook;
    private String insta;
    private String twiter;
}
