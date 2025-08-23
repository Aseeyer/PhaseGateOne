import java.time.LocalDate;

public class MenstrualApp {

    public LocalDate calculateNextPeriodStart(LocalDate lastPeriodStart, int cycleLength) {
        return lastPeriodStart.plusDays(cycleLength);
    }


    public LocalDate calculateOvulationDate(LocalDate lastPeriodStart, int averageCycleLength) {
        LocalDate nextPeriod = calculateNextPeriodStart(lastPeriodStart, averageCycleLength);
        return nextPeriod.minusDays(14);
    }



    public LocalDate[] calculateFertileWindow(LocalDate lastPeriodStart, int averageCycleLength) {
    LocalDate ovulationDay = lastPeriodStart.plusDays(averageCycleLength - 14);

    LocalDate fertileStart = ovulationDay.minusDays(5);
    LocalDate fertileEnd = ovulationDay;

    return new LocalDate[]{fertileStart, fertileEnd};
    }

}
