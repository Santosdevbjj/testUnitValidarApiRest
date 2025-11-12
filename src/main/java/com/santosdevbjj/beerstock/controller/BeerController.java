package com.santosdevbjj.beerstock.controller;

import com.santosdevbjj.beerstock.dto.BeerDTO;
import com.santosdevbjj.beerstock.service.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/beers")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @PostMapping
    public ResponseEntity<BeerDTO> createBeer(@RequestBody BeerDTO beerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(beerService.createBeer(beerDTO));
    }

    @GetMapping
    public List<BeerDTO> listBeers() {
        return beerService.listAll();
    }

    @GetMapping("/{name}")
    public BeerDTO findByName(@PathVariable String name) {
        return beerService.findByName(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        beerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
