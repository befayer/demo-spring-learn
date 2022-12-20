import {TemplateRef, ViewChild, Component, OnInit} from '@angular/core';
import {Document} from './document';
import {DocumentType} from "../document-type/document-type";
import {DocumentService} from './document.service';
import {DocumentTypeService} from "../document-type/document-type.service";

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  providers: [DocumentService],
  styleUrls: ['./document.component.css']
})
export class DocumentComponent implements OnInit {

  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>;

  editedDocument: Document;
  documents: Array<Document>;
  isNewRecord: boolean = false;
  statusMessage: string = "";

  constructor(private serv: DocumentService) {
    this.documents = new Array<Document>();
  }

  ngOnInit() {
    this.loadDocuments();
  }

  private loadDocuments() {
    this.serv.getDocuments().subscribe((data: Array<Document>) => {
      this.documents = data;
    });
  }

  addDocument() {
    this.editedDocument = new Document(0, "","","", new DocumentType(0, ""));
    this.documents.push(this.editedDocument);
    this.isNewRecord = true;
  }

  editDocument(document: Document) {
    this.editedDocument = new Document(document.id, document.dateStart, document.issueOrganization, document.isActive, document.documentType);
  }

  loadTemplate(document: Document) : TemplateRef<any>{
    if (this.editedDocument && this.editedDocument.id === document.id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  saveDocument() {
    if (this.isNewRecord) {

      this.serv.createDocument(this.editedDocument as Document).subscribe(_ => {
        this.statusMessage = 'Данные успешно добавлены',
          this.loadDocuments();
      });
      this.isNewRecord = false;
      this.editedDocument = null;
    } else {
      // изменяем пользователя
      this.serv.updateDocument(this.editedDocument as Document).subscribe(_ => {
        this.statusMessage = 'Данные успешно обновлены',
          this.loadDocuments();
      });
      this.editedDocument = null;
    }
  }
  // отмена редактирования
  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.documents.pop();
      this.isNewRecord = false;
    }
    this.editedDocument = null;
  }
  // удаление пользователя
  deleteDocument(document: Document) {
    this.serv.deleteDocument(document.id).subscribe(_ => {
      this.statusMessage = 'Данные успешно удалены',
        this.loadDocuments();
    });
  }
}
