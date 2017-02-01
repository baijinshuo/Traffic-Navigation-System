package com.wangyan.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Relation {
	private Long id_key;
	private String id;
	private int version;
	private Date time;
	private String changeset;
	private String uid;
	private String user;

	private Set<RelationInfo> infos = new HashSet<>();
	
	private List<RelationContent> contents = new ArrayList<>();
	
	public Relation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Relation(String id) {
		super();
		this.id = id;
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

	public Set<RelationInfo> getInfos() {
		return infos;
	}

	public void setInfos(Set<RelationInfo> infos) {
		this.infos = infos;
	}

	public List<RelationContent> getContents() {
		return contents;
	}

	public void setContents(List<RelationContent> contents) {
		this.contents = contents;
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
		Relation other = (Relation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Relation [id_key=" + id_key + ", id=" + id + ", version=" + version + ", time=" + time + ", changeset="
				+ changeset + ", uid=" + uid + ", user=" + user + "]";
	}


}
