package com.github.morinb;

import com.github.morinb.errors.DomainError;
import com.github.morinb.func.NonEmptyList;

public class ApiException extends RuntimeException {

    private NonEmptyList<DomainError> nonEmptyList;

    public ApiException(NonEmptyList<DomainError> nonEmptyList) {
        this.nonEmptyList = nonEmptyList;
    }

    public NonEmptyList<DomainError> getErrorList() {
        return nonEmptyList;
    }
}
