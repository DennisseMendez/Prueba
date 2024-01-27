import { Component } from '@angular/core';
import { SalonesServiceService } from '../salones-service.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listado-salones',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './listado-salones.component.html',
  styleUrl: './listado-salones.component.css'
})
export class ListadoSalonesComponent {

  /**
   *
   */
  constructor(public servicio: SalonesServiceService) {
    this.servicio.obtenerListaSalones();
    
  }

  //get
  get listaSalones(){
    return this.servicio.listaSalones;
  }

  //metodos
  eliminar(id: number){


    Swal.fire({
      title: "Are you sure?",
      text: "You won't be able to revert this!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, delete it!"
    }).then((result) => {
      if (result.isConfirmed) {
       this.servicio.eliminarSalon(id);
       Swal.fire({
        title: "Deleted!",
        text: "Your file has been deleted.",
        icon: "success"
      });
      }
    });
    

  }

}
