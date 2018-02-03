package com.relation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_cat")
public class Cat {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;			//主键、自增
	
	private String name;		//指定对应数据库的列为name

	//set、get方法
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
