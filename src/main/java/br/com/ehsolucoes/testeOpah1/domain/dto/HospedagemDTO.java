package br.com.ehsolucoes.testeOpah1.domain.dto;

import java.util.Date;

public class HospedagemDTO {

    private Integer CityCode;
    private Date Checkin;
    private Date Checkout;
    private Integer QteAdult;
    private Integer QteChild;

    public HospedagemDTO(){}
    public HospedagemDTO(Integer CityCode, Date Checkin, Date Checkout, Integer QteAdult, Integer QteChild){
        this.CityCode = CityCode;
        this.Checkin = Checkin;
        this.Checkout = Checkout;
        this.QteAdult = QteAdult;
        this.QteChild = QteChild;
    }

    public Integer getCityCode() {
        return CityCode;
    }

    public void setCityCode(Integer cityCode) {
        CityCode = cityCode;
    }

    public Date getCheckin() {
        return Checkin;
    }

    public void setCheckin(Date checkin) {
        Checkin = checkin;
    }

    public Date getCheckout() {
        return Checkout;
    }

    public void setCheckout(Date checkout) {
        Checkout = checkout;
    }

    public Integer getQteAdult() {
        return QteAdult;
    }

    public void setQteAdult(Integer qteAdult) {
        QteAdult = qteAdult;
    }

    public Integer getQteChild() {
        return QteChild;
    }

    public void setQteChild(Integer qteChild) {
        QteChild = qteChild;
    }
}
