import {Document} from "../document/document";

export class Client{
  constructor(
    public id: number,
    public firstName: string,
    public secondName: string,
    public patronymic: string,
    public birthday: string,
    public documents: Document[]) { }
}
