package org.xrds.store.api;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.web.bind.annotation.*;
import org.xrds.store.model.LegoSet;
import org.xrds.store.model.LegoSetDifficulty;
import org.xrds.store.persistence.LegoSetRepository;

import java.util.Collection;

@RestController
@RequestMapping("legostore/api")
public class LegoStoreController {
    private LegoSetRepository legoSetRepository;

    public LegoStoreController(LegoSetRepository legoSetRepository) {
        this.legoSetRepository = legoSetRepository;
    }

    @PostMapping
    public void insert(@RequestBody LegoSet legoSet){
        this.legoSetRepository.insert(legoSet);
    }

    @PutMapping
    public void update(@RequestBody LegoSet legoSet){
        this.legoSetRepository.save(legoSet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        this.legoSetRepository.deleteById(id);
    }
}
