import { Page } from "./page";

export class DefaultResponse<T> {
  statusCode: number;
  message: string;
  pagination?: Page;
  data?: T;

  constructor(statusCode: number, message: string, pagination?: Page, data?: T) {
    this.statusCode = statusCode;
    this.message = message;
    this.pagination = pagination;
    this.data = data;
  }

  static response<T>(statusCode: number, message: string): DefaultResponse<T> {
    return new DefaultResponse<T>(statusCode, message);
  }

  static responseWithData<T>(statusCode: number, message: string, data: T): DefaultResponse<T> {
    return new DefaultResponse<T>(statusCode, message, undefined, data);
  }

  static responseWithPaginationAndData<T>(statusCode: number, message: string, pagination: Page, data: T): DefaultResponse<T> {
    return new DefaultResponse<T>(statusCode, message, pagination, data);
  }
}
