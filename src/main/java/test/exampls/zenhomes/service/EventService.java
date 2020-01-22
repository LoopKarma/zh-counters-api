package test.exampls.zenhomes.service;

import test.exampls.zenhomes.domain.Event;

import java.util.UUID;

public interface EventService {
    UUID createEvent(Event event);
//    void processUnprocessedEvents();
}
