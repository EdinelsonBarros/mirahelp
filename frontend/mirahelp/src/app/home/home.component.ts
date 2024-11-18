import { Component, OnInit } from '@angular/core';
import { CorporationResponse } from './interfaces/CorporationResponse'
import { CorporationService } from '../corporation.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit{
corporations!: CorporationResponse[];

constructor(private corpService: CorporationService){}

ngOnInit(): void {
    this.getAllCorps()
}

getAllCorps(){
  this.corpService.getAllCorporations().subscribe(
    (corps) => {
      
      this.corporations = corps
      
      console.log(this.corporations.values())
    }
  )
}

}
