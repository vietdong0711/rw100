package com.vti.dto;

import java.util.List;

public class ImportError<T> {
    private T line;// dữ lieju trong row tren file csv
    private List<String> message;// ds loi lien quan

    public ImportError() {
    }

    public ImportError(T line, List<String> message) {
        this.line = line;
        this.message = message;
    }

    public T getLine() {
        return line;
    }

    public void setLine(T line) {
        this.line = line;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
