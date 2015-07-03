package com.pb.dashboard.dao.entity.vitrinametrics;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by vlad
 * Date: 24.03.15_13:52
 */

@Entity
public class SlaCountHour implements SlaCountI, Serializable {

    private static final long serialVersionUID = -3373533709675122222L;
    @Id
    @Column(name = "pkey_interface_sla")
    private int pkeySlaInterface;
    @Id
    @Column(name = "date")
    private int date;
    @Id
    @Column(name = "hour")
    private int hour;
    @Column(name = "cnt")
    private int count;
    @Column(name = "err_cnt")
    private int errorCount;
    @Column(name = "percent")
    private double percent;
    @Transient
    private DateTime dateTime;

    public int getPkeySlaInterface() {
        return pkeySlaInterface;
    }

    @Override
    public DateTime getDateTime() {
        if (dateTime == null) {
            String str = String.valueOf(date);
            dateTime = DateTime.parse(str, DateTimeFormat.forPattern("yyyyMMdd"));
            dateTime = dateTime.withTime(hour, 0, 0, 0);
        }
        return dateTime;
    }

    public int getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int getErrorCount() {
        return errorCount;
    }

    public double getPercent() {
        return percent;
    }

    public void setPkeySlaInterface(int pkeySlaInterface) {
        this.pkeySlaInterface = pkeySlaInterface;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setErrorCount(int countError) {
        this.errorCount = countError;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkeySlaInterface, date, hour, count, errorCount, percent, dateTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final SlaCountHour other = (SlaCountHour) obj;
        return Objects.equals(this.pkeySlaInterface, other.pkeySlaInterface) && Objects.equals(this.date, other.date) && Objects.equals(this.hour, other.hour) && Objects.equals(this.count, other.count) && Objects.equals(this.errorCount, other.errorCount) && Objects.equals(this.percent, other.percent) && Objects.equals(this.dateTime, other.dateTime);
    }
}
