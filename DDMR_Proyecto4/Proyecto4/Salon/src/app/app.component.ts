import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ListadoSalonesComponent } from './listado-salones/listado-salones.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { FooterComponent } from './footer/footer.component';
import { AltasSalonComponent } from './altas-salon/altas-salon.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ListadoSalonesComponent, NavBarComponent, FooterComponent, AltasSalonComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Salon';
}
