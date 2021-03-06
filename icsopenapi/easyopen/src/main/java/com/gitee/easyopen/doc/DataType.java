package com.gitee.easyopen.doc;

/**
 * 数据类型
 * @author tanghc
 */
public enum DataType {
    BYTE("byte"), SHORT("short"), INT("integer"), LONG("long"), FLOAT("float"), DOUBLE("double")
    , CHAR("char"), BOOLEAN("boolean"), ARRAY("array"), OBJECT("object"),STRING("string"),FILE("file"),DATE("date"),DATETIME("datetime"),UNKNOW("");

    DataType(String v) {
        val = v;
    }

    private String val;

    public String getValue() {
        return this.val;
    }

    public static DataType parse(String name) {
        return DataType.valueOf(DataType.class, name);
    }
}
