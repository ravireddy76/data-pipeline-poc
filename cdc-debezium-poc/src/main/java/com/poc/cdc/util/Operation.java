package com.poc.cdc.util;

/**
 * Operation enum to derive the operation type happening in cdc.
 *
 * @author Dataportal Engineering Team
 * @CopyRight (C) All rights reserved to Target Inc. It's Illegal to reproduce this code.
 */
public enum Operation {

    READ("r"),
    CREATE("c"),
    UPDATE("u"),
    DELETE("d");

    private final String code;

    private Operation(String code) {
        this.code = code;
    }

    public String code() {
        return this.code;
    }


    public static Operation forCode(String code) {
        Operation[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            Operation op = var1[var3];
            if (op.code().equalsIgnoreCase(code)) {
                return op;
            }
        }
        return null;
    }

}