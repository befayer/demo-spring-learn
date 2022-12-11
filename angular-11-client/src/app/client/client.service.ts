import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Client} from './client';

@Injectable()
export class ClientService{

  private url = "http://localhost:8080/api/clients";
  constructor(private http: HttpClient){ }

  getClients(){
    return this.http.get<Array<Client>>(this.url);
  }

  createClient(client: Client){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<Client>(this.url, JSON.stringify(Client), {headers: myHeaders});
  }

  updateClient(client: Client) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<Client>(this.url, JSON.stringify(Client), {headers:myHeaders});
  }

  deleteClient(id: number){
    return this.http.delete<Client>(this.url + '/' + id);
  }
}
