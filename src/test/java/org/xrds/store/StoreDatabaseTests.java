package org.xrds.store;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.xrds.store.model.*;
import org.xrds.store.persistence.LegoSetRepository;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class StoreDatabaseTests {
    @Autowired
    private LegoSetRepository legoSetRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Before
    public void before(){
        this.legoSetRepository.deleteAll();
        PaymentOptions creditCardPayment = new PaymentOptions(PaymentType.CreditCard, 0);
        LegoSet milleniumFalcon = new LegoSet(
                "Millennium Falcon",
                "Star Wars",
                LegoSetDifficulty.HARD,
                new DeliveryInfo(LocalDate.now().plusDays(1), 30, true),
                Arrays.asList(
                        new ProductReview("Dan", 7),
                        new ProductReview("Anna", 10),
                        new ProductReview("John", 8)
                ),
                creditCardPayment);

        LegoSet skyPolice = new LegoSet(
                "Sky Police Air Base",
                "City",
                LegoSetDifficulty.MEDIUM,
                new DeliveryInfo(LocalDate.now().plusDays(3), 50, true),
                Arrays.asList(
                        new ProductReview("Dan", 5),
                        new ProductReview("Andrew", 8)
                ),
                creditCardPayment);

        this.legoSetRepository.insert(milleniumFalcon);
        this.legoSetRepository.insert(skyPolice);
    }
    @Test
    void findAllByGreatReviews_should_return_products_that_have_a_review_with_a_rating_of_ten() {
        List<LegoSet> results = (List<LegoSet>) this.legoSetRepository.findAllByGreatReviews();

        assertEquals(1,results.size());
        assertEquals("Millennium Falcon",results.get(0).getName());
    }
}
