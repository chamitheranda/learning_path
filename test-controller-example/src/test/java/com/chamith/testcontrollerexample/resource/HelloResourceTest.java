package com.chamith.testcontrollerexample.resource;

import com.chamith.testcontrollerexample.service.HelloService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloResourceTest {

    private MockMvc mockMvc;

    @Mock
    private HelloService helloService ;

    @InjectMocks
    private HelloResource helloResource;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloResource).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello world"));
    }

    @Test
    public void testHelloWorldJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/json").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("greetings")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.value", Matchers.is("Hello World")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.*",Matchers.hasSize(2)));

    }

    //service test

    @Test
    public void testHelloWorldViaService() throws Exception {
        Mockito.when(helloService.hello()).thenReturn("hello chamith");
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/service")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello chamith"));
        Mockito.verify(helloService).hello();
    }

    //test for post method
    @Test
    public void testPost() throws Exception {
        String json = "{\n" +
                "  \"title\": \"Greetings\",\n" +
                "  \"value\": \"Hello World\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/hello/post").contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Greetings")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.value", Matchers.is("Hello World")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.*",Matchers.hasSize(2)));

    }
}