import { Catagory } from "./Catagory";
import { Product } from "./product";
import { Seller } from "./seller";
import { SubCatagory } from "./SubCatagory";

export class Page {
    constructor(
      public size: number,
      public totalElements: number,
      public totalPages: number,
      public pageNumber: number,
      public sort: boolean,
      public prop: any,
      public filter:
        | Seller
        | Product
        | Catagory
        | SubCatagory
        
    ) {}
  }
  