package tipservice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.maxqa.TipService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

public class TipServiceTest {

    @ParameterizedTest(name = "Test #{index}: amount equals - {0}")
    @CsvSource({
            "-1, -1,1",
            "0, 0",
            "500, 550",
            "999, 1098,9",
            "1000, 1050",
            "1001, 1051,05"
    })
    public void tipServiceTest_shouldRoundTen(BigDecimal amount, BigDecimal expected) {
        TipService tipService = new TipService();
        BigDecimal result = tipService.roundTips(amount);
        assertEquals(result, result);
    }
}
