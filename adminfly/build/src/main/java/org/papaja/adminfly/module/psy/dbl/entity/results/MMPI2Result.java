package org.papaja.adminfly.module.psy.dbl.entity.results;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrimaryKeyJoinColumn;

import static java.lang.String.format;

abstract public class MMPI2Result extends Result {

    @Column(name = "SCALE_L")
    private Integer scaleL;

    @Column(name = "SCALE_F")
    private Integer scaleF;

    @Column(name = "SCALE_K")
    private Integer scaleK;

    @Column(name = "SCALE_1")
    private Integer scale1;

    @Column(name = "SCALE_2")
    private Integer scale2;

    @Column(name = "SCALE_3")
    private Integer scale3;

    @Column(name = "SCALE_4")
    private Integer scale4;

    @Column(name = "SCALE_5")
    private Integer scale5;

    @Column(name = "SCALE_6")
    private Integer scale6;

    @Column(name = "SCALE_7")
    private Integer scale7;

    @Column(name = "SCALE_8")
    private Integer scale8;

    @Column(name = "SCALE_9")
    private Integer scale9;

    @Column(name = "SCALE_0")
    private Integer scale0;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScaleL() {
        return scaleL;
    }

    public void setScaleL(Integer scaleL) {
        this.scaleL = scaleL;
    }

    public Integer getScaleF() {
        return scaleF;
    }

    public void setScaleF(Integer scaleF) {
        this.scaleF = scaleF;
    }

    public Integer getScaleK() {
        return scaleK;
    }

    public void setScaleK(Integer scaleK) {
        this.scaleK = scaleK;
    }

    public Integer getScale1() {
        return scale1;
    }

    public void setScale1(Integer scale1) {
        this.scale1 = scale1;
    }

    public Integer getScale2() {
        return scale2;
    }

    public void setScale2(Integer scale2) {
        this.scale2 = scale2;
    }

    public Integer getScale3() {
        return scale3;
    }

    public void setScale3(Integer scale3) {
        this.scale3 = scale3;
    }

    public Integer getScale4() {
        return scale4;
    }

    public void setScale4(Integer scale4) {
        this.scale4 = scale4;
    }

    public Integer getScale5() {
        return scale5;
    }

    public void setScale5(Integer scale5) {
        this.scale5 = scale5;
    }

    public Integer getScale6() {
        return scale6;
    }

    public void setScale6(Integer scale6) {
        this.scale6 = scale6;
    }

    public Integer getScale7() {
        return scale7;
    }

    public void setScale7(Integer scale7) {
        this.scale7 = scale7;
    }

    public Integer getScale8() {
        return scale8;
    }

    public void setScale8(Integer scale8) {
        this.scale8 = scale8;
    }

    public Integer getScale9() {
        return scale9;
    }

    public void setScale9(Integer scale9) {
        this.scale9 = scale9;
    }

    public Integer getScale0() {
        return scale0;
    }

    public void setScale0(Integer scale0) {
        this.scale0 = scale0;
    }

    @Override
    public String toString() {
        return format("MMPI2BerezinResult{parent=%s, scaleL=%d, scaleF=%d, scaleK=%d, scale1=%d, scale2=%d, scale3=%d, scale4=%d, scale5=%d, scale6=%d, scale7=%d, scale8=%d, scale9=%d, scale0=%d}",
                super.toString(), scaleL, scaleF, scaleK, scale1, scale2, scale3, scale4, scale5, scale6, scale7, scale8, scale9, scale0);
    }
}
