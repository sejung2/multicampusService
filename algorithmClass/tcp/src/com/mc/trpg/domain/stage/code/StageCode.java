package com.mc.trpg.domain.stage.code;

public enum StageCode {

    DARK_FOREST("깊고 어두운 숲");

    private String desc;

    private StageCode(String desc) {
        this.desc = desc;
    }

    public String desc() {
        return this.desc;
    }
}
