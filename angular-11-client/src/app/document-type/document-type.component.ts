import {TemplateRef, ViewChild, Component, OnInit} from '@angular/core';
import {DocumentType} from './document-type';
import {DocumentTypeService} from './document-type.service';

@Component({
  selector: 'app-document-type',
  templateUrl: './document-type.component.html',
  providers: [DocumentTypeService],
  styleUrls: ['./document-type.component.css']
})
export class DocumentTypeComponent implements OnInit {

  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>;

  editedDocumentType: DocumentType;
  documentTypes: Array<DocumentType>;
  isNewRecord: boolean = false;
  statusMessage: string = "";

  constructor(private serv: DocumentTypeService) {
    this.documentTypes = new Array<DocumentType>();
  }

  ngOnInit() {
    this.loadDocumentTypes();
  }

  private loadDocumentTypes() {
    this.serv.getDocumentTypes().subscribe((data: Array<DocumentType>) => {
      this.documentTypes = data;
    });
  }

  addDocumentType() {
    this.editedDocumentType = new DocumentType(0,"");
    this.documentTypes.push(this.editedDocumentType);
    this.isNewRecord = true;
  }

  editDocumentType(documentType: DocumentType) {
    this.editedDocumentType = new DocumentType(documentType.id, documentType.documentTypeName);
  }

  loadTemplate(documentType: DocumentType) : TemplateRef<any>{
    if (this.editedDocumentType && this.editedDocumentType.id === documentType.id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  saveDocumentType() {
    if (this.isNewRecord) {

      this.serv.createDocumentType(this.editedDocumentType as DocumentType).subscribe(_ => {
        this.statusMessage = 'Данные успешно добавлены',
          this.loadDocumentTypes();
      });
      this.isNewRecord = false;
      this.editedDocumentType = null;
    } else {
      // изменяем пользователя
      this.serv.updateDocumentType(this.editedDocumentType as DocumentType).subscribe(_ => {
        this.statusMessage = 'Данные успешно обновлены',
          this.loadDocumentTypes();
      });
      this.editedDocumentType = null;
    }
  }
  // отмена редактирования
  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.documentTypes.pop();
      this.isNewRecord = false;
    }
    this.editedDocumentType = null;
  }
  // удаление пользователя
  deleteDocumentType(documentType: DocumentType) {
    this.serv.deleteDocumentType(documentType.id).subscribe(_ => {
      this.statusMessage = 'Данные успешно удалены',
        this.loadDocumentTypes();
    });
  }
}
