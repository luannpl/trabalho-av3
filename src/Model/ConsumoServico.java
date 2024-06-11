package Model;

import java.util.Date;

public class ConsumoServico {
    
    private Servico servico;
    private Reserva reserva;
    private int quantidadeSolicitada;
    private Date dataServico;

    public ConsumoServico(Servico servico, Reserva reserva, int quantidadeSolicitada, Date dataServico) {
        this.servico = servico;
        this.reserva = reserva;
        this.quantidadeSolicitada = quantidadeSolicitada;
        this.dataServico = dataServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public int getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }

    public void setQuantidadeSolicitada(int quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    @Override
    public String toString() {
    return "ConsumoServico{" +
            "servico=" + servico.getCodigo() +
            ", reserva=" + reserva.getCodigo() +
            ", quantidadeSolicitada=" + quantidadeSolicitada +
            ", dataServico=" + dataServico +
            '}';
}
    

    
}
