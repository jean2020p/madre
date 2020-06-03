package br.com.basis.madre.domain.evento;

import br.com.basis.madre.domain.Triagem;
import br.com.basis.madre.domain.enumeration.TipoDeMutacao;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@Builder
public class EventoTriagem implements Serializable {
    private Triagem triagem;
    private ZonedDateTime dataDeLancamento = ZonedDateTime.now(ZoneId.systemDefault());
    private TipoDeMutacao tipoDoEvento;
}
