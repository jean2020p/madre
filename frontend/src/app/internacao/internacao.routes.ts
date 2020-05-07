import { ReservaDeLeitoComponent } from './components/reserva-de-leito/reserva-de-leito.component';
import { InternacaoDePacienteComponent } from './components/internacao-de-paciente/internacao-de-paciente.component';
import { Routes } from '@angular/router';
import { SolicitacaoDeInternacaoComponent } from './components/solicitacao-de-internacao/solicitacao-de-internacao.component';
import { SolicitacoesDeInternacaoComponent } from './components/solicitacoes-de-internacao/solicitacoes-de-internacao.component';

export const routes: Routes = [
    {
        path: 'solicitacao-de-internacao',
        component: SolicitacaoDeInternacaoComponent,
    },
    {
        path: 'solicitacoes-de-internacao',
        component: SolicitacoesDeInternacaoComponent,
    },
    {
        path: 'internacao-de-paciente/:id',
        component: InternacaoDePacienteComponent,
    },
    {
        path: 'reserva-de-leito',
        component: ReservaDeLeitoComponent,
    },
];
