package com.relation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_house")
public class House {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;			//主键、自增
	
	private String name;

	@OneToMany
	@JoinTable(
			name="tb_cat_house",
			joinColumns=@JoinColumn(name="house_id",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="cat_id",referencedColumnName="id"))
	private List<Cat> cats = new ArrayList<Cat>();
	
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

	public List<Cat> getCats() {
		return cats;
	}

	public void setCats(List<Cat> cats) {
		this.cats = cats;
	}
	
}
