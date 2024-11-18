import { Component, Inject } from '@angular/core';
import { MAT_SNACK_BAR_DATA } from '@angular/material/snack-bar';

@Component({
  selector: 'app-snack-bar-template',
  templateUrl: './snack-bar-template.component.html',
  styleUrl: './snack-bar-template.component.scss'
})
export class SnackBarTemplateComponent {
constructor(@Inject(MAT_SNACK_BAR_DATA) public data: any){}
}
