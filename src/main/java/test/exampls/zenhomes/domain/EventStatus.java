package test.exampls.zenhomes.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventStatus {
    IN_PROGRESS(1),
    DONE(2),
    ;

    private final int value;
}
