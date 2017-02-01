package com.wangyan.bean;

public class ChainNode {
	private Integer id;
	private String nodeId;
	private Double length;
	
	private Node node;

	public String getNodeId() {
		return nodeId;
	}

	public ChainNode(String nodeId, Double length) {
		super();
		this.nodeId = nodeId;
		this.length = length;
	}

	public ChainNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "ChainNode [nodeId=" + nodeId + ", length=" + length + "]";
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
