import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {DocumentType} from './document-type';

@Injectable()
export class DocumentTypeService {

  private url = "http://localhost:8080/api/document-types";
  constructor(private http: HttpClient){ }

  getDocumentTypes(){
    return this.http.get<Array<DocumentType>>(this.url);
  }

  createDocumentType(documentType: DocumentType){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<DocumentType>(this.url, JSON.stringify(documentType), {headers: myHeaders});
  }

  updateDocumentType(documentType: DocumentType) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<DocumentType>(this.url, JSON.stringify(documentType), {headers:myHeaders});
  }

  deleteDocumentType(id: number){
    return this.http.delete<DocumentType>(this.url + '/' + id);
  }
}
