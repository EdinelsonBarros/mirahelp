import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrl: './details.component.scss'
})
export class DetailsComponent {
  route: ActivatedRoute = inject(ActivatedRoute);

  daysWeek = [
    {
      dayWeek:'Segunda-feira',
      experts: {
        expert: {
          name: 'Pediatra',
        hours: '14:00 ás 18:00'
      }
      }
    }, 
    {dayWeek: 'Terça-feira'}, 
    {dayWeek: 'Quarta-feira'}, 
    {dayWeek: 'Quinta-feira'}, 
    {dayWeek: 'Sexta-feira'}, 
    {dayWeek: 'Sábado'},
    {dayWeek: 'Domingo'}
    ]

}
