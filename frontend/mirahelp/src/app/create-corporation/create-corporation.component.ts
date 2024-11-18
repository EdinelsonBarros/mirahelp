import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CorporationService } from '../corporation.service';
import { CorporationRequest } from '../home/interfaces/CorporationRequest';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SnackBarTemplateComponent } from '../snack-bar-template/snack-bar-template.component';

@Component({
  selector: 'app-create-corporation',
  templateUrl: './create-corporation.component.html',
  styleUrl: './create-corporation.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CreateCorporationComponent implements OnInit {
  corp: CorporationRequest = {
    name: '',
    category: '',
    description: '',
    street: '',
    numberAdress: '',
    neighborhood: '',
    hourOpening: '',
    hoursClose: '',
    phoneNumber: ''
  };
  hours = [
    { id: 1, hour: '00:00' },
    { id: 2, hour: '01:00' },
    { id: 3, hour: '02:00' },
    { id: 4, hour: '03:00' },
    { id: 5, hour: '04:00' },
    { id: 6, hour: '05:00' },
    { id: 7, hour: '06:00' },
    { id: 8, hour: '07:00' },
    { id: 9, hour: '08:00' },
    { id: 10, hour: '09:00' },
    { id: 11, hour: '10:00' },
    { id: 12, hour: '11:00' },
    { id: 13, hour: '12:00' },
    { id: 14, hour: '13:00' },
    { id: 15, hour: '14:00' },
    { id: 16, hour: '15:00' },
    { id: 17, hour: '16:00' },
    { id: 18, hour: '17:00' },
    { id: 19, hour: '18:00' },
    { id: 20, hour: '19:00' },
    { id: 21, hour: '20:00' },
    { id: 22, hour: '21:00' },
    { id: 23, hour: '22:00' },
    { id: 24, hour: '23:00' },
  ]


  formCorp = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(5)]),
    category: new FormControl(''),
    description: new FormControl(''),
    street: new FormControl('', Validators.required),
    numberAdress: new FormControl(''),
    neighborhood: new FormControl('', [Validators.required, Validators.minLength(5)]),
    hoursOpen: new FormControl('', Validators.required),
    hoursClose: new FormControl('', Validators.required),
    phoneNumber: new FormControl('', Validators.required)
  })

  constructor(
    private corpService: CorporationService,
    private router: Router,
    private _snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {

  }

  saveCorporation() {
    this.corp.name = this.formCorp.get('name')?.value;
    this.corp.category = this.formCorp.get('category')?.value;
    this.corp.description = this.formCorp.get('description')?.value;
    this.corp.street = this.formCorp.get('street')?.value;
    this.corp.numberAdress = this.formCorp.get('numberAdress')?.value;
    this.corp.neighborhood = this.formCorp.get('neighborhood')?.value;
    this.corp.hourOpening = this.formCorp.get('hoursOpen')?.value;
    this.corp.hoursClose = this.formCorp.get('hoursClose')?.value;
    this.corp.phoneNumber = this.formCorp.get('phoneNumber')?.value;
    this.corpService.registerCorporation(this.corp).subscribe({
      next: () => {
        this.formCorp.reset()
        this.openSnackBarSucces()

      }
    })

  }

  openSnackBarSucces() {
    this._snackBar.openFromComponent(SnackBarTemplateComponent, {
      data: {
        type: "sucess",
        message: "Cadastro realizado com sucesso.",
        icon: "check"
      },
      duration: 4000,
      horizontalPosition: 'end',
      verticalPosition: 'top'
    })
  }

  openSnackBarFormInvalid() {
    this._snackBar.openFromComponent(SnackBarTemplateComponent, {
      data: {
        type: "erro",
        message: "Preencha todos os campos obrigatorios!",
        icon: "close"
      },
      duration: 4000,
      horizontalPosition: 'end',
      verticalPosition: 'top'
    })
  }

}
