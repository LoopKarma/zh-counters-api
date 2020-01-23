package test.exampls.zh.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test.exampls.zh.domain.Event;
import test.exampls.zh.repository.EventRepository;


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
    public Integer createEvent(Event event) {
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
