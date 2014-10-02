package com.directory.query;

import java.util.List;

import org.springframework.ldap.core.LdapTemplate;

public interface LdapSearch {

	 public List<Person> searchPerson(String name);
	 
//	   public void setLdapTemplate(LdapTemplate ldapTemplate);
}
