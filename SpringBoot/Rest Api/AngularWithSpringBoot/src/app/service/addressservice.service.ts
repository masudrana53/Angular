import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddressserviceService {

  baseUrl:string="http://localhost:8081/api/hotel";

  constructor(private http:HttpClient) { }
}
