package com.wangyan.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class Dot {

	private String id;
	private Map<Dot, Double> child = new HashMap<Dot, Double>();

	public Dot(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<Dot, Double> getChild() {
		return child;
	}

	public void setChild(Map<Dot, Double> child) {
		this.child = child;
	}

//	public double getDistence() {
//		return distence;
//	}
//
//	public void setDistence(double distence) {
//		this.distence = distence;
//	}
//
//	public boolean isState() {
//		return state;
//	}
//
//	public void setState(boolean state) {
//		this.state = state;
//	}
//
//	@Override
//	public String toString() {
//		return "Dot [id=" + id + ", child=" + child + ", distence=" + distence + ", state=" + state + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dot other = (Dot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}
