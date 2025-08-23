import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;


public class TestMenstrualApp {

    @Test
    public void testForWhenNextPeriodStart() {
        // Arrange
        LocalDate lastPeriodStart = LocalDate.of(2025, 8, 1);
        int averageCycleLength = 28;

        // Act
        MenstrualApp app = new MenstrualApp();
        LocalDate result = app.calculateNextPeriodStart(lastPeriodStart, averageCycleLength);

        // Assert
        assertEquals(LocalDate.of(2025, 8, 29), result);
    }



    @Test
    public void TestForOvulationDate() {
        // Arrange
        LocalDate lastPeriodStart = LocalDate.of(2023, 8, 1);
        int averageCycleLength = 28;

        // Act
        MenstrualApp app = new MenstrualApp();
        LocalDate result = app.calculateOvulationDate(lastPeriodStart, averageCycleLength);

        // Assert
        // Next period = Aug 29, so ovulation should be Aug 15
        assertEquals(LocalDate.of(2023, 8, 15), result);
    }

}
