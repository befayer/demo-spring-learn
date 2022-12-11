import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Currency} from './currency';

@Injectable()
export class CurrencyService {

  private url = "http://localhost:8080/api/currencies";
  constructor(private http: HttpClient){ }

  getCurrencies(){
    return this.http.get<Array<Currency>>(this.url);
  }

  createCurrency(currency: Currency){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<Currency>(this.url, JSON.stringify(currency), {headers: myHeaders});
  }

  updateCurrency(currency: Currency) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<Currency>(this.url, JSON.stringify(currency), {headers:myHeaders});
  }

  deleteCurrency(id: number){
    return this.http.delete<Currency>(this.url + '/' + id);
  }
}
