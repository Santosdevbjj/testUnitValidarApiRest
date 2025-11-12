package com.santosdevbjj.beerstock.service;

import com.santosdevbjj.beerstock.dto.BeerDTO;
import com.santosdevbjj.beerstock.entity.Beer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeerService {

    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public BeerDTO createBeer(BeerDTO beerDTO) {
        Beer beer = new Beer(beerDTO.getId(), beerDTO.getName(), beerDTO.getBrand(), beerDTO.getMax(), beerDTO.getQuantity());
        return toDTO(beerRepository.save(beer));
    }

    public List<BeerDTO> listAll() {
        return beerRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public BeerDTO findByName(String name) {
        Optional<Beer> beer = beerRepository.findByName(name);
        return beer.map(this::toDTO).orElseThrow(() -> new RuntimeException("Beer not found"));
    }

    public void deleteById(Long id) {
        beerRepository.deleteById(id);
    }

    private BeerDTO toDTO(Beer beer) {
        return new BeerDTO(beer.getId(), beer.getName(), beer.getBrand(), beer.getMax(), beer.getQuantity());
    }
}
