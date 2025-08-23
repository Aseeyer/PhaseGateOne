import java.time.LocalDate;

public class MenstrualApp {

    public LocalDate calculateNextPeriodStart(LocalDate lastPeriodStart, int cycleLength) {
        return lastPeriodStart.plusDays(cycleLength);
    }
}
