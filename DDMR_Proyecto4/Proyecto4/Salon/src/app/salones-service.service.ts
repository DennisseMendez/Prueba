import { Injectable } from '@angular/core';
import { ListadoSalonesComponent } from './listado-salones/listado-salones.component';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SalonesServiceService {
  //atributos
  public listaSalones: any[];
  public urlServidor: string = "http://localhost:8081/"
  //public urlServidor: string = "http://192.168.100.107:8081/"
  public salon: any;

  constructor(private postMan: HttpClient) {
    this.listaSalones= [];
    this.salon = {};
   }

   //metodos
  //metodo que realiza una peticion get a la api//consume a tu api
  //para obtener la lista de los salones
  obtenerListaSalones(): void {
    this.postMan.get(this.urlServidor + "api/salones").subscribe((respuesta: any) =>{
      console.log(respuesta);
      this.listaSalones = respuesta;
    });
  }

  //metodo que realiza una peticion delete a la api
  //para eliminar un salon
  eliminarSalon(id: number): void {
    const parametrosPeticion = new HttpParams()

    .set("id", id)
    this.postMan.delete(this.urlServidor + "api/salones/eliminar", {params: parametrosPeticion}).subscribe(
      (respuesta: any) => {
        console.log(respuesta);
        this.obtenerListaSalones();
      }
    )
  }


    //funcion que realiza una peticion post a la api
  //para insertar un nuevo salon
  guardarSalon(nombre: string, capacidad: number, descripcion: string, disponibilidad: boolean)
  {
    this.postMan.post(this.urlServidor + "api/salones", {
      "nombre": nombre,
      "capacidad": capacidad,
      "descripcion": descripcion,
      "disponibilidad": disponibilidad,
    },).subscribe((respuesta: any) =>{
      console.log(respuesta.msg);
    });
    


  }


}
