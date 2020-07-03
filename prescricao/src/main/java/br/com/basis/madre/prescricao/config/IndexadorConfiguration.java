package br.com.basis.madre.prescricao.config;

import br.com.basis.madre.prescricao.domain.*;
import br.com.basis.madre.prescricao.repository.*;
import br.com.basis.madre.prescricao.repository.search.*;
import br.com.basis.madre.prescricao.web.rest.ListaMedicamentoResource;
import br.gov.nuvem.comum.microsservico.service.reindex.Indexador;
import br.gov.nuvem.comum.microsservico.service.reindex.IndexadorSemMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

@AllArgsConstructor
@Configuration
public class IndexadorConfiguration {

    private final ElasticsearchOperations elasticsearchOperations;

    private final DiluenteRepository diluenteRepository;
    private final DiluenteSearchRepository diluenteSearchRepository;

    private final ItemPrescricaoDietaRepository itemPrescricaoDietaRepository;
    private final ItemPrescricaoDietaSearchRepository itemPrescricaoDietaSearchRepository;

    private final ItemPrescricaoMedicamentoRepository itemPrescricaoMedicamentoRepository;
    private final ItemPrescricaoMedicamentoSearchRepository itemPrescricaoMedicamentoSearchRepository;

    private final PrescricaoDietaRepository prescricaoDietaRepository;
    private final PrescricaoDietaSearchRepository prescricaoDietaSearchRepository;

    private final PrescricaoMedicamentoRepository prescricaoMedicamentoRepository;
    private final PrescricaoMedicamentoSearchRepository prescricaoMedicamentoSearchRepository;

    private final TipoAprazamentoRepository tipoAprazamentoRepository;
    private final TipoAprazamentoSearchRepository tipoAprazamentoSearchRepository;

    private final TipoItemDietaRepository tipoItemDietaRepository;
    private final TipoItemDietaSearchRepository tipoItemDietaSearchRepository;

    private final TipoMedicamentoRepository tipoMedicamentoRepository;
    private final TipoMedicamentoSearchRepository tipoMedicamentoSearchRepository;

    private final TipoUnidadeDietaRepository tipoUnidadeDietaRepository;
    private final TipoUnidadeDietaSearchRepository tipoUnidadeDietaSearchRepository;

    private final UnidadeDoseRepository unidadeDoseRepository;
    private final UnidadeDoseSearchRepository unidadeDoseSearchRepository;

    private final UnidadeInfusaoRepository unidadeInfusaoRepository;
    private final UnidadeInfusaoSearchRepository unidadeInfusaoSearchRepository;

    private final ViasAdministracaoRepository viasAdministracaoRepository;
    private final ViasAdministracaoSearchRepository viasAdministracaoSearchRepository;

    @Bean
    public Indexador indexadorDiluente() {
        return IndexadorSemMapper.<Diluente, Long>builder()
            .codigo("diluente")
            .descricao("Diluente")
            .jpaRepository(diluenteRepository)
            .elasticsearchClassRepository(diluenteSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

    @Bean
    public Indexador indexadorItemPrescricaoDieta() {
        return IndexadorSemMapper.<ItemPrescricaoDieta, Long>builder()
            .codigo("itemprescricaodieta")
            .descricao("Item prescrição dieta")
            .jpaRepository(itemPrescricaoDietaRepository)
            .elasticsearchClassRepository(itemPrescricaoDietaSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

    @Bean
    public Indexador indexadorItemPrescricaoMedicamento() {
        return IndexadorSemMapper.<ItemPrescricaoMedicamento, Long>builder()
            .codigo("itemprescricaomedicamento")
            .descricao("Item prescrição medicamento")
            .jpaRepository(itemPrescricaoMedicamentoRepository)
            .elasticsearchClassRepository(itemPrescricaoMedicamentoSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

    @Bean
    public Indexador indexadorPrescricaoDieta() {
        return IndexadorSemMapper.<PrescricaoDieta, Long>builder()
            .codigo("prescricaodieta")
            .descricao("Prescrição dieta")
            .jpaRepository(prescricaoDietaRepository)
            .elasticsearchClassRepository(prescricaoDietaSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

    @Bean
    public Indexador indexadorPrescricaoMedicamento() {
        return IndexadorSemMapper.<PrescricaoMedicamento, Long>builder()
            .codigo("prescricaomedicamento")
            .descricao("Prescrição medicamento")
            .jpaRepository(prescricaoMedicamentoRepository)
            .elasticsearchClassRepository(prescricaoMedicamentoSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

    @Bean
    public Indexador indexadorTipoAprazamento() {
        return IndexadorSemMapper.<TipoAprazamento, Long>builder()
            .codigo("tipoaprazamento")
            .descricao("Tipo aprazamento")
            .jpaRepository(tipoAprazamentoRepository)
            .elasticsearchClassRepository(tipoAprazamentoSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

    @Bean
    public Indexador indexadorTipoItemDieta() {
        return IndexadorSemMapper.<TipoItemDieta, Long>builder()
            .codigo("tipoitemdieta")
            .descricao("Tipo item dieta")
            .jpaRepository(tipoItemDietaRepository)
            .elasticsearchClassRepository(tipoItemDietaSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

    @Bean
    public Indexador indexadorTipoMedicamento() {
        return IndexadorSemMapper.<TipoMedicamento, Long>builder()
            .codigo("tipomedicamento")
            .descricao("Tipo de medicamento")
            .jpaRepository(tipoMedicamentoRepository)
            .elasticsearchClassRepository(tipoMedicamentoSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

    @Bean
    public Indexador indexadorTipoUnidadeDieta() {
        return IndexadorSemMapper.<TipoUnidadeDieta, Long>builder()
            .codigo("tipounidadedieta")
            .descricao("Tipo unidade dieta")
            .jpaRepository(tipoUnidadeDietaRepository)
            .elasticsearchClassRepository(tipoUnidadeDietaSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

    @Bean
    public Indexador indexadorUnidadeDose() {
        return IndexadorSemMapper.<UnidadeDose, Long>builder()
            .codigo("unidadedose")
            .descricao("Unidade dose")
            .jpaRepository(unidadeDoseRepository)
            .elasticsearchClassRepository(unidadeDoseSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

    @Bean
    public Indexador indexadorUnidadeInfusao() {
        return IndexadorSemMapper.<UnidadeInfusao, Long>builder()
            .codigo("unidadeinfusao")
            .descricao("Unidade infusão")
            .jpaRepository(unidadeInfusaoRepository)
            .elasticsearchClassRepository(unidadeInfusaoSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

    @Bean
    public Indexador indexadorViasAdministracao() {
        return IndexadorSemMapper.<ViasAdministracao, Long>builder()
            .codigo("viasadministracao")
            .descricao("Vias administração")
            .jpaRepository(viasAdministracaoRepository)
            .elasticsearchClassRepository(viasAdministracaoSearchRepository)
            .elasticsearchOperations(elasticsearchOperations)
            .build();
    }

}
