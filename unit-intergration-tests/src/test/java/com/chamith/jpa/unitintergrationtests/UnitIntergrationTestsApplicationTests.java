package com.chamith.jpa.unitintergrationtests;

import com.chamith.jpa.unitintergrationtests.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

@WebMvcTest
@RunWith(SpringRunner.class)
class UnitIntergrationTestsApplicationTests {

	@Autowired
	MockMvc mockMvc ;

	@MockBean
	UserRepo userRepo ;

	@Test
	void contextLoads() throws Exception {

		Mockito.when(userRepo.findAll()).thenReturn(
				Collections.emptyList()
		);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/all/")
						.accept(MediaType.APPLICATION_JSON)
		)
				.andReturn();
		System.out.println(mvcResult.getResponse());
		Mockito.verify(userRepo).findAll();
	}

}
