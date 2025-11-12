package com.santosdevbjj.beerstock.service;

import com.santosdevbjj.beerstock.dto.BeerDTO;
import com.santosdevbjj.beerstock.entity.Beer;
import com.santosdevbjj.beerstock.builder.BeerDTOBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BeerServiceTest {

    @Mock
    private BeerRepository beerRepository;

    @InjectMocks
    private BeerService beerService;

    public BeerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenBeerInformedThenItShouldBeCreated() {
        BeerDTO beerDTO = new BeerDTOBuilder().build();
        Beer beer = new Beer(beerDTO.getId(), beerDTO.getName(), beerDTO.getBrand(), beerDTO.getMax(), beerDTO.getQuantity());

        when(beerRepository.save(beer)).thenReturn(beer);

        BeerDTO createdBeer = beerService.createBeer(beerDTO);

        assertEquals(beerDTO.getName(), createdBeer.getName());
    }

    @Test
    void whenValidNameIsGivenThenReturnBeer() {
        BeerDTO beerDTO = new BeerDTOBuilder().build();
        Beer beer = new Beer(beerDTO.getId(), beerDTO.getName(), beerDTO.getBrand(), beerDTO.getMax(), beerDTO.getQuantity());

        when(beerRepository.findByName(beer.getName())).thenReturn(Optional.of(beer));

        BeerDTO foundBeer = beerService.findByName(beer.getName());

        assertEquals(beerDTO.getName(), foundBeer.getName());
    }
}
