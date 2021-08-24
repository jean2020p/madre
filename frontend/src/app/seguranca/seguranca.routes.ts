import { Routes } from '@angular/router';
import { CargosComponent } from './components/cargos/cargos.component';
import { FormularioGraduacoesComponent } from './components/graduacoes-de-servidores/formulario-graduacoes/formulario-graduacoes.component';
import { GraduacoesDeServidoresComponent } from './components/graduacoes-de-servidores/graduacoes-de-servidores.component';
import { OcupacoesDeCargoComponent } from './components/ocupacoes-de-cargo/ocupacoes-de-cargo.component';
import { FormularioServidorComponent } from './components/servidores/formulario-servidor/formulario-servidor.component';
import { ServidoresComponent } from './components/servidores/servidores.component';
import { VinculosComponent } from './components/vinculos/vinculos.component';

export const routes: Routes = [
    { path: 'servidores', component: ServidoresComponent },
    { path: 'formulario-servidor', component: FormularioServidorComponent },
    { path: 'vinculos', component: VinculosComponent },
    { path: 'ocupacoes-de-cargo', component: OcupacoesDeCargoComponent },
    { path: 'cargos', component: CargosComponent},
    { path: 'graduacoes-de-servidores', component: GraduacoesDeServidoresComponent },
    { path: 'formulario-graduacoes-de-servidores', component: FormularioGraduacoesComponent }
];