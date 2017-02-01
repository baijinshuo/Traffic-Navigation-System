package com.wangyan.bean;

public class RelationContent {
	private Long id_key;
	private String type;
	private String id;
	private String role;
	
	private Relation relation;

	public RelationContent(String type, String id) {
		super();
		this.type = type;
		this.id = id;
	}

	public RelationContent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_key() {
		return id_key;
	}

	public void setId_key(Long id_key) {
		this.id_key = id_key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	@Override
	public String toString() {
		return "RelationContent [id_key=" + id_key + ", type=" + type + ", id=" + id + ", role=" + role + "]";
	}

	
	
}
