package test.exampls.zenhomes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.exampls.zenhomes.domain.Counter;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Integer> {
}
