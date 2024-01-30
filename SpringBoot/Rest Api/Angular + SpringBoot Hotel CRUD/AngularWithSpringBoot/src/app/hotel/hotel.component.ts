import { Component, OnInit } from '@angular/core';
import { Hotel } from '../model/hotel.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HotelserviceService } from '../service/hotelservice.service';
import { response } from 'express';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrl: './hotel.component.css'
})

export class HotelComponent implements OnInit {

  hotels: Hotel[] = [];
  hotelForm!: FormGroup;

  constructor(
    private hotelService: HotelserviceService,
    private fromBuilder: FormBuilder,
  ){}



  ngOnInit(): void {
    this.loadHotels(),
    this.initHotelForm()
    
  }

  private loadHotels(){
    this.hotelService.getAllHotels().subscribe(
      data => this.hotels = data,
      error => console.error('Error fetching hotels', error)
    );
    }
    
    private initHotelForm(){
      this.hotelForm = this.fromBuilder.group({
        name: ['', Validators.required],
        location: ['', Validators.required]
      });   
  }


  onSubmit(){
    if(this.hotelForm.valid){
      const hotelData: Hotel = this.hotelForm.value;
      this.hotelService.createHotel(hotelData).subscribe(
        response =>{
          console.log('Hotel created successfully', response);
          this.loadHotels();// Refresh the list of hotel after creation
          this,this.hotelForm.reset();// Reset the form         
        },
        error => alert('Error creating hotel')
      );
    }
  }
}
