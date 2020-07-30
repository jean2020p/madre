import { FarmaciaComponent } from './farmacia.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from './../../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Farmacia } from './farmacia.router';
import { DispensacaoComponent } from './dispensacao/dispensacao.component';
import { CadastroMedicamentoComponent } from './cadastro-medicamento/cadastro-medicamento.component';

import { MedicamentosComponent } from './medicamentos/medicamentos.component';
import { DispensacaoMedicamentoComponent } from './dispensacao/dispensacao-medicamento/dispensacao-medicamento.component';
import { EstornoMedicamentoComponent } from './estorno-medicamento/estorno-medicamento.component';
import { EstornoComponent } from './estorno-medicamento/estorno/estorno.component';

@NgModule({
    declarations: [
        FarmaciaComponent,
        DispensacaoComponent,
        MedicamentosComponent,
        CadastroMedicamentoComponent,
        DispensacaoMedicamentoComponent,
        EstornoMedicamentoComponent,
        EstornoComponent,
    ],
    imports: [CommonModule, SharedModule, RouterModule.forChild(Farmacia)],
})
export class FarmaciaModule {}
