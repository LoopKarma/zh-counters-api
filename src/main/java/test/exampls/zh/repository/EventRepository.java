package test.exampls.zh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.exampls.zh.domain.Event;
import test.exampls.zh.domain.EventType;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByTypeAndCreatedOnBetweenOrderByCreatedOnAsc(EventType type, Date from, Date to);
}
