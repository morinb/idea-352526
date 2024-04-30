package com.github.morinb.errors;

import com.github.morinb.ApiException;
import com.github.morinb.func.NonEmptyList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.StaticMessageSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ErrorComputerTest {

    private final StaticMessageSource messageSource = new StaticMessageSource();

    @DisplayName("test compute error")
    @Test
    void testComputeError() {
        messageSource.addMessage("message.code.E0001", Locale.US, "error message E0001 : Format Error");

        final var errorComputer = new ErrorComputer(messageSource);

        ApiException exception = new ApiException(NonEmptyList.of(new FormatError()));
        final var errorApiWrapper = errorComputer.computeErrors(exception);


        assertNotNull(errorApiWrapper);
        assertEquals(1, errorApiWrapper.getError().size());
        final var errorApi = errorApiWrapper.getError().get(0);
        assertNotNull(errorApi);

        assertEquals("E0001", errorApi.getCode());
        assertEquals("error message E0001 : Format Error", errorApi.getMessage());
        assertNotNull(errorApi.getTimestamp());

    }

}