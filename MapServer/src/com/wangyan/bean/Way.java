package com.wangyan.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Way {
	private Long id_key;
	private String id;
	private int version;
	private Date time;
	private String changeset;
	private String uid;
	private String user;
	
	private Set<WayInfo> infos = new HashSet<>();
	
	private List<Node> nodes = new ArrayList<>();//与Node的多对多关系

	public Way() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Way(String id) {
		super();
		this.id = id;
	}

	public Way(String id, List<Node> nodes) {
		super();
		this.id = id;
		this.nodes = nodes;
	}

	public Long getId_key() {
		return id_key;
	}

	public void setId_key(Long id_key) {
		this.id_key = id_key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public Set<WayInfo> getInfos() {
		return infos;
	}

	public void setInfos(Set<WayInfo> infos) {
		this.infos = infos;
	}
	
	

	@Override
	public String toString() {
		return "Way [id_key=" + id_key + ", id=" + id + ", version=" + version + ", time=" + time + ", changeset="
				+ changeset + ", uid=" + uid + ", user=" + user + "]";
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
		Way other = (Way) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
