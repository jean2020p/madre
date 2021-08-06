package br.com.basis.madre.madreexames.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A AtendimentoDiverso.
 */
@Entity
@Table(name = "atendimento_diverso")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "atendimentodiverso")
public class AtendimentoDiverso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAtendimentoDiverso")
    @SequenceGenerator(name = "seqAtendimentoDiverso")
    private Long id;

    @NotNull
    @Column(name = "codigo", nullable = false)
    private Integer codigo;

    @NotNull
    @Column(name = "unidade_executora_id", nullable = false)
    private Integer unidadeExecutoraId;

    @NotNull
    @Column(name = "origem_amostra", nullable = false)
    private String origemAmostra;

    @NotNull
    @Column(name = "tipo_amostra", nullable = false)
    private String tipoAmostra;

    @NotNull
    @Column(name = "identificacao", nullable = false)
    private String identificacao;

    @NotNull
    @Column(name = "data_soro", nullable = false)
    private LocalDate dataSoro;

    @NotNull
    @Column(name = "material", nullable = false)
    private String material;

    @NotNull
    @Column(name = "especialidade_id", nullable = false)
    private Integer especialidadeId;

    @NotNull
    @Column(name = "centro_atividade_id", nullable = false)
    private Integer centroAtividadeId;

    @NotNull
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @NotNull
    @Column(name = "sexo", nullable = false)
    private String sexo;

    @ManyToOne
    @JsonIgnoreProperties(value = "atendimentoDiversos", allowSetters = true)
    private LaboratorioExterno laboratorio;

    @ManyToOne
    @JsonIgnoreProperties(value = "atendimentoDiversos", allowSetters = true)
    private ControleQualidade controle;

    @ManyToOne
    @JsonIgnoreProperties(value = "atendimentoDiversos", allowSetters = true)
    private Cadaver cadaver;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public AtendimentoDiverso codigo(Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getUnidadeExecutoraId() {
        return unidadeExecutoraId;
    }

    public AtendimentoDiverso unidadeExecutoraId(Integer unidadeExecutoraId) {
        this.unidadeExecutoraId = unidadeExecutoraId;
        return this;
    }

    public void setUnidadeExecutoraId(Integer unidadeExecutoraId) {
        this.unidadeExecutoraId = unidadeExecutoraId;
    }

    public String getOrigemAmostra() {
        return origemAmostra;
    }

    public AtendimentoDiverso origemAmostra(String origemAmostra) {
        this.origemAmostra = origemAmostra;
        return this;
    }

    public void setOrigemAmostra(String origemAmostra) {
        this.origemAmostra = origemAmostra;
    }

    public String getTipoAmostra() {
        return tipoAmostra;
    }

    public AtendimentoDiverso tipoAmostra(String tipoAmostra) {
        this.tipoAmostra = tipoAmostra;
        return this;
    }

    public void setTipoAmostra(String tipoAmostra) {
        this.tipoAmostra = tipoAmostra;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public AtendimentoDiverso identificacao(String identificacao) {
        this.identificacao = identificacao;
        return this;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public LocalDate getDataSoro() {
        return dataSoro;
    }

    public AtendimentoDiverso dataSoro(LocalDate dataSoro) {
        this.dataSoro = dataSoro;
        return this;
    }

    public void setDataSoro(LocalDate dataSoro) {
        this.dataSoro = dataSoro;
    }

    public String getMaterial() {
        return material;
    }

    public AtendimentoDiverso material(String material) {
        this.material = material;
        return this;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getEspecialidadeId() {
        return especialidadeId;
    }

    public AtendimentoDiverso especialidadeId(Integer especialidadeId) {
        this.especialidadeId = especialidadeId;
        return this;
    }

    public void setEspecialidadeId(Integer especialidadeId) {
        this.especialidadeId = especialidadeId;
    }

    public Integer getCentroAtividadeId() {
        return centroAtividadeId;
    }

    public AtendimentoDiverso centroAtividadeId(Integer centroAtividadeId) {
        this.centroAtividadeId = centroAtividadeId;
        return this;
    }

    public void setCentroAtividadeId(Integer centroAtividadeId) {
        this.centroAtividadeId = centroAtividadeId;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public AtendimentoDiverso dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public AtendimentoDiverso sexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LaboratorioExterno getLaboratorio() {
        return laboratorio;
    }

    public AtendimentoDiverso laboratorio(LaboratorioExterno laboratorioExterno) {
        this.laboratorio = laboratorioExterno;
        return this;
    }

    public void setLaboratorio(LaboratorioExterno laboratorioExterno) {
        this.laboratorio = laboratorioExterno;
    }

    public ControleQualidade getControle() {
        return controle;
    }

    public AtendimentoDiverso controle(ControleQualidade controleQualidade) {
        this.controle = controleQualidade;
        return this;
    }

    public void setControle(ControleQualidade controleQualidade) {
        this.controle = controleQualidade;
    }

    public Cadaver getCadaver() {
        return cadaver;
    }

    public AtendimentoDiverso cadaver(Cadaver cadaver) {
        this.cadaver = cadaver;
        return this;
    }

    public void setCadaver(Cadaver cadaver) {
        this.cadaver = cadaver;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AtendimentoDiverso)) {
            return false;
        }
        return id != null && id.equals(((AtendimentoDiverso) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AtendimentoDiverso{" +
            "id=" + getId() +
            ", codigo=" + getCodigo() +
            ", unidadeExecutoraId=" + getUnidadeExecutoraId() +
            ", origemAmostra='" + getOrigemAmostra() + "'" +
            ", tipoAmostra='" + getTipoAmostra() + "'" +
            ", identificacao='" + getIdentificacao() + "'" +
            ", dataSoro='" + getDataSoro() + "'" +
            ", material='" + getMaterial() + "'" +
            ", especialidadeId=" + getEspecialidadeId() +
            ", centroAtividadeId=" + getCentroAtividadeId() +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", sexo='" + getSexo() + "'" +
            "}";
    }
}
