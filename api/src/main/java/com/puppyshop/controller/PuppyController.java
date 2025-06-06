package com.puppyshop.controller;

import com.puppyshop.dto.PuppyDTO;
import com.puppyshop.model.Puppy;
import com.puppyshop.repository.PuppyRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/puppies")
public class PuppyController {

    private final PuppyRepository repo;

    public PuppyController(PuppyRepository repo) {
        this.repo = repo;
    }

    /* ---- DTO <-> Entity mapper (simple for demo) ---- */
    private static Puppy toEntity(PuppyDTO d) {
        Puppy p = new Puppy();
        p.setName(d.name());
        p.setBreed(d.breed());
        p.setPriceUsd(d.priceUsd());
        p.setBirthDate(d.birthDate());
        p.setSex(d.sex());
        return p;
    }

    /* ---- Endpoints ---- */

    @GetMapping
    public List<Puppy> all() {
        return repo.findAll();
    }

    @PostMapping
    public Puppy create(@RequestBody @Valid PuppyDTO dto) {
        return repo.save(toEntity(dto));
    }

    @GetMapping("/{id}")
    public Puppy one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    @PutMapping("/{id}")
    public Puppy update(@PathVariable Long id, @RequestBody @Valid PuppyDTO dto) {
        Puppy p = repo.findById(id).orElseThrow();
        p.setName(dto.name());
        p.setBreed(dto.breed());
        p.setPriceUsd(dto.priceUsd());
        p.setBirthDate(dto.birthDate());
        p.setSex(dto.sex());
        return repo.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

