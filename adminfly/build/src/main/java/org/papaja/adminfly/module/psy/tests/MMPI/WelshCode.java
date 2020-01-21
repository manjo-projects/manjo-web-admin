package org.papaja.adminfly.module.psy.tests.MMPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import static java.lang.String.format;
import static java.lang.String.join;

public class WelshCode {

    public String getCode(Map<String, Float> rates) {
        String code = "";

        for (Entry<String, List<String>> entry : collect(glue(collect(rates))).entrySet()) {
            code += format("%s%s", join("", entry.getValue()), entry.getKey());
        }

        return code;
    }

    public Sign getSign(Float rate) {
        Sign current = Sign.T_0;

        for (Sign sign : Sign.values()) {
            if (rate < sign.getValue()) {
                break;
            } else {
                current = sign;
            }
        }

        return current;
    }

    private Map<String, String> glue(Map<Float, List<String>> values) {
        Function<List, String> template = (list) -> list.size() > 1 ? "[%s]" : "%s";
        Map<String, String>    results  = new HashMap<>();

        for (Entry<Float, List<String>> entry : values.entrySet()) {
            results.put(
                    format(template.apply(entry.getValue()), join("", entry.getValue())),
                    getSign(entry.getKey()).getSign()
            );
        }

        return results;
    }

    private <T> Map<T, List<String>> collect(Map<String, T> rates) {
        Map<T, List<String>> map = new HashMap<>();

        rates.forEach((scale, rate) -> {
            if (map.containsKey(rate)) {
                map.get(rate).add(scale);
            } else {
                map.put(rate, new ArrayList<>() {{
                    add(scale);
                }});
            }
        });

        return map;
    }

    enum Sign {

        T_0("?"),
        T_30("#"),
        T_40(":"),
        T_50("/"),
        T_60("–"),
        T_70("'"),
        T_80("\""),
        T_90("*"),
        T_100("**"),
        T_110("!"),
        T_120("!!");

        private String sign;

        Sign(String sign) {
            this.sign = sign;
        }

        public String getSign() {
            return sign;
        }

        public int getValue() {
            return Integer.valueOf(this.name().split("_")[1]);
        }

    }

    public static void main(String[] args) {
        Map<String, Float> rates = new HashMap<>();

        rates.put("1", 34F);
        rates.put("2", 70F);
        rates.put("3", 30F);
        rates.put("4", 88F);
        rates.put("5", 38F);
        rates.put("6", 90F);
        rates.put("7", 95F);
        rates.put("8", 62F);
        rates.put("9", 23F);
        rates.put("0", 44F);

        rates.put("L", 55F);
        rates.put("F", 55F);
        rates.put("K", 100F);

        System.out.println(new WelshCode().getCode(rates));
    }

}
