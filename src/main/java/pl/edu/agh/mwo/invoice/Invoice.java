package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> grossValue;
	private BigDecimal netValue;
	private BigDecimal tax;
	private BigDecimal total;
	private LocalDate date;
	
	Invoice(){
		netValue = new BigDecimal(0);
		tax = new BigDecimal(0);
		total = new BigDecimal(0);
		grossValue = new ArrayList<Product>();
		
	}

	public void addProduct(Product product) {
		grossValue.add(product);
		update(); //odświeżanie wartości subtotal, tax, total, date
	}

	public void addProduct(Product product, Integer quantity) {
		// TODO: implement
	}

	public BigDecimal getNetValue() { //getter
		return netValue;
	}

	public BigDecimal getTax() { //getter
		return tax;
	}

	public BigDecimal getGrossValue() { //getter
		return total;
	}
	public void setGrossValue(){ //setter
		total = BigDecimal.ZERO;
		for (Product product:grossValue){
			total=total.add(product.getPriceWithTax());
		}
		
	}
	public void setNetValue(){ //setter
		netValue = BigDecimal.ZERO;
		for(Product product:grossValue){
			netValue=netValue.add(product.getPrice());
	}}
	public void setTax(){ //setter
		tax = total.subtract(netValue);
	}
		
	public void update(){
		setNetValue();
		setGrossValue();
		setTax();
		date=LocalDate.now();
	}
	}

