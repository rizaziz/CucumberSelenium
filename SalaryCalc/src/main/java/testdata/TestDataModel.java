package testdata;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by admin on 10/1/16.
 */
public class TestDataModel implements Serializable{

    private Date date;
    private String state;
    private double gross;
    private String type;
    private String frequency;
    private String status;
    private int allowances;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAllowances() {
        return allowances;
    }

    public void setAllowances(int allowances) {
        this.allowances = allowances;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %10.2f %-20s %-15s %-25s %-10s"  ,date, state, gross, type, frequency, status, allowances);
    }
}
