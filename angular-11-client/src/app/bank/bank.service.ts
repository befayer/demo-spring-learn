import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Bank} from './bank';

@Injectable()
export class BankService{

  private url = "http://localhost:8080/api/banks";
  constructor(private http: HttpClient){ }

  getBanks(){
    return this.http.get<Array<Bank>>(this.url);
  }

  createBank(bank: Bank){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<Bank>(this.url, JSON.stringify(bank), {headers: myHeaders});
  }

  updateBank(bank: Bank) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<Bank>(this.url, JSON.stringify(bank), {headers:myHeaders});
  }

  deleteBank(id: number){
    return this.http.delete<Bank>(this.url + '/' + id);
  }
}
