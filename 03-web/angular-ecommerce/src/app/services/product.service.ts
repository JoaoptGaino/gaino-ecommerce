import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Product } from '../common/product';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseUrl = 'http://localhost:8080/api/products';
  private categoryUrl = 'http://localhost:8080/api/product-category';

  constructor(private httpClient: HttpClient) {}

  getProductListPaginate(
    page: number,
    pageSize: number,
    categoryId: number
  ): Observable<GetProductResponse> {
    const searchUrl =
      `${this.baseUrl}/search/findByCategoryId?categoryId=${categoryId}` +
      `&page=${page}&size=${pageSize}`;
    return this.httpClient.get<GetProductResponse>(searchUrl);
  }

  getProductList(categoryId: number): Observable<Product[]> {
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?categoryId=${categoryId}`;
    return this.getProducts(searchUrl);
  }

  searchProducts(keyword: string): Observable<Product[]> {
    const searchUrl = `${this.baseUrl}/search/findByNameContaining?name=${keyword}`;
    return this.getProducts(searchUrl);
  }

  searchProductsPaginate(
    page: number,
    pageSize: number,
    keyword: string
  ): Observable<GetProductResponse> {
    const searchUrl =
      `${this.baseUrl}/search/findByNameContaining?name=${keyword}` +
      `&page=${page}&size=${pageSize}`;
    return this.httpClient.get<GetProductResponse>(searchUrl);
  }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.httpClient
      .get<GetProductCategoryResponse>(this.categoryUrl)
      .pipe(map((response) => response._embedded.productCategory));
  }

  private getProducts(searchUrl: string): Observable<Product[]> {
    return this.httpClient
      .get<GetProductResponse>(searchUrl)
      .pipe(map((response) => response._embedded.products));
  }

  getProduct(productId: number): Observable<Product> {
    const searchUrl = `${this.baseUrl}/${productId}`;

    return this.httpClient.get<Product>(searchUrl);
  }
}

interface Page {
  size: number;
  totalElements: number;
  totalPages: number;
  number: number;
}
interface GetProductResponse {
  _embedded: {
    products: Product[];
  };
  page: Page;
}

interface GetProductCategoryResponse {
  _embedded: {
    productCategory: ProductCategory[];
  };
}
