package com.project.domain.model.output;

import com.project.domain.entity.GeneralOEEData;

public class GeneralOEEDataOutput extends GeneralOEEData {

    String line;
    String device;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}

