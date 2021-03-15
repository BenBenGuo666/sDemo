package com.iSpringboot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author GuoBenben
 * @version 2021/02/02
 */
public class UniqueTimestamp {

    public static final char PRECISION_MILLISECOND = 'S';
    public static final char PRECISION_SECOND = 's';
    public static final char PRECISION_MINUTE = 'm';
    private char precision = 'S';
    private long ts = -1L;

    public UniqueTimestamp() {}

    public UniqueTimestamp(char prec) {
        if ((prec != 'S') && (prec != 's') && (prec != 'm')) {
            throw new IllegalArgumentException("Illegal argument for UniqueTimestamp. Only 'S', 's','m' can be used.");
        }
        this.precision = prec;
    }

    public synchronized long getUniqueTimestamp() {
        if (this.ts == -1L) {
            this.ts = getCurrentTimeValue();
        } else {
            long t = getCurrentTimeValue();
            if (t <= this.ts) {
                this.ts += 1L;
            } else {
                this.ts = t;
            }
        }
        return getReturnValue(this.ts);
    }

    private long getCurrentTimeValue() {
        long ts;
        switch (this.precision) {
            case 'S':
            default:
                ts = System.currentTimeMillis();
                break;
            case 's':
                ts = System.currentTimeMillis() / 1000L;
                break;
            case 'm':
                ts = System.currentTimeMillis() / 60000L;
        }
        return ts;
    }

    private long getReturnValue(long ts) {
        switch (this.precision) {
            case 'S':
            default:
                return ts * 60000L;
            case 's':
                return ts * 1000L;
        }
    }

    public static void get16UUID(){
        // 1.开头两位，标识业务代码或机器代码（可变参数）
        String machineId = "11";
        // 2.中间四位整数，标识日期
        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        String dayTime = sdf.format(new Date());
        int valueOf = (int)((Math.random()*9+1)*1000);
        // 3.生成uuid的hashCode值
        int hashCode = UUID.randomUUID().toString().hashCode();
        // 4.可能为负数
        if(hashCode < 0){
            hashCode = -hashCode;
        }
        // 5.算法处理: 0-代表前面补充0; 10-代表长度为10; d-代表参数为正数型
        String value = machineId + dayTime + String.format("%010d", hashCode);
//        String value = machineId + valueOf + String.format("%010d", hashCode);
        System.out.println(value);
    }

    public static void main(String[] args) {
//        UniqueTimestamp.get16UUID();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(d));
    }

}
