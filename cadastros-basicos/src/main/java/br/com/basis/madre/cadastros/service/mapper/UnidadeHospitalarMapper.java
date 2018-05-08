package br.com.basis.madre.cadastros.service.mapper;

import br.com.basis.madre.cadastros.domain.UnidadeHospitalar;
import br.com.basis.madre.cadastros.service.dto.UnidadeHospitalarDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnidadeHospitalarMapper extends EntityMapper<UnidadeHospitalarDTO, UnidadeHospitalar> {


        default UnidadeHospitalar fromId(Long id) {
            if (id == null) {
                return null;
            }
            UnidadeHospitalar unidadeHospitalar = new UnidadeHospitalar();
            unidadeHospitalar.setId(id);
            return unidadeHospitalar;
        }

    }
