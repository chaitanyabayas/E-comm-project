export class Seller {
  constructor(
    public id: number,
    public firstName: string,
    public lastName: string,
    public mobileNo: string,
    public contactNo: string,
    public userImage: string,
    public email: string,
    public password: string,
    public token: string,
    public tokenValidity: string,
    public otp: string,
    public verified: boolean,
    public updatedBy: number,
    public updatedDate: string,
    public active: boolean,
    public createdBy: number,
    public createdDate: string
  ) {}
}
