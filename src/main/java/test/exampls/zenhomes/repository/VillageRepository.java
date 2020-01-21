package test.exampls.zenhomes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.exampls.zenhomes.domain.Village;

public interface VillageRepository extends JpaRepository<Village, Integer> {
}
