import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { debounceTime, map, take } from 'rxjs';

@Component({
  selector: 'app-filmes',
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatDividerModule,
    MatIconModule,
    CommonModule
  ],
  templateUrl: './filmes.html',
  styleUrl: './filmes.css',
})
export class Filmes {

  filmeForm!: FormGroup;
  listarFilmes = [];

    constructor(
        private formBuilder: FormBuilder,
        private httpClient: HttpClient
    ) { }

  ngOnInit(): void {
      this.criarFormulario(); // Função chmada na hora que carrega o componente

      this.filmeForm.valueChanges.pipe(debounceTime(400), take(2)).subscribe((res)=> { // O valueChanges funciona como observable, logo, nele podemos fazer N coisas durante uma requisição ou alteração de dados do formulário
        console.log("res");
      })

      this.httpClient.get("http://localhost:8080/filmes").subscribe((res: any) =>{
        this.listarFilmes = res;

      })
    }

    private criarFormulario(): void { //Função que cria o formulario passando cada um dos campos JSON
      this.filmeForm = this.formBuilder.group({
        titulo: [ "" , Validators.required,],
        genero: [ "" , Validators.required],
        sinopse: [ "" , Validators.required],
        autor: [ "" , Validators.required],
        anoLancamento: [ "" , Validators.required],
        duracao: [ "" , Validators.required],
      });
      console.log("filmeForm", this.filmeForm);
    }

    public enviarDados() { // Função responsável por enviar os dados para o backend
      console.log(this.filmeForm.valid);
      console.log(this.filmeForm.getRawValue());
      if (this.filmeForm.valid) { //url = localhost:8080/filmes
        console.log("Envie para o backend");
        this.httpClient.post("http://localhost:8080/filmes", this.filmeForm.getRawValue()).subscribe(() => {
           // Posso fazer N coisas dentro do observable que irá ocorrer de maneira assincrona.

        })

        }

      }

    }







