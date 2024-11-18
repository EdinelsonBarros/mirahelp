import { Injectable } from '@angular/core';
import { CorporationRequest } from './home/interfaces/CorporationRequest';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CorporationResponse } from './home/interfaces/CorporationResponse';

@Injectable({
  providedIn: 'root'
})
export class CorporationService {

  baseUrl = 'http://localhost:8086/corporation'

  constructor(private http: HttpClient) { }

  registerCorporation(c: CorporationRequest){
    return this.http.post(`${this.baseUrl}/save`, c)
    
  }

  getAllCorporations(): Observable<CorporationResponse[]>{
    return this.http.get<CorporationResponse[]>(`${this.baseUrl}/getall`)
  }

  
  
}
