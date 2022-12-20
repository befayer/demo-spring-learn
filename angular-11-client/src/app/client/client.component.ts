import {TemplateRef, ViewChild, Component, OnInit} from '@angular/core';
import {Client} from './client';
import {Document} from "../document/document";
import {DocumentType} from "../document-type/document-type";
import {ClientService} from './client.service';
import {DocumentService} from "../document/document.service";
import {DocumentTypeService} from "../document-type/document-type.service";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  providers: [ClientService],
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>;
  @ViewChild('readOnlyTemplateDoc', {static: false}) readOnlyTemplateDoc: TemplateRef<any>;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>;
  @ViewChild('editTemplateDoc', {static: false}) editTemplateDoc: TemplateRef<any>;

  editedClient: Client;
  editedDoc: Document;
  clients: Array<Client>;
  client: Client;
  documents: Array<Document>;
  isNewRecord: boolean = false;
  statusMessage: string = "";

  constructor(private serv: ClientService) {
    this.clients = new Array<Client>();
  }

  ngOnInit() {
    this.loadClients();
  }

  private loadClients() {
    this.serv.getClients().subscribe((data: Array<Client>) => {
      this.clients = data;
    });
  }

  addClient() {
    this.editedClient = new Client(0, "", "", "", "", null);
    this.clients.push(this.editedClient);
    this.isNewRecord = true;
  }

  addDocument() {
    this.editedDocument = new Document(0, "", "", "", null);
    this.clients.push(this.editedClient);
    this.isNewRecord = true;
  }

  editClient(client: Client) {
    this.editedClient = new Client(client.id, client.firstName, client.secondName, client.patronymic, client.birthday, client.documents);
  }

  editDocument(document: Document) {
    this.editedDoc = new Document(document.id, document.dateStart, document.issueOrganization, document.isActive, document.documentType);
  }

  loadTemplate(client: Client): TemplateRef<any> {
    if (this.editedClient && this.editedClient.id === client.id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  loadTemplateDoc(document: Document): TemplateRef<any> {
      if (this.editedDoc && this.editedDoc.id === document.id) {
        return this.editTemplateDoc;
      } else {
        return this.readOnlyTemplateDoc;
      }
  }

  loadDocByClient(client: Client){
    this.serv.getDocuments(client).subscribe((data: Array<Document>) => {
      this.documents = data;
    });
  }


  loadClientByDoc(document: Document){
    this.serv.getClientByDocument(document).subscribe( (data: Client[]) => {
      this.clients = data;
    });
  }

  saveClient() {
    if (this.isNewRecord) {
      this.serv.createClient(this.editedClient as Client).subscribe(_ => {
        this.statusMessage = 'Данные успешно добавлены',
          this.loadClients();
      });
      this.isNewRecord = false;
      this.editedClient = null;
    } else {
      this.serv.updateClient(this.editedClient as Client).subscribe(_ => {
        this.statusMessage = 'Данные успешно обновлены',
          this.loadClients();
      });
      this.editedClient = null;
    }
  }

  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.clients.pop();
      this.isNewRecord = false;
    }
    this.editedClient = null;
  }

  deleteClient(client: Client) {
    this.serv.deleteClient(client.id).subscribe(_ => {
      this.statusMessage = 'Данные успешно удалены',
        this.loadClients();
    });
  }

  deleteDoc(document: Document, client: Client) {
    this.serv.deleteDoc(document.id).subscribe(_ => {
      this.statusMessage = 'Данные успешно удалены',
        this.loadDocByClient(client);
    });
  }
}
