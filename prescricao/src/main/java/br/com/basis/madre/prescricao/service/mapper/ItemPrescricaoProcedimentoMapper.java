package br.com.basis.madre.prescricao.service.mapper;

import br.com.basis.madre.prescricao.domain.*;
import br.com.basis.madre.prescricao.service.dto.ItemPrescricaoProcedimentoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ItemPrescricaoProcedimento} and its DTO {@link ItemPrescricaoProcedimentoDTO}.
 */
@Mapper(componentModel = "spring", uses = {TipoProcedimentoMapper.class, PrescricaoProcedimentoMapper.class})
public interface ItemPrescricaoProcedimentoMapper extends EntityMapper<ItemPrescricaoProcedimentoDTO, ItemPrescricaoProcedimento> {

    @Mapping(source = "tipoProcedimento.id", target = "tipoProcedimentoId")
    @Mapping(source = "prescricaoProcedimento.id", target = "prescricaoProcedimentoId")
    ItemPrescricaoProcedimentoDTO toDto(ItemPrescricaoProcedimento itemPrescricaoProcedimento);

    @Mapping(source = "tipoProcedimentoId", target = "tipoProcedimento")
    @Mapping(source = "prescricaoProcedimentoId", target = "prescricaoProcedimento")
    ItemPrescricaoProcedimento toEntity(ItemPrescricaoProcedimentoDTO itemPrescricaoProcedimentoDTO);

    default ItemPrescricaoProcedimento fromId(Long id) {
        if (id == null) {
            return null;
        }
        ItemPrescricaoProcedimento itemPrescricaoProcedimento = new ItemPrescricaoProcedimento();
        itemPrescricaoProcedimento.setId(id);
        return itemPrescricaoProcedimento;
    }
}
