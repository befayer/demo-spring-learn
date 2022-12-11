import {TemplateRef, ViewChild, Component, OnInit} from '@angular/core';
import {Client} from './client';
import {ClientService} from './client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  providers: [ClientService],
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>;

  editedClient: Client;
  clients: Array<Client>;
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
    this.editedClient = new Client(0,"","", "", new Date());
    this.clients.push(this.editedClient);
    this.isNewRecord = true;
  }

  editClient(client: Client) {
    this.editedClient = new Client(client.id, client.firstName, client.secondName, client.patronymic, client.birthday);
  }

  loadTemplate(client: Client) : TemplateRef<any>{
    if (this.editedClient && this.editedClient.id === client.id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
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
  // отмена редактирования
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
}
