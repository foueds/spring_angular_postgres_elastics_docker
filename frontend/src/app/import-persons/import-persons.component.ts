import { Component, OnInit } from '@angular/core';
import { ToastrService } from "ngx-toastr";
import * as XLSX from 'xlsx';
import { Person } from "../entities/person";
import { PersonService } from "../service/person.service";
import { UtilsService } from "../service/utils.service";

type AOA = any[][];

@Component({
  selector: 'app-import-persons',
  templateUrl: './import-persons.component.html',
  styleUrls: ['./import-persons.component.css']
})
export class ImportPersonsComponent implements OnInit {
  file: any;
  data: AOA = [[1, 2], [3, 4]];
  fileName: string = 'SheetJS.xlsx';
  persons: Array<Person> = [];

  constructor(private personService: PersonService, private utils: UtilsService, private toastr: ToastrService) {
  }

  ngOnInit() {
  }

  getFile(event: any): void {
    const target: DataTransfer = <DataTransfer>(event.target);
    if (target.files.length !== 1) throw new Error('Cannot use multiple files');
    const reader: FileReader = new FileReader();
    reader.onload = (e: any) => {
      const bufferStream: string = e.target.result;
      const workBook: XLSX.WorkBook = XLSX.read(bufferStream, {
        type: 'binary',
        cellDates: true,
        cellNF: false,
        cellText: false
      });
      const sheetName: string = workBook.SheetNames[0];
      const workSheet: XLSX.WorkSheet = workBook.Sheets[sheetName];
      this.data = <AOA>(XLSX.utils.sheet_to_json(workSheet, {header: 1}));
      this.extractData(this.data);
      this.saveAll(this.persons);
      console.log(this.data);
    };

    reader.readAsBinaryString(target.files[0]);
  }

  export(): void {
    const ws: XLSX.WorkSheet = XLSX.utils.aoa_to_sheet(this.data);
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

    /* save to file */
    XLSX.writeFile(wb, this.fileName);
  }

  extractData(dataToExtract: AOA): void {
    for (let i = 1; i < dataToExtract.length; i++) {
      let person = new Person(dataToExtract[i][0], dataToExtract[i][1], dataToExtract[i][2], dataToExtract[i][3], dataToExtract[i][4]);
      this.persons.push(person);
    }
  }

  private saveAll(persons: Array<Person>) {
    if (persons.length > 0)
      this.personService.importPersons(persons).subscribe(result => {
        this.toastr.success("Import done with success")
        this.utils.goBack();
      })
  }
}
