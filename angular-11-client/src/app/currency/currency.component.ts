import {TemplateRef, ViewChild, Component, OnInit} from '@angular/core';
import {Currency} from './currency';
import {CurrencyService} from './currency.service';

@Component({
  selector: 'app-currency',
  templateUrl: './currency.component.html',
  providers: [CurrencyService],
  styleUrls: ['./currency.component.css']
})
export class CurrencyComponent implements OnInit {

  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>;

  editedCurrency: Currency;
  currencies: Array<Currency>;
  isNewRecord: boolean = false;
  statusMessage: string = "";

  constructor(private serv: CurrencyService) {
    this.currencies = new Array<Currency>();
  }

  ngOnInit() {
    this.loadCurrencies();
  }

  private loadCurrencies() {
    this.serv.getCurrencies().subscribe((data: Array<Currency>) => {
      this.currencies = data;
    });
  }

  addCurrency() {
    this.editedCurrency = new Currency(0,"");
    this.currencies.push(this.editedCurrency);
    this.isNewRecord = true;
  }

  editCurrency(currency: Currency) {
    this.editedCurrency = new Currency(currency.id, currency.currencyName);
  }

  loadTemplate(currency: Currency) : TemplateRef<any>{
    if (this.editedCurrency && this.editedCurrency.id === currency.id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  saveCurrency() {
    if (this.isNewRecord) {
      this.serv.createCurrency(this.editedCurrency as Currency).subscribe(_ => {
        this.statusMessage = 'Данные успешно добавлены',
          this.loadCurrencies();
      });
      this.isNewRecord = false;
      this.editedCurrency = null;
    } else {
      this.serv.updateCurrency(this.editedCurrency as Currency).subscribe(_ => {
        this.statusMessage = 'Данные успешно обновлены',
          this.loadCurrencies();
      });
      this.editedCurrency = null;
    }
  }

  cancel() {
    // если отмена при добавлении, удаляем последнюю запись
    if (this.isNewRecord) {
      this.currencies.pop();
      this.isNewRecord = false;
    }
    this.editedCurrency = null;
  }

  deleteCurrency(currency: Currency) {
    this.serv.deleteCurrency(currency.id).subscribe(_ => {
      this.statusMessage = 'Данные успешно удалены',
        this.loadCurrencies();
    });
  }
}
