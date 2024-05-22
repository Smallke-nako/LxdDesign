package com.example.lxd.controller.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.validation.Valid;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class PageRequestApi<T> {
    @Valid
    private T body = null;

    public PageRequestApi() {
    }

    public PageRequestApi(T body) {
        this.body = body;
    }

    public static <T> PageRequestApi<T> instance(T body) {
        return new PageRequestApi(body);
    }

    public T getBody() {
        return this.body;
    }

    public void setBody(final T body) {
        this.body = body;
    }

}
