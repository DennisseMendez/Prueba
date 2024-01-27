import { Routes } from '@angular/router';
import { ListadoSalonesComponent } from './listado-salones/listado-salones.component';
import { AltasSalonComponent } from './altas-salon/altas-salon.component';
//import { DetalleSalonComponent } from './detalle-salon/detalle-salon.component';
//import { EdicionSalonComponent } from './edicion-salon/edicion-salon.component';

export const routes: Routes = [
    { path: "salones", component: ListadoSalonesComponent},
    { path: "salones/alta", component: AltasSalonComponent},
   // { path: "salones/detalle/:id", component: DetalleSalonComponent},
    //{ path: "salones/editar/:id", component: EdicionSalonComponent},

    { path: "", redirectTo: "/salones", pathMatch: "full"},

];
