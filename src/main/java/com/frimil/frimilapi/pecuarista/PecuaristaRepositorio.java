package com.frimil.frimilapi.pecuarista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecuaristaRepositorio extends JpaRepository<Pecuarista, Long> {
}
