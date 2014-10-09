package com.directory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.*;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.directory.query.LdapSearch;
import com.directory.query.LdapSearchImpl;
import com.directory.query.Person;

@Controller
@EnableAutoConfiguration
@ImportResource("classpath:application-context.xml")
public class SearchController {

	@Autowired
	LdapSearch search;

	@RequestMapping("/search")
    @ResponseBody
    List<Person> home(@RequestParam (value = "name", required = true)String name ) {
    	Assert.notNull(name);
        List<Person> searchResults = search.searchPerson(name);
        return searchResults;
    }

    
    @RequestMapping("/hello")
    @ResponseBody
    public String  hello(@RequestParam (value = "name", required = false)String name ) {
    	String greeting ="";
    	if(StringUtils.isEmpty(name))
    		greeting = "Hello World!";
    	else
    		greeting = "Hello " + name +"!";
    	
    	return greeting;
    }
    
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(SearchController.class, args);
    }
}
