import {TemplateRef, ViewChild, Component, OnInit} from '@angular/core';
import {Bank} from './bank';
import {BankService} from './bank.service';

@Component({
  selector: 'app-bank',
  templateUrl: './bank.component.html',
  providers: [BankService],
  styleUrls: ['./bank.component.css']
})
export class BankComponent implements OnInit {

  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>;

  editedBank: Bank;
  banks: Array<Bank>;
  isNewRecord: boolean = false;
  statusMessage: string = "";

  constructor(private serv: BankService) {
    this.banks = new Array<Bank>();
  }

  ngOnInit() {
    this.loadBanks();
  }

  private loadBanks() {
    this.serv.getBanks().subscribe((data: Array<Bank>) => {
      this.banks = data;
    });
  }

  addBank() {
    this.editedBank = new Bank(0,"","", "");
    this.banks.push(this.editedBank);
    this.isNewRecord = true;
  }

  editBank(bank: Bank) {
    this.editedBank = new Bank(bank.id, bank.terbankName, bank.bik, bank.city);
  }

  loadTemplate(bank: Bank) : TemplateRef<any>{
    if (this.editedBank && this.editedBank.id === bank.id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  saveBank() {
    if (this.isNewRecord) {

      this.serv.createBank(this.editedBank as Bank).subscribe(_ => {
        this.statusMessage = 'Данные успешно добавлены',
          this.loadBanks();
      });
      this.isNewRecord = false;
      this.editedBank = null;
    } else {
      // изменяем пользователя
      this.serv.updateBank(this.editedBank as Bank).subscribe(_ => {
        this.statusMessage = 'Данные успешно обновлены',
          this.loadBanks();
      });
      this.editedBank = null;
    }
  }
  // отмена редактирования
  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.banks.pop();
      this.isNewRecord = false;
    }
    this.editedBank = null;
  }
  // удаление пользователя
  deleteBank(bank: Bank) {
    this.serv.deleteBank(bank.id).subscribe(_ => {
      this.statusMessage = 'Данные успешно удалены',
        this.loadBanks();
    });
  }
}
