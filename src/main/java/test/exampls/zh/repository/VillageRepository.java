package test.exampls.zh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.exampls.zh.domain.Village;

public interface VillageRepository extends JpaRepository<Village, Integer> {
}
