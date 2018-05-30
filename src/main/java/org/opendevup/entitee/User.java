package org.opendevup.entitee;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User implements Serializable {
	
	@Id
	private String usename;
	private String password;
	private boolean actived;
	@ManyToMany
	@JoinTable(name="USERS_ROLES")//Table d'association
	private Collection<Role> roles;
	
	
	public User() {
		super();
	}
	
	public User(String usename, String password, boolean actived) {
		super();
		this.usename = usename;
		this.password = password;
		this.actived = actived;
	}

	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
}
