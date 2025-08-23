import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenstrualApp {

    public LocalDate calculateNextPeriodStart(LocalDate lastPeriodStart, int averageCycleLength) {
        return lastPeriodStart.plusDays(averageCycleLength);
    }

    public LocalDate calculateOvulationDate(LocalDate lastPeriodStart, int averageCycleLength) {
        LocalDate nextPeriod = calculateNextPeriodStart(lastPeriodStart, averageCycleLength);
        return nextPeriod.minusDays(14);
    }

    public LocalDate[] calculateFertileWindow(LocalDate lastPeriodStart, int averageCycleLength) {
        LocalDate ovulationDay = calculateOvulationDate(lastPeriodStart, averageCycleLength);
        LocalDate fertileStart = ovulationDay.minusDays(5);
        LocalDate fertileEnd = ovulationDay;
        return new LocalDate[]{fertileStart, fertileEnd};
    }

    public LocalDate calculateOvulationDay(LocalDate lastPeriodStart, int averageCycleLength) {
        return calculateOvulationDate(lastPeriodStart, averageCycleLength);
    }

    public List<LocalDate> calculateSafePeriod(LocalDate lastPeriodStart, int averageCycleLength) {
        List<LocalDate> safeDays = new ArrayList<>();

        LocalDate nextPeriod = calculateNextPeriodStart(lastPeriodStart, averageCycleLength);
        LocalDate ovulationDay = calculateOvulationDate(lastPeriodStart, averageCycleLength);
        LocalDate fertileStart = ovulationDay.minusDays(5);
        LocalDate fertileEnd = ovulationDay;

        LocalDate current = lastPeriodStart.plusDays(4);
        while (current.isBefore(fertileStart)) {
            safeDays.add(current);
            current = current.plusDays(1);
        }

        current = fertileEnd.plusDays(1);
        while (current.isBefore(nextPeriod)) {
            safeDays.add(current);
            current = current.plusDays(1);
        }

        return safeDays;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenstrualApp app = new MenstrualApp();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("==== Welcome to Menstrual Cycle Tracker ====");
        System.out.print("Enter your last period start date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();
        LocalDate lastPeriodStart = LocalDate.parse(inputDate, formatter);

        System.out.print("Enter your average cycle length in days (e.g., 28): ");
        int cycleLength = scanner.nextInt();

        LocalDate nextPeriod = app.calculateNextPeriodStart(lastPeriodStart, cycleLength);
        LocalDate ovulationDay = app.calculateOvulationDay(lastPeriodStart, cycleLength);
        LocalDate[] fertileWindow = app.calculateFertileWindow(lastPeriodStart, cycleLength);
        List<LocalDate> safeDays = app.calculateSafePeriod(lastPeriodStart, cycleLength);

        System.out.println("\n==== Results ====");
        System.out.println("Next Period Start: " + nextPeriod.format(formatter));
        System.out.println("Ovulation Day: " + ovulationDay.format(formatter));
        System.out.println("Fertile Window: " + fertileWindow[0].format(formatter) + " to " + fertileWindow[1].format(formatter));
        System.out.println("Safe Days: ");
        for (LocalDate day : safeDays) {
            System.out.print(day.format(formatter) + " ");
        }

    }
}
