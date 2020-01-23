package test.exampls.zenhomes.util;

import lombok.experimental.UtilityClass;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import test.exampls.zenhomes.exception.DurationParsingException;

import java.util.Date;

@UtilityClass
public class DurationParser {
    public Date parseDuration(String duration) {
        PeriodFormatter FORMATTER = new PeriodFormatterBuilder()
                .appendDays()
                .appendSuffix("d")
                .appendHours()
                .appendSuffix("h")
                .appendMinutes()
                .appendSuffix("m")
                .appendSeconds()
                .appendSuffix("s")
                .toFormatter();

        try {
            DateTime now = new DateTime();
            int seconds = Period.parse(duration, FORMATTER).toStandardSeconds().getSeconds();
            DateTime past = now.minusSeconds(seconds);
            return past.toDate();
        } catch (IllegalArgumentException e) {
            throw new DurationParsingException("Invalid duration format provided. " +
                    "Supported formats examples:'10d', '15h', '360m', '60s'");
        }
    }
}
