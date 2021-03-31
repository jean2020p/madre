import { Component } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";

@Component({
    selector: 'paciente-list',
    templateUrl: './paciente-list.component.html',
})
export class PacienteListComponent {

    paciente: FormGroup = this.fb.group({
        nome: [],
        prontuario: []
    });

    datatableExtraParams = {
        rows: 20
    }

    constructor(private fb: FormBuilder) {
    }

}
