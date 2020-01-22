package test.exampls.zenhomes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import test.exampls.zenhomes.domain.Event;
import test.exampls.zenhomes.domain.EventStatus;
import test.exampls.zenhomes.domain.EventType;
import test.exampls.zenhomes.exception.EventProcessingException;
import test.exampls.zenhomes.repository.EventRepository;
import test.exampls.zenhomes.service.eventprocessor.EventProcessor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
//    private final Map<EventType, EventProcessor> processors;
    private final EventRepository eventRepository;

//    public EventServiceImpl(List<EventProcessor> processors, EventRepository eventRepository) {
//        this.processors = processors.stream().collect(Collectors.toMap(EventProcessor::getSupportedType, identity()));
//        this.eventRepository = eventRepository;
//    }

    @Override
    public UUID createEvent(Event event) {
        log.info("Creating event {}", event);
        Event saved = eventRepository.saveAndFlush(event);

        return saved.getId();
    }

//    @Override
//    public void processUnprocessedEvents() {
//        Collection<Event> notProcessedEvents = eventRepository
//                .findAllByStatusOrderByModifiedOnAsc(EventStatus.IN_PROGRESS);
//
//        notProcessedEvents.forEach(event -> {
//            EventProcessor processor = processors.get(event.getType());
//            try {
//                processor.doProcess(event);
//            } catch (EventProcessingException e) {
//                log.warn("Event processing error. Event({}), exception:'{}'. We will retry", event.getId(), e.getMessage());
//
//                return;
//            }
////            changeStatus(event, EventStatus.DONE);
//        });
//    }

//    private void changeStatus(Event event, EventStatus status) {
//        try {
//            event.setStatus(status);
//            eventRepository.save(event);
//        } catch (ObjectOptimisticLockingFailureException e) {
//            log.debug("Failed to update status {} of event({})", status, event.getId());
//        }
//    }
}
