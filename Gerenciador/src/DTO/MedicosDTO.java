package DTO;

public class MedicosDTO extends PessoaDTO{
    private String  especialidade_medicos, turno_medicos;
    private int sala_medicos, id_medicos;
    private double valor_medicos;
    
    public int getId_medicos() {
        return id_medicos;
    }

    public void setId_medicos(int id_medicos) {
        this.id_medicos = id_medicos;
    }
    
    public String getTurno_medicos() {
        return turno_medicos;
    }

    public void setTurno_medicos(String turno_medicos) {
        this.turno_medicos = turno_medicos;
    }

    public String getEspecialidade() {
        return especialidade_medicos;
    }

    public void setEspecialidade(String especialidade_medicos) {
        this.especialidade_medicos = especialidade_medicos;
    }

    public int getSala() {
        return sala_medicos;
    }

    public void setSala(int sala_medicos) {
        this.sala_medicos = sala_medicos;
    }

    public double getValor() {
        return valor_medicos;
    }

    public void setValor(double valor_medicos) {
        this.valor_medicos = valor_medicos;
    }

    
}
