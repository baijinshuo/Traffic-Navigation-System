package com.example.bjmap;

import java.util.Date;


public class nodeInfo {
	private Long id_key;
	private String id;
	private double lat;
	private double lon;
	private int version;
	private Date time;
	private String changeset;
	private String uid;
	private String user;
	
	public String getNodename() {
		return id;
	}
	public void setNodename(String nodename) {
		this.id = nodename;
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
	public Long getId_key() {
		return id_key;
	}
	public void setId_key(Long id_key) {
		this.id_key = id_key;
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

}
