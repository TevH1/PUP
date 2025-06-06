package com.puppyshop.repository;

import com.puppyshop.model.Puppy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuppyRepository extends JpaRepository<Puppy, Long> {}

