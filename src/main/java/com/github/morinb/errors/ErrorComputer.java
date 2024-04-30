package com.github.morinb.errors;

import com.github.morinb.ApiException;
import com.github.morinb.ErrorApiWrapper;
import com.github.morinb.ErrorsKt;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ErrorComputer {

    private final MessageSource messageSource;

    public ErrorComputer(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    ErrorApiWrapper computeErrors(final ApiException exception) {
        final var jsonErrors = new ErrorApiWrapper();
        final var logger = LoggerFactory.getLogger(getClass());

        jsonErrors.errors(new ArrayList<>(exception.getErrorList().map(err ->
                ErrorsKt.toErrorApi(logger, err, messageSource)
        ).toFList().toJavaCollection()));

        return jsonErrors;
    }

}
