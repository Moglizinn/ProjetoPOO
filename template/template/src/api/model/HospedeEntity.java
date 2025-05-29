package api.model;

public class HospedeEntity extends BaseEntity {

    private String nome;
    private String telefone;
    private ReservaEntity reserva;


    public HospedeEntity(int id, String nome, String telefone) {
        super(id);
        this.nome = nome;
        this.telefone = telefone;
    }
    public HospedeEntity(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public HospedeEntity() {}

    public String getNome() {
         return nome;
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
         this.telefone = telefone; 
    }

    public ReservaEntity getReserva(){
        return reserva;
    }

    public void setReserva(ReservaEntity reserva)
    {
        this.reserva = reserva;
    }
}