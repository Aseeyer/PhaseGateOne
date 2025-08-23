import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.List;

public class TestMenstrualApp {

    @Test
    public void testForWhenNextPeriodStart() {
        LocalDate lastPeriodStart = LocalDate.of(2025, 8, 1);
        int averageCycleLength = 28;

        MenstrualApp app = new MenstrualApp();
        LocalDate result = app.calculateNextPeriodStart(lastPeriodStart, averageCycleLength);

        assertEquals(LocalDate.of(2025, 8, 29), result);
    }

    @Test
    public void testForOvulationDate() {
        LocalDate lastPeriodStart = LocalDate.of(2023, 8, 1);
        int averageCycleLength = 28;

        MenstrualApp app = new MenstrualApp();
        LocalDate result = app.calculateOvulationDate(lastPeriodStart, averageCycleLength);

        assertEquals(LocalDate.of(2023, 8, 15), result);
    }

    @Test
    public void testForWhenFertileWindowStartsAndEnds() {
        MenstrualApp app = new MenstrualApp();
        LocalDate lastPeriodStart = LocalDate.of(2023, 1, 1);
        int averageCycleLength = 28;

        LocalDate[] fertileWindow = app.calculateFertileWindow(lastPeriodStart, averageCycleLength);

        assertEquals(LocalDate.of(2023, 1, 10), fertileWindow[0]);
        assertEquals(LocalDate.of(2023, 1, 15), fertileWindow[1]);
    }

    @Test
    public void testForWhenOvulationDayOccurs() {
        LocalDate lastPeriodStart = LocalDate.of(2025, 8, 1);
        int averageCycleLength = 28;
        MenstrualApp app = new MenstrualApp();

        LocalDate result = app.calculateOvulationDay(lastPeriodStart, averageCycleLength);

        assertEquals(LocalDate.of(2025, 8, 15), result);
    }

    @Test
    public void testForSafePeriod() {
        LocalDate lastPeriodStart = LocalDate.of(2025, 8, 1);
        int averageCycleLength = 28;
        MenstrualApp app = new MenstrualApp();

        List<LocalDate> safeDays = app.calculateSafePeriod(lastPeriodStart, averageCycleLength);

        assertTrue(safeDays.contains(LocalDate.of(2025, 8, 5))); 
        assertTrue(safeDays.contains(LocalDate.of(2025, 8, 25))); 
    }
}
