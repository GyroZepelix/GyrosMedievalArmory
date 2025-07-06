package com.dgjalic.gyrosmedievalarmory.animation;

import java.util.HashMap;
import java.util.Map;

public enum AnimationState {
    IDLE((byte) 0),
    QUEUED((byte) 1),
    PLAYING((byte) 2);

    private final byte code;
    private static final Map<Byte, AnimationState> BY_CODE = new HashMap<>();

    AnimationState(byte code) {
        this.code = code;
    }

    public byte toByte() {
        return this.code;
    }

    static {
        for (AnimationState status: values()) {
            BY_CODE.put(status.code, status);
        }
    }

    public static AnimationState fromByte(byte code) {
        AnimationState status = BY_CODE.get(code);
        if (status == null) {
            return IDLE;
        }
        return status;
    }
}
