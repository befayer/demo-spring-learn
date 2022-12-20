import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Client} from './client';
import {Document} from "../document/document";
import {Observable} from "rxjs";

@Injectable()
export class ClientService{

  private url = "http://localhost:8080/api/clients";
  constructor(private http: HttpClient){ }

  getClients(){
    return this.http.get<Array<Client>>(this.url);
  }

  getDocuments(client: Client): Observable<Array<Document>> {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<Array<Document>>("http://localhost:8080/api/documents/getdocs", JSON.stringify(client), {headers: myHeaders});
  }

  getClientByDocument(document: Document): Observable<Array<Client>> {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<Array<Client>>("http://localhost:8080/api/clients/get-client-by-doc", JSON.stringify(document), {headers: myHeaders});
  }

  createClient(client: Client){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<Client>(this.url, JSON.stringify(client), {headers: myHeaders});
  }

  updateClient(client: Client) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<Client>(this.url, JSON.stringify(client), {headers:myHeaders});
  }

  deleteClient(id: number){
    return this.http.delete<Client>(this.url + '/' + id);
  }

  deleteDoc(id: number){
    return this.http.delete<Document>("http://localhost:8080/api/documents" + '/' + id);
  }
}
