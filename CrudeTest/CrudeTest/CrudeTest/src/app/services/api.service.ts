import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  baseUrl: string = "http://localhost:3000/posts/";


  constructor(private http: HttpClient) { }

  formSave(data: any) {
    return this.http.post<any>(this.baseUrl, data)
      .pipe(map(
        (res => {
          return res;
        }

        )))
  }

  getAllForm(){
    return this.http.get<any>(this.baseUrl)
    .pipe(map(
      (res=>{
        return res;
      })
    ))

  }


  formDelete(id: number) {
    return this.http.delete<any>(this.baseUrl+id)
      .pipe(map(
        (res => {
          return res;
        }

        )))
  }

  formEdit(id: number,row:any) {
    return this.http.put<any>(this.baseUrl+id,row)
      .pipe(map(
        (res => {
          return res;
        }

        )))
  }

}
