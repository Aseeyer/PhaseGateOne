import java.time.LocalDate;

public class MenstrualApp {

    public LocalDate calculateNextPeriodStart(LocalDate lastPeriodStart, int cycleLength) {
        return lastPeriodStart.plusDays(cycleLength);
    }


    public LocalDate calculateOvulationDate(LocalDate lastPeriodStart, int averageCycleLength) {
        LocalDate nextPeriod = calculateNextPeriodStart(lastPeriodStart, averageCycleLength);
        return nextPeriod.minusDays(14);
    }

}
