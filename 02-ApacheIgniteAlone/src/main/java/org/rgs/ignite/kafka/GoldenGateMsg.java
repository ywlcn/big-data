package org.rgs.ignite.kafka;


import java.util.Date;

/**
 * goldengatemsg消息体
 * @author: cord
 * @date: 2019/1/19 0:08
 */
public class GoldenGateMsg {

    private String table;

    private String opType;

    private Date opTs;

    private String currentTs;

    private String pos;

    private String before;

    private String after;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public Date getOpTs() {
        return opTs;
    }

    public void setOpTs(Date opTs) {
        this.opTs = opTs;
    }

    public String getCurrentTs() {
        return currentTs;
    }

    public void setCurrentTs(String currentTs) {
        this.currentTs = currentTs;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
