package com.wangyan.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Node {

	private Long id_key;
	private String id;
	private double lat;
	private double lon;
	private int version;
	private Date time;
	private String changeset;
	private String uid;
	private String user;

	private Set<NodeInfo> infos = new HashSet<>();// 与NodeInfo的一对多关系

	private Set<Way> ways = new HashSet<>();// 与Way的多对多关系
	
	private Set<ChainNode> chainNodes = new HashSet<>();

	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Node(String id) {
		super();
		this.id = id;
	}

	public Long getId_key() {
		return id_key;
	}

	public void setId_key(Long id_int) {
		this.id_key = id_int;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getChangeset() {
		return changeset;
	}

	public void setChangeset(String changeset) {
		this.changeset = changeset;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Set<NodeInfo> getInfos() {
		return infos;
	}

	public void setInfos(Set<NodeInfo> infos) {
		this.infos = infos;
	}

	@Override
	public String toString() {
		return "Node [id_key="+ id_key + "id=" + id + ", lat=" + lat + ", lon=" + lon + ", version=" + version + ", timestamp=" + time
				+ ", changeset=" + changeset + ", uid=" + uid + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<Way> getWays() {
		return ways;
	}

	public void setWays(Set<Way> ways) {
		this.ways = ways;
	}

	public Set<ChainNode> getChainNodes() {
		return chainNodes;
	}

	public void setChainNodes(Set<ChainNode> chainNodes) {
		this.chainNodes = chainNodes;
	}


}
