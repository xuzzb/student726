package com.dcits.myspring.context;

/**
 * bean信息存放
 */

public class XuzzBeanDefination {
    private Class type;
    private String scope;
    private boolean isLazy;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }

    @Override
    public String toString() {
        return "XuzzBeanDefination{" +
                "type=" + type +
                ", scope='" + scope + '\'' +
                ", isLazy=" + isLazy +
                '}';
    }
}
