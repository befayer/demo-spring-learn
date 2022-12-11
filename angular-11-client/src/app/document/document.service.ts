import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Document} from './document';

@Injectable()
export class DocumentService {

  private url = "http://localhost:8080/api/documents";
  constructor(private http: HttpClient){ }

  getDocuments(){
    return this.http.get<Array<Document>>(this.url);
  }

  createDocument(document: Document){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<Document>(this.url, JSON.stringify(document), {headers: myHeaders});
  }

  updateDocument(document: Document) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<Document>(this.url, JSON.stringify(document), {headers:myHeaders});
  }

  deleteDocument(id: number){
    return this.http.delete<Document>(this.url + '/' + id);
  }
}
