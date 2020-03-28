export class Person {

  private id: number;
  private firstName: string;
  private lastName: string;
  private birthDate: Date;
  private mailAddress: string;
  private phoneNumber: number;


  constructor(id: number, firstName: string, lastName: string, birthDate: Date, mailAddress: string, phoneNumber: number) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.mailAddress = mailAddress;
    this.phoneNumber = phoneNumber;
  }
}
