package tipservice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.maxqa.TipService;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipServiceTest {

    static Stream<Arguments> tipService_argsProviderFactory() {
        return Stream.of(
                Arguments.of(-1, -1.10),
                Arguments.of(0, 0.00),
                Arguments.of(999, 1098.90),
                Arguments.of(1000, 1050.00),
                Arguments.of(1001, 1051.05)
        );
    }

    @ParameterizedTest(name = "Test #{index}: amount1 is - {0}")
    @MethodSource("tipService_argsProviderFactory")
    public void tipServiceTest_shouldRoundTen(double amountDouble, double expectedDouble) {
        TipService tipService = new TipService();
        BigDecimal resultBigDecimal = tipService.roundTips(BigDecimal.valueOf(amountDouble));
        String result = String.format("%.2f", resultBigDecimal);
        String expected = String.format("%.2f", expectedDouble);
        assertEquals(expected, result);
    }
}
