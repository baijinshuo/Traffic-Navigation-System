package com.wangyan.bean;

public class RelationInfo {
	private Long id_key;
	private String info_key;
	private String info_value;
	
	private Relation relation;

	public RelationInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_key() {
		return id_key;
	}

	public void setId_key(Long id_key) {
		this.id_key = id_key;
	}

	public String getInfo_key() {
		return info_key;
	}

	public void setInfo_key(String info_key) {
		this.info_key = info_key;
	}

	public String getInfo_value() {
		return info_value;
	}

	public void setInfo_value(String info_value) {
		this.info_value = info_value;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	@Override
	public String toString() {
		return "RelationInfo [id_key=" + id_key + ", info_key=" + info_key + ", info_value=" + info_value + "]";
	}

}
