package atomic.currency;

import java.util.Collection;

import atomic.GroupManager;

public class CurrencyManager extends GroupManager<Currency, CurrencyBundle, CurrencyManager> 
{
	public CurrencyManager() {
        super();
    }
    public CurrencyManager(Collection<CurrencyBundle> currency_bundle) {
    	super(currency_bundle);
    }
    public CurrencyManager(CurrencyManager currency_manager) {
        super(currency_manager);
    }
	
	@Override
	protected void remove_element(CurrencyBundle currency_bundle) {
		Currency currency = currency_bundle.element();
        if (this.mapping.containsKey(currency)) {
            CurrencyBundle existing_currency_bundle = this.mapping.get(currency);
            int new_amount = existing_currency_bundle.amount() - currency_bundle.amount();
            
            if (new_amount > 0) {
            	this.mapping.put(currency, new CurrencyBundle(currency, new_amount));            	
            } else {
            	this.mapping.remove(currency);            	
            }
        }
    }
	
	@Override
	protected void add_element(CurrencyBundle currency_bundle) {
		Currency currency = currency_bundle.element();
        int amount = currency_bundle.amount();
        
        if (this.mapping.containsKey(currency)) {
        	int new_amount = this.mapping.get(currency).amount() + amount;
        	this.mapping.put(currency, new CurrencyBundle(currency, new_amount));        	
        } else {        	
        	this.mapping.put(currency, new CurrencyBundle(currency, amount));
        }
    }
}
