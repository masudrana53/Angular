import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Hotel } from '../model/hotel.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelserviceService {

  private baseUrl:string="http://localhost:8081/api/hotel";


  constructor(private httpClient: HttpClient){}

  getAllHotels(): Observable<Hotel[]> {
    return this.httpClient.get<Hotel[]>(this.baseUrl);
  }

  getHotelById(id: number): Observable<Hotel> {
    return this.httpClient.get<Hotel>(`${this.baseUrl}/${id}`);
  }

  createHotel(hotel: Hotel): Observable<Hotel> {
    return this.httpClient.post<Hotel>(this.baseUrl, hotel);
  }

  updateHotel(id: number, hotel: Hotel): Observable<Hotel> {
    return this.httpClient.put<Hotel>(`${this.baseUrl}/${id}`, hotel);
  }

  deletehotel(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`);
  }
}
