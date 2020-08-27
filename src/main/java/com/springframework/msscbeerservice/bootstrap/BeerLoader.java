package com.springframework.msscbeerservice.bootstrap;

import com.springframework.msscbeerservice.domain.Beer;
import com.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObject();
    }

    private void loadBeerObject() {
        if(beerRepository.count()==0)
        {
            beerRepository.save(Beer.builder()
                    .beerName("Mango")
                    .beerStyle("ILP")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Orange")
                    .beerStyle("ILP")
                    .quantityToBrew(300)
                    .minOnHand(10)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("11.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Apple")
                    .beerStyle("IDP")
                    .quantityToBrew(400)
                    .minOnHand(10)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("10.95"))
                    .build());

        }
    }
}
