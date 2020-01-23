package test.exampls.zh.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventType {
    COUNTER_UPDATED("counter_updated");

    private final String value;
}
