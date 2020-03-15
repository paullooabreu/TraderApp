package com.authapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "permissao")
@Data
@Builder
@EqualsAndHashCode
public class Permissao {	
	@Id
	private Long codigo;
	
	private String Descricao;
	
}
