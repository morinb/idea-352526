package com.github.morinb;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorApiWrapper {
    private List<ErrorApi> error;

    public List<ErrorApi> getError() {
        return error;
    }

    public void setError(List<ErrorApi> error) {
        this.error = error;
    }

    public ErrorApiWrapper errors(List<ErrorApi> error) {
        this.error = error;
        return this;
    }
}
