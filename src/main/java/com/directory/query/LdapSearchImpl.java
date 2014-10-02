package com.directory.query;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.List;
import java.util.jar.Attributes.Name;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.CollectingNameClassPairCallbackHandler;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.SearchExecutor;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.LikeFilter;
import org.springframework.stereotype.Service;

@Service
public class LdapSearchImpl implements LdapSearch {

	
   private LdapTemplate ldapTemplate;

   public void setLdapTemplate(LdapTemplate ldapTemplate) {
      this.ldapTemplate = ldapTemplate;
   }

   public List<Person> searchPerson(String name) {
	 
	  
//	   String myFilter = "";
//		myFilter = "(uid=" + "arunselv" + ")";
//		
//		SearchControls mySearchControls = new SearchControls();
//		mySearchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		
		
		     
      
		
//      return ldapTemplate.search(
//         query().where("objectclass").is("person"),
//         new AttributesMapper<String>() {
//            public String mapFromAttributes(Attributes attrs)
//               throws NamingException {
//               return attrs.get("cn").get().toString();
//            }
//         });
      
		 AndFilter filter = new AndFilter();
	      filter.and(new EqualsFilter("objectclass", "Person"));
	      filter.and(new LikeFilter("cn", "*"+name+"*"));

	      
      List list = ldapTemplate.search("", 
          filter.encode(),
          new AttributesMapper() {
              public Object mapFromAttributes(Attributes attrs) throws NamingException        {
            	  Person p = new Person();

            	  
            	  p.setName (getAttributeValue(attrs,"cn"));
            	  p.setEmail(getAttributeValue(attrs,"mail"));
            	  p.setDescription(getAttributeValue(attrs,"description"));
            	  p.setTelephoneNumber(getAttributeValue(attrs,"telephoneNumber"));
            	  
            	  p.setGivenName(getAttributeValue(attrs,"givenName"));
            	  p.setMobile(getAttributeValue(attrs,"mobile"));
            	  p.setUid(getAttributeValue(attrs,"uid"));
            	  p.setTitle(getAttributeValue(attrs,"title"));
                  return p;
              }
          });
      return list;
   }
   
   private String getAttributeValue(javax.naming.directory.Attributes attrs,String key) throws NamingException
   {
	   Attribute a = attrs.get(key); 
	   if ( a == null)
		   return"";
	   else
		   return a.get().toString();
		   
   }
   
  
   
  
}