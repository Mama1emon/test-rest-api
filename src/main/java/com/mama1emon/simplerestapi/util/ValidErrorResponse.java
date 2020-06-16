package com.mama1emon.simplerestapi.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ValidErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Boolean status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
