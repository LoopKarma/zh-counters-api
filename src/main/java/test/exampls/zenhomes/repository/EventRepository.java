package test.exampls.zenhomes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.exampls.zenhomes.domain.Event;
import test.exampls.zenhomes.domain.EventStatus;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
//    List<Event> findAllByStatusOrderByModifiedOnAsc(EventStatus eventStatus);
}
