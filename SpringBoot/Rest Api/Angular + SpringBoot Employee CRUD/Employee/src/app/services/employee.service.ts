import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = "http://localhost:8088/api/employee"

  constructor(private httpClint: HttpClient) { }

  getAllEmployees():Observable<Employee[]>{
    return this.httpClint.get<Employee[]>(this.baseUrl);
  }

  getEmployeeById(id: number): Observable<Employee>{
    return this.httpClint.get<Employee>('${this.baseUrl}/${id}');
  }

  createEmployee(employee: Employee): Observable<Employee>{
    return this.httpClint.post<Employee>(this.baseUrl, employee);
  }

  updateEmployee(id: number, employee: Employee): Observable<Employee>{
    return this.httpClint.put<Employee>('${this.baseUrl}/${id}', employee);
  }

  deleteEmployee(id: number): Observable<void>{
    return this.httpClint.delete<void>('${this.baseUrl}/${id}');
  }

}
