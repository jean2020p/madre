package br.com.basis.madre.madreexames.repository.search;

import br.com.basis.madre.madreexames.domain.LaboratorioExterno;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link LaboratorioExterno} entity.
 */
public interface LaboratorioExternoSearchRepository extends ElasticsearchRepository<LaboratorioExterno, Long> {
}
