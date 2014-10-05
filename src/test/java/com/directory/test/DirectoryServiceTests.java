package com.directory.test;



import java.awt.PageAttributes.MediaType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import com.directory.controller.SearchController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SearchController.class)  
@WebAppConfiguration
//@IntegrationTest("server.port:0") 
//@ContextConfiguration(classes = {SearchController.class})
public class DirectoryServiceTests
{
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getDirectoryService() throws Exception
    {
        /*
            This following code will do 'GET' to the web apps
            and also that it has a attribute "user" to "JohnathanMarkSmith"

         */
    	
    	
    	MvcResult result = this.mockMvc.perform(  get("/hello?name=arun"))
        		  .andExpect(status().isOk())
        						  .andReturn()
        				  ;
    	
    	String content = result.getResponse().getContentAsString();
    	
    	Assert.assertTrue(	"require Hello ",StringUtils.countOccurrencesOf(content, "Hello")>0);
    	
    	
    }

	
}