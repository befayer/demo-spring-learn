import {DocumentType} from "../document-type/document-type";

export class Document{
  constructor(
    public id: number,
    public dateStart: string,
    public issueOrganization: string,
    public isActive: string,
    public documentType: DocumentType) { }
}
