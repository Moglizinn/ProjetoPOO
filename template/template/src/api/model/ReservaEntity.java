package api.model;

import java.util.Date;

public class ReservaEntity extends BaseEntity {

    private HospedeEntity hospede;
    private Date dataEntrada;
    private Date dataSaida;
    private QuartoEntity quarto;
    private String status;


    public ReservaEntity(int id, String status, HospedeEntity hospede, QuartoEntity quarto, Date dataEntrada, Date dataSaida) {
        super(id);
        status = status;
        hospede = hospede;
        quarto = quarto;
        dataEntrada = dataEntrada;
        dataSaida = dataSaida;
    }

    public ReservaEntity(String status, HospedeEntity hospede, QuartoEntity quarto, Date dataEntrada, Date dataSaida) {
        status = status;
        hospede = hospede;
        quarto = quarto;
        dataEntrada = dataEntrada;
        dataSaida = dataSaida;
    }
    public ReservaEntity(){}

    public HospedeEntity getHospede() { 
        return hospede; 
    }
    public void setHospede(HospedeEntity hospede) { 
        this.hospede = hospede; 
    }

    public Date getDataEntrada() { 
        return dataEntrada; 
    }
    public void setDataEntrada(Date dataEntrada) { 
        this.dataEntrada = dataEntrada; 
    }

    public Date getDataSaida() { 
        return dataSaida; 
    }
    public void setDataSaida(Date dataSaida) { 
        this.dataSaida = dataSaida; 
    }

    public QuartoEntity getQuarto() { 
        return quarto; 
    }
    public void setQuarto(QuartoEntity quarto) { 
        this.quarto = quarto; 
    }

    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }
    @Override
    public String toString() {
        return "Reserva{" + "id=" + getId() + ", status='" + status + '\'' + "'hospede=' "+ hospede + '\'' + "'quarto=' "+ quarto + '\'' +'}';
    }
}
