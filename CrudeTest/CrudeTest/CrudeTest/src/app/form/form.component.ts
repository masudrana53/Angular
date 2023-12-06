import { Component ,OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FormModel } from './form.model';
import { ApiService } from '../services/api.service';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent implements OnInit{
  formData:any;
  formValue!:FormGroup;
  formModel:FormModel=new FormModel();

  constructor(private api:ApiService, private formBuilder: FormBuilder){}

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      name: [''],
      gender: [''],
      email: [''],
      subject_JEE: [false],
      subject_WEB: [false],
      subject_NT: [false],
      address:['']
    });
    this.getAll();
  }

saveForm(){
this.formModel.name=this.formValue.value.name;
this.formModel.gender=this.formValue.value.gender;
this.formModel.email=this.formValue.value.email;

this.formModel.address=this.formValue.value.address;

let subject: string[]=[]
if(this.formValue.value.subject_JEE){
  subject.push('JEE');
}

if(this.formValue.value.subject_WEB){
  subject.push('WEB');
}

if(this.formValue.value.subject_NT){
  subject.push('NT');
}
this.formModel.subject=subject


this.api.formSave(this.formModel)
.subscribe(res=>{
console.log(res);
alert("Added Succesfully")
this.formValue.reset();
this.getAll();
},
err=>{

  alert("Added Failed")

}

)

}

getAll(){
  this.api.getAllForm()
  .subscribe(res => {
    this.formData=res;     
    
  })
}

  deleteForm(row:any){
this.api.formDelete(row.id)
.subscribe(
res=>{
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
    this.formModel.id=row.id;
    this.formValue.controls['name'].setValue(row.name);
    this.formValue.controls['gender'].setValue(row.gender);
    this.formValue.controls['email'].setValue(row.email);
    // this.formValue.controls['subject'].setValue(row.subject);
    this.formValue.controls['address'].setValue(row.address);
    this.formValue.controls['subject_JEE'].setValue(row.subject.includes("JEE"));
    this.formValue.controls['subject_WEB'].setValue(row.subject.includes("WEB"));
    this.formValue.controls['subject_NT'].setValue(row.subject.includes("NT"));

   

  

  }

  editForm(){

    this.formModel.name=this.formValue.value.name;
this.formModel.gender=this.formValue.value.gender;
this.formModel.email=this.formValue.value.email;
// this.formModel.subject=this.formValue.value.subject;
this.formModel.address=this.formValue.value.address;

let subject: string[]=[]
if(this.formValue.value.subject_JEE){
  subject.push('JEE');
}

if(this.formValue.value.subject_WEB){
  subject.push('WEB');
}

if(this.formValue.value.subject_NT){
  subject.push('NT');
}
this.formModel.subject=subject

this.api.formEdit(this.formModel.id, this.formModel)
.subscribe(res=>{
console.log(res);
alert("Added Succesfully")
this.formValue.reset();
this.getAll();
},
err=>{

  alert("Added Failed")

}

)


    }


}
