package com.github.morinb.errors;

public sealed interface DomainError
        permits FormatError {
    String code();
    Object[] args();
}
