package br.com.basis.madre.madreexames.web.rest;

import br.com.basis.madre.madreexames.service.DiaService;
import br.gov.nuvem.comum.microsservico.web.rest.errors.BadRequestAlertException;
import br.com.basis.madre.madreexames.service.dto.DiaDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing {@link br.com.basis.madre.madreexames.domain.Dia}.
 */
@RestController
@RequestMapping("/api")
public class DiaResource {

    private final Logger log = LoggerFactory.getLogger(DiaResource.class);

    private static final String ENTITY_NAME = "madreexamesDia";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DiaService diaService;

    public DiaResource(DiaService diaService) {
        this.diaService = diaService;
    }

    /**
     * {@code POST  /dias} : Create a new dia.
     *
     * @param diaDTO the diaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new diaDTO, or with status {@code 400 (Bad Request)} if the dia has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dias")
    public ResponseEntity<DiaDTO> createDia(@RequestBody DiaDTO diaDTO) throws URISyntaxException {
        log.debug("REST request to save Dia : {}", diaDTO);
        if (diaDTO.getId() != null) {
            throw new BadRequestAlertException("A new dia cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DiaDTO result = diaService.save(diaDTO);
        return ResponseEntity.created(new URI("/api/dias/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dias} : Updates an existing dia.
     *
     * @param diaDTO the diaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated diaDTO,
     * or with status {@code 400 (Bad Request)} if the diaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the diaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dias")
    public ResponseEntity<DiaDTO> updateDia(@RequestBody DiaDTO diaDTO) throws URISyntaxException {
        log.debug("REST request to update Dia : {}", diaDTO);
        if (diaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DiaDTO result = diaService.save(diaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, diaDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dias} : get all the dias.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dias in body.
     */
    @GetMapping("/dias")
    public ResponseEntity<List<DiaDTO>> getAllDias(Pageable pageable) {
        log.debug("REST request to get a page of Dias");
        Page<DiaDTO> page = diaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dias/:id} : get the "id" dia.
     *
     * @param id the id of the diaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the diaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dias/{id}")
    public ResponseEntity<DiaDTO> getDia(@PathVariable Long id) {
        log.debug("REST request to get Dia : {}", id);
        Optional<DiaDTO> diaDTO = diaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(diaDTO);
    }

    /**
     * {@code DELETE  /dias/:id} : delete the "id" dia.
     *
     * @param id the id of the diaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dias/{id}")
    public ResponseEntity<Void> deleteDia(@PathVariable Long id) {
        log.debug("REST request to delete Dia : {}", id);
        diaService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/dias?query=:query} : search for the dia corresponding
     * to the query.
     *
     * @param query the query of the dia search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/dias")
    public ResponseEntity<List<DiaDTO>> searchDias(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of Dias for query {}", query);
        Page<DiaDTO> page = diaService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
}
