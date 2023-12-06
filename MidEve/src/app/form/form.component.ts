import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FormModel } from './form.model';
import { ApiService } from '../services/api.service';



@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrl: './form.component.css',
  
})
export class FormComponent implements OnInit {
  formData: any;
  formValue!: FormGroup;
  formModel: FormModel = new FormModel();

  constructor(private api: ApiService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      roll: [''],
      name: [''],
      department_JEE: [false],
      department_WEB: [false],
      department_NT: [false],
      marks: ['']

    });
    this.getAll();
  }

  saveForm() {
    this.formModel.roll = this.formValue.value.roll;
    this.formModel.name = this.formValue.value.name;
    
    this.formModel.marks = this.formValue.value.marks;
    // this.formModel.gender = this.formValue.value.gender;
    // this.formModel.email = this.formValue.value.email;

    // this.formModel.address = this.formValue.value.address;

    let department: string[] = []
    if (this.formValue.value.department_JEE) {
      department.push('JEE');
    }

    if (this.formValue.value.department_WEB) {
      department.push('WEB');
    }

    if (this.formValue.value.department_NT) {
      department.push('NT');
    }
    this.formModel.department = department


    this.api.formSave(this.formModel)
      .subscribe(res => {
        console.log(res);
        alert("Added Succesfully")
        this.formValue.reset();
        this.getAll();
      },
        err => {

          alert("Added Failed")

        }

      )

  }

  getAll() {
    this.api.getAllForm()
      .subscribe(res => {
        this.formData = res;

      })
  }

  deleteForm(row: any) {
    this.api.formDelete(row.id)
      .subscribe(
        res => {
          console.log(res);
          this.formValue.reset();
          this.getAll();

        },
        err => {
          alert("Data Not Daved")
        }


      )


  }

  onEdit(row: any) {
    this.formModel.id = row.id;
    this.formValue.controls['roll'].setValue(row.roll);
    this.formValue.controls['name'].setValue(row.name);
    this.formValue.controls['marks'].setValue(row.marks);
    this.formValue.controls['department_JEE'].setValue(row.department.includes("JEE"));
    this.formValue.controls['department_WEB'].setValue(row.department.includes("WEB"));
    this.formValue.controls['department_NT'].setValue(row.departmentt.includes("NT"));

  }

  editForm() {

    this.formModel.roll = this.formValue.value.roll;
    this.formModel.name = this.formValue.value.name;
    this.formModel.marks = this.formValue.value.marks;

 

    let department: string[] = []
    if (this.formValue.value.department_JEE) {
      department.push('JEE');
    }

    if (this.formValue.value.department_WEB) {
      department.push('WEB');
    }

    if (this.formValue.value.department_NT) {
      department.push('NT');
    }
    this.formModel.department = department

    this.api.formEdit(this.formModel.id, this.formModel)
      .subscribe(res => {
        console.log(res);
        alert("Added Succesfully")
        this.formValue.reset();
        this.getAll();
      },
        err => {

          alert("Added Failed")

        }

      )


  }


}