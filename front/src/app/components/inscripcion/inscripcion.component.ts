import {Component, OnInit} from '@angular/core';
import {InscripcionModel} from "../../models/inscripcion/inscripcion-model";
import {InscripcionService} from "../../services/inscripcion/inscripcion.service";

@Component({
  selector: 'inscripcion',
  templateUrl: './inscripcion.component.html',
  styleUrls: ['./inscripcion.component.scss']
})
export class InscripcionComponent implements OnInit {
  inscripciones: InscripcionModel[];

  constructor(private inscripcionServicio: InscripcionService) {
  }

  ngOnInit(): void {
    this.getAllInscripciones()
  }


  private getAllInscripciones() {
    this.inscripcionServicio.getAllInscripciones().subscribe(inscripcion => {
      this.inscripciones = inscripcion;
    })

  }
}
