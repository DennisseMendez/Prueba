import { Component, ViewChild, ElementRef } from '@angular/core';
import { SalonesServiceService } from '../salones-service.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-alta-salon',
  standalone: true,
  imports: [],
  templateUrl: './altas-salon.component.html',
  styleUrl: './altas-salon.component.css'
})
export class AltasSalonComponent {

  //atributos

  @ViewChild("nombre")
  referenciaNombre!: ElementRef;

  @ViewChild("capacidad")
  referenciaCapacidad!: ElementRef;

  @ViewChild("descripcion")
  referenciaDescripcion!: ElementRef;

  @ViewChild("disponibilidad")
  referenciaDisponibilidad!: ElementRef;

  

  constructor(private servicio: SalonesServiceService, private router: Router){


  }


  //metodo

  guardarSalon(){
    //recuperamos los valores que vienen en las cajas
    const nombre = this.referenciaNombre.nativeElement.value;
    const capacidad = this.referenciaCapacidad.nativeElement.value;
    const descripcion = this.referenciaDescripcion.nativeElement.value;
    const disponibilidad = this.referenciaDisponibilidad.nativeElement.value;
    

    this.servicio.guardarSalon(nombre, capacidad, descripcion, disponibilidad);
    this.router.navigate(["salones"]);
  }


}
