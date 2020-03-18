export class PersonModel {

  private id: number;
  private firstName: string;
  private lastName: string;
  private birthDate: Date;
  private mailAdress: string;
  private phoneNumber: number;


  constructor(id: number, firstName: string, lastName: string, birthDate: Date, mailAdress: string, phoneNumber: number) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.mailAdress = mailAdress;
    this.phoneNumber = phoneNumber;
  }
}
