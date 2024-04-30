package com.github.morinb.errors;

public final class FormatError implements DomainError {
    @Override
    public String code() {
        return "E0001";
    }

    @Override
    public Object[] args() {
        return new Object[0];
    }
}
