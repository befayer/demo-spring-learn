export class Document{
  constructor(
    public id: number,
    public dateStart: Date,
    public issueOrganization: string,
    public isActive: boolean,
    public documentTypeName: string) { }
}
