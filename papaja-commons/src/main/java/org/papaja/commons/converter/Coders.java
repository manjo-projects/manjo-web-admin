package org.papaja.commons.converter;

import org.papaja.commons.converter.coder.PipeCoder;
import org.papaja.commons.function.Provider;

import java.util.EnumMap;
import java.util.Map;

import static org.papaja.commons.converter.Format.*;

public enum Coders implements Provider<Format, Coder> {

    INSTANCE;

    private static final Map<Format, Coder> CODERS = new EnumMap<>(Format.class);

    static {
        CODERS.put(BASE64, BASE64.getCoder());
        CODERS.put(JAVA_DATE, PipeCoder.of(JAVA_DATE.getCoder(), STRING.getCoder()));
        CODERS.put(RAW, RAW.getCoder());
        CODERS.put(STRING, STRING.getCoder());
        CODERS.put(MAP, MAP.getCoder());
        CODERS.put(LIST, LIST.getCoder());
    }

    @Override
    public Coder get(Format format) {
        return CODERS.containsKey(format) ? CODERS.get(format) : RAW.getCoder();
    }

}
