package br.com.basis.madre.farmacia.service;

import br.com.basis.madre.farmacia.domain.Medicamento;
import br.com.basis.madre.farmacia.domain.Prescricao;
import br.com.basis.madre.farmacia.repository.MedicamentoRepository;
import br.com.basis.madre.farmacia.repository.search.MedicamentoSearchRepository;
import br.com.basis.madre.farmacia.service.dto.MedicamentoDTO;
import br.com.basis.madre.farmacia.service.mapper.MedicamentoMapper;
import joptsimple.internal.Strings;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilterBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link Medicamento}.
 */
@Service
@Transactional
public class MedicamentoService {

    private final Logger log = LoggerFactory.getLogger(MedicamentoService.class);

    private final MedicamentoRepository medicamentoRepository;

    private final MedicamentoMapper medicamentoMapper;

    private final MedicamentoSearchRepository medicamentoSearchRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository, MedicamentoMapper medicamentoMapper, MedicamentoSearchRepository medicamentoSearchRepository) {
        this.medicamentoRepository = medicamentoRepository;
        this.medicamentoMapper = medicamentoMapper;
        this.medicamentoSearchRepository = medicamentoSearchRepository;
    }

    /**
     * Save a medicamento.
     *
     * @param medicamentoDTO the entity to save.
     * @return the persisted entity.
     */
    public MedicamentoDTO save(MedicamentoDTO medicamentoDTO) {
        log.debug("Request to save Medicamento : {}", medicamentoDTO);
        Medicamento medicamento = medicamentoMapper.toEntity(medicamentoDTO);
        medicamento = medicamentoRepository.save(medicamento);
        MedicamentoDTO result = medicamentoMapper.toDto(medicamento);
        medicamentoSearchRepository.save(medicamento);
        return result;
    }

    /**
     * Get all the medicamentos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MedicamentoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Medicamentos");
        return medicamentoRepository.findAll(pageable)
            .map(medicamentoMapper::toDto);
    }


    /**
     * Get one medicamento by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MedicamentoDTO> findOne(Long id) {
        log.debug("Request to get Medicamento : {}", id);
        return medicamentoRepository.findById(id)
            .map(medicamentoMapper::toDto);
    }

    /**
     * Delete the medicamento by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Medicamento : {}", id);
        medicamentoRepository.deleteById(id);
        medicamentoSearchRepository.deleteById(id);
    }

    /**
     * Search for the medicamento corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MedicamentoDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Medicamentos for query {}", query);
        return medicamentoSearchRepository.search(queryStringQuery(query), pageable)
            .map(medicamentoMapper::toDto);
    }

    public Page<Medicamento> findAllElastic(@RequestParam(required = false) String codigo, String Descricao, Pageable pageable) {
        if (Strings.isNullOrEmpty(codigo) && Strings.isNullOrEmpty(Descricao)) {
            NativeSearchQuery nativeSearchQueryBuilder = new NativeSearchQueryBuilder()

                .withSourceFilter(new FetchSourceFilterBuilder().withIncludes
                    ("codigo", "descricao", "concentracao", "unidade", "apresentacao", "tipoMedicamento", "ativo").build())
                .withPageable(PageRequest.of(0, 50))
                .build();

            Page<Medicamento> search = medicamentoSearchRepository.search(nativeSearchQueryBuilder);
            return search;
        }
        NativeSearchQuery nativeSearchQueryFuzzy = new NativeSearchQueryBuilder()

            .withQuery(QueryBuilders.multiMatchQuery(  Descricao,  "descricao")
                .field("descricao").operator(Operator.AND).fuzziness(Fuzziness.ONE).prefixLength(5))
            .withSourceFilter(new FetchSourceFilterBuilder().withIncludes
                ("codigo", "descricao", "concentracao", "unidade", "apresentacao", "tipoMedicamento", "ativo"
            ).build())
            .withPageable(PageRequest.of(0, 20))
            .build();
        Page<Medicamento> queryFuzzy = medicamentoSearchRepository.search(
            nativeSearchQueryFuzzy);

        return queryFuzzy;
    }
    public MedicamentoDTO saveElastic(Medicamento medicamento) {
        log.debug("Request to save Medicamento : {}", medicamento);

        medicamentoSearchRepository.save(medicamento);
        MedicamentoDTO result = medicamentoMapper.toDto(medicamento);
        return result;
    }
}
