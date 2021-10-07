export class User {
  isAuthenticated: boolean = false;
  user!: {
    active: boolean;
    contactNo: string;
    createdBy: number;
    createdDate: string;
    email: string;
    endDate: string;
    firstName: string;
    id: number;
    lastName: string;
    mobileNo: string;
    buildingName: string;
    city: string;
    area: string;
    country: string;
    pinCode: string;
    state: string;
    token: string;
    tokenValidity: string;
    updatedBy: number;
    updatedDate: string;
    userImage: string;
    verified: boolean;
  };
}
