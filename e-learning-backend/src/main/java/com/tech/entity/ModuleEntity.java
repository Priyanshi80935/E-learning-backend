package com.tech.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tbl_module")
public class ModuleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	private Integer moduleNumber;

	@Lob
	private String description;

	@OneToMany
	List<Video> videos = new ArrayList<>();
}
