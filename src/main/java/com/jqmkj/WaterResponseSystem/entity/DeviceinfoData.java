package com.jqmkj.WaterResponseSystem.entity;

public class DeviceinfoData {

    private Long id;

    private String QN;

    private String ST;

    private String CN;

    private String PW;

    private String MN;

    private Byte Flag;

    private String DataTime;

    private Double w01001;

    private Double w01018;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQN() {
        return QN;
    }

    public void setQN(String QN) {
        this.QN = QN;
    }

    public String getST() {
        return ST;
    }

    public void setST(String ST) {
        this.ST = ST;
    }

    public String getCN() {
        return CN;
    }

    public void setCN(String CN) {
        this.CN = CN;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

    public String getMN() {
        return MN;
    }

    public void setMN(String MN) {
        this.MN = MN;
    }

    public Byte getFlag() {
        return Flag;
    }

    public void setFlag(Byte flag) {
        Flag = flag;
    }

    public String getDataTime() {
        return DataTime;
    }

    public void setDataTime(String dataTime) {
        DataTime = dataTime;
    }

    public Double getW01001() {
        return w01001;
    }

    public void setW01001(Double w01001) {
        this.w01001 = w01001;
    }

    public Double getW01018() {
        return w01018;
    }

    public void setW01018(Double w01018) {
        this.w01018 = w01018;
    }

}