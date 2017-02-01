package com.wangyan.bean;

public class NodeInfo {


	private Long id_key;
	private String info_key;
	private String info_value;
	
	private Node node;

	public NodeInfo() {
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

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return "NodeInfo [id_key=" + id_key + ", info_key=" + info_key + ", info_value=" + info_value + "]";
	}

	
	

}
