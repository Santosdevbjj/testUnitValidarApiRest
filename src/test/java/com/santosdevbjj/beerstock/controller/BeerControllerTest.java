package com.santosdevbjj.beerstock.controller;

import com.santosdevbjj.beerstock.dto.BeerDTO;
import com.santosdevbjj.beerstock.service.BeerService;
import com.santosdevbjj.beerstock.builder.BeerDTOBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BeerService beerService;

    @Test
    void whenPOSTIsCalledThenABeerIsCreated() throws Exception {
        BeerDTO beerDTO = new BeerDTOBuilder().build();

        Mockito.when(beerService.createBeer(any(BeerDTO.class))).thenReturn(beerDTO);

        mockMvc.perform(post("/api/v1/beers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Heineken\",\"brand\":\"Heineken\",\"max\":50,\"quantity\":10}"))
                .andExpect(status().isCreated());
    }
}
