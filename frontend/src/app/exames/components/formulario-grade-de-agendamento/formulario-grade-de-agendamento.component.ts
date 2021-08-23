import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UnidadeFuncional } from '../../models/subjects/unidade-model';
import { SituacaoAtivo } from '../../models/dropdowns/situacao.dropdown';
import { GradeDeAgendamentoService } from '../../services/grade-de-agendamento.service';
import { GrupoModel } from '../../models/subjects/grupo-model';
import { ExamModel } from '../../models/subjects/exames-model';
import { Responsavel } from '../../models/subjects/responsavel-model';
import { GradesDeAgendamento } from '../../models/subjects/grades-de-agendamento';
import { UnidadeFuncionalService } from '../../services/unidade-funcional.service';
import { PessoaService } from 'src/app/seguranca/services/pessoa.service';
import { Pessoa } from 'src/app/seguranca/models/dropdowns/pessoa-model';
import { Sala } from '../../models/subjects/sala';
import { ExamesService } from '../../services/exames.service';
import { GruposExamesService } from '../../services/grupos-exames.service';

@Component({
  selector: 'app-formulario-grade-de-agendamento',
  templateUrl: './formulario-grade-de-agendamento.component.html',
  styleUrls: ['./formulario-grade-de-agendamento.component.css']
})
export class FormularioGradeDeAgendamentoComponent implements OnInit {

 

  constructor(private fb: FormBuilder,
              private gradeAgendamentoService: GradeDeAgendamentoService,
              private unidadeFuncionalService: UnidadeFuncionalService,
              private pessoaService: PessoaService,
              private exameService: ExamesService,
              private grupoExameService: GruposExamesService) { }
  

  unidadesExecutoras: UnidadeFuncional[] = [];
  pessoas: Pessoa[] = [];
  gruposDeExame: GrupoModel[] = [];
  responsaveis: Responsavel[] = [];
  salas: Sala[] = [];
  exames: ExamModel[] = [];

  exameSelecionado: number;
  salaSelecionada: number;

  situacaoGrade = SituacaoAtivo;
  

  cadastroGrade = this.fb.group({
    unidadeExecutoraId: [null, Validators.required],
    responsavelId: [null, Validators.required],
    ativo: [null, Validators.required],
    grupoAgendamentoExameId: [null]
  });

  validarFormulario(): boolean {
    if (this.cadastroGrade.valid && (this.exameSelecionado || this.cadastroGrade
        .get('grupoAgendamentoExameId').value != null)){
          return true; 
        } else {
          return false
        }
  }
  
  limparFormulario() {
    this.cadastroGrade.reset();    
  }
  
  cadastrarGradeDeAgendamento(){
    const cadastroGradeValor = this.cadastroGrade.value;

    const cadastro: GradesDeAgendamento = {
      unidadeExecutoraId: cadastroGradeValor.unidadeExecutoraId,
      responsavelId: cadastroGradeValor.responsavelId,
      ativo: cadastroGradeValor.ativo,
      salaGradeId: this.salaSelecionada,
      exameGradeId: this.exameSelecionado,
      grupoAgendamentoExameId: cadastroGradeValor.grupoAgendamentoExameId
    };

    console.log(cadastroGradeValor);

    this.gradeAgendamentoService.cadastrarGrade(cadastro).subscribe();
    this.cadastroGrade.reset();
    
  }

  ngOnInit(): void {
    this.unidadeFuncionalService.GetUnidades().subscribe((response) => {
      this.unidadesExecutoras = response;
    });

    this.pessoaService.getPessoa().subscribe((response) => {
      this.pessoas = response;
    });

    this.gradeAgendamentoService.getSalas().subscribe((response) => {
      this.salas = response;
    });

    this.exameService.GetExames().subscribe((response) => {
      this.exames = response;
    });

    this.grupoExameService.GetGrupos().subscribe((response) => {
      this.gruposDeExame = response;
    });


  }


}
