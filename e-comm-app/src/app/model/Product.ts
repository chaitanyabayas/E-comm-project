export class Product {
  constructor(
    public id: number,
    public sellerId: number,
    public catagoryId: number,
    public subCatagoryId: number,
    public productName: string,
    public productPrice: string,
    public productQuantity: string,
    public productImage: string,
    public prodectManufacturer: string,
    public prodectModel: string,
    public manufacturingDate: string,
    public expiryDate: string,
    public manufacturedAt: string,
    public createdBy: number,
    public createdDate: string,
    public updatedBy: number,
    public updatedDate: string,
    public active: boolean
  ) {}
}
