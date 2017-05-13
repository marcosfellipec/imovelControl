package br.com.imovelcontrol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Usuario on 09/05/2017.
 */
@MappedSuperclass
public abstract class TemplateFormaPagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private BigDecimal valor;

    private Boolean aguaInclusa;

    private Boolean luzInclusa;

    private Boolean internetInclusa;

    private Boolean iptuIncluso;

    private Boolean possuiCondominio;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Boolean getAguaInclusa() {
        return aguaInclusa;
    }

    public void setAguaInclusa(Boolean aguaInclusa) {
        this.aguaInclusa = aguaInclusa;
    }

    public Boolean getLuzInclusa() {
        return luzInclusa;
    }

    public void setLuzInclusa(Boolean luzInclusa) {
        this.luzInclusa = luzInclusa;
    }

    public Boolean getInternetInclusa() {
        return internetInclusa;
    }

    public void setInternetInclusa(Boolean internetInclusa) {
        this.internetInclusa = internetInclusa;
    }

    public Boolean getIptuIncluso() {
        return iptuIncluso;
    }

    public void setIptuIncluso(Boolean iptuIncluso) {
        this.iptuIncluso = iptuIncluso;
    }

    public Boolean getPossuiCondominio() {
        return possuiCondominio;
    }

    public void setPossuiCondominio(Boolean possuiCondominio) {
        this.possuiCondominio = possuiCondominio;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
