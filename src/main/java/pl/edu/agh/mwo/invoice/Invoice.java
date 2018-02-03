package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products;
	private BigDecimal netValue;
	private BigDecimal tax;
	private BigDecimal grossValue;
	private LocalDate date;
	private static int number=0;
	
	Invoice(){ //konstruktor
		netValue = new BigDecimal(0);
		tax = new BigDecimal(0);
		grossValue = new BigDecimal(0);
		products = new ArrayList<Product>();
		date=LocalDate.now();
		number+=1;
	}

	public void addProduct(Product product) {
		products.add(product);
		update();
		}
	
		
		 //odświeżanie wartości subtotal, tax, total, date
	

	public void addProduct(Product product, Integer quantity) {
		if (quantity <=0){
			throw new IllegalArgumentException();
		}
		for (int i=0;i<quantity;i++){
			products.add(product);
		}
		update();
	}

	public BigDecimal getNetValue() { //getter
		return netValue;
	}

	public BigDecimal getTax() { //getter
		return tax;
	}

	public BigDecimal getGrossValue() { //getter
		return grossValue;
	}	
	public static int getNumber(){
		return number;
	}
	
	
	public void setGrossValue(){ //setter
		grossValue = BigDecimal.ZERO;
		for (Product product:products){
			grossValue=grossValue.add(product.getPriceWithTax());
		}
		
	}
	public void setNetValue(){ //setter
		netValue = BigDecimal.ZERO;
		for(Product product:products){
			netValue=netValue.add(product.getPrice());
	}}
	public void setTax(){ //setter
		tax = grossValue.subtract(netValue);
	}
		
	public void update(){
		setNetValue();
		setGrossValue();
		setTax();
		date=LocalDate.now();
	}
	}

