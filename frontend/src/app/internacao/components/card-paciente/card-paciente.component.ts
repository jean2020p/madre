import { Component, Input, OnInit } from '@angular/core';
import { Paciente } from '@internacao/models/paciente';
import { PacienteService } from '@internacao/services/paciente.service';

@Component({
    selector: 'app-card-paciente',
    template: `
        <div class="p-grid p-fluid">
            <p-fieldset legend="Paciente">
                <div class="p-col-12 p-grid">
                    <div class="p-md-4">
                        <label>Prontuário</label>
                        <input pInputText [value]="this.getProntuario()" />
                    </div>
                    <div class="p-md-8">
                        <label>Nome do Paciente</label>
                        <input pInputText [value]="this.getNomeDoPaciente()" />
                    </div>
                </div>
            </p-fieldset>
        </div>
    `,
})
export class CardPacienteComponent implements OnInit {
    /**
     * TODO: Deve ser substituído por 'prontuário'
     */
    @Input() private prontuario: number;

    private paciente: Paciente;

    constructor(private pacienteService: PacienteService) {}

    ngOnInit(): void {
        this.pacienteService.obterPacientePorId(this.prontuario).subscribe((paciente) => {
            this.paciente = paciente;
        });
    }

    public getNomeDoPaciente(): string | null {
        return this.paciente?.nome;
    }

    public getProntuario(): number {
        return this.prontuario;
    }
}
