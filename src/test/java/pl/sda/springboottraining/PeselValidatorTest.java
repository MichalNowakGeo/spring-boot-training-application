package pl.sda.springboottraining;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PeselValidatorTest {

    @ParameterizedTest
    @MethodSource("peselProducer")
    void check(String pesel, boolean isCorrect) {
        PeselValidator peselValidator = new PeselValidator();
        boolean isPeselCorrect = peselValidator.check(pesel);
        Assertions.assertEquals(isPeselCorrect, isCorrect);
    }

    private static Stream<Arguments> peselProducer() {
        return Stream.of(
                Arguments.of("84040287771", true),
                Arguments.of("840402877711", false),
                Arguments.of("ddwdw", false),
                Arguments.of(null, false)
        );
    }

}