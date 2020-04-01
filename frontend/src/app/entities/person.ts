export class Person {

  public id: number;
  public firstName: string;
  public lastName: string;
  public birthDate: Date;
  public mailAddress: string;
  public phoneNumber: number;


  constructor(firstName: string, lastName: string, birthDate: Date, mailAddress: string, phoneNumber: number) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.mailAddress = mailAddress;
    this.phoneNumber = phoneNumber;
  }
}
