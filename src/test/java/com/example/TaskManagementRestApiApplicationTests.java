package com.example;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TaskManagementRestApiApplicationTests {

	@Autowired
    private MockMvc mockMvc;	

	//Add A New Task
	@Test
    public void test_case1() throws Exception {
		
		String dataOne = "{\"taskId\":\"12881\",\"taskHolderName\":\"Joey Tribianni\",\"taskDate\":\"01/04/2021\",\"taskName\":\"Spring Test Case Addition\",\"taskStatus\":\"Completed\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/saveTask")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
	 	
    }
	
	//Get All Tasks
	@Test
    public void test_case2() throws Exception {
		
	 	mockMvc.perform(MockMvcRequestBuilders.get("/allTasks")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$[*].taskHolderName").exists())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
	        	.andReturn();
	 	
    }
	
	//Get A Task By Name
	@Test
	public void test_case3() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getTask")
				.param("name","Joey Tribianni")
				.contentType(MediaType.APPLICATION_JSON)
		 		.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$[0].taskName").value("Spring Test Case Addition"))
		        .andExpect(jsonPath("$[0].taskStatus").value("Completed"))
		        .andReturn();
			
	}
	
	//Edit the Status of the Task
//	@Test
//    public void test_case4() throws Exception {
//		
//		String dataOne = "{\"taskStatus\":\"Not Completed\"}";
//	 	mockMvc.perform(MockMvcRequestBuilders.post("/changeStatus")
//	 			.param("id","12881")
//	 			.contentType(MediaType.APPLICATION_JSON)
//	 			.content(dataOne)
//	 			.accept(MediaType.APPLICATION_JSON))
//	        	.andExpect(status().isOk())
//	        	.andReturn();
//	 	
//    }
	
	//Delete the Task
	@Test
    public void test_case5() throws Exception {
		
	 	mockMvc.perform(MockMvcRequestBuilders.get("/deleteTask")
	 			.param("id","12881")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
	 			
    }


}
