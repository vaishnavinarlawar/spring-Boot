package com.fusiontech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {
	
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/consumser/getName")
	public String getName() {
		
		System.out.println("inside StudentController.getName----9098");
		return "hello Student server port 9098";
	}
	
	@GetMapping("/consumer/getName1")
	public String getName1() {
		System.out.println("inside StudentControllet.getName---9098");
		ResponseEntity<String> output = restTemplate.exchange("http://localhost:9097/getName", HttpMethod.GET, null,
				String.class);
		System.out.println(output);
		if (output.getStatusCodeValue() == 200) {
			System.out.println("responce from producer success");
			String response = output.getBody();
			return response;
		}else {
			System.out.println("response from producer failed");
			String response = output.getBody();
			return response;
		}
	}
		@GetMapping("/consumer/getAllEmploye") 
		public List<Employe>getEmploye(){
			ResponseEntity<List<Employe>> responseEntity = restTemplate.exchange("http://localhost:9097/getAllEmploye",
					HttpMethod.GET, null, new ParameterizedTypeReference<List<Employe>>() {});
		System.out.println(responseEntity);
		return responseEntity.getBody();
			
			
		}		
		
		  @GetMapping("/consumer/getAllEmployeById") public Employe getEmployeById() {
		  String url="http://localhost:9097/getEmployeById/10";
		  ResponseEntity<Employe>responseEntity=restTemplate.exchange(url,
		  HttpMethod.GET,null,new ParameterizedTypeReference<Employe>() { });
		  System.out.println(responseEntity);
		  return responseEntity.getBody(); }
		 
}
	


