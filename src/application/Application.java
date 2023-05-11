package application;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import application.store.Customer;
import application.store.Order;
import application.store.Product;

public class Application {
	Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		Product p1 = new Product("HarryPotter1", "Books", 122.50);
		Product p2 = new Product("HarryPotter2", "Books", 12.65);
		Product p3 = new Product("HarryPotter3", "Books", 142.99);
		Product p4 = new Product("HarryPotter4", "Books", 35.20);
		Product p5 = new Product("Tutina", "Baby", 55.50);
		Product p6 = new Product("Bavaglino", "Baby", 7.80);
		Product p7 = new Product("Ciuccio", "Baby", 15.20);
		Product p8 = new Product("Biberon", "Baby", 10);
		Product p9 = new Product("Scarpine", "Baby", 25.60);

		List<Product> List = new ArrayList<>();
		List.add(p1);
		List.add(p2);
		List.add(p3);
		List.add(p4);
		List.add(p5);
		List.add(p6);
		List.add(p7);

		/****** ESERCIZIO1 *********/
		List<Product> bookListMaggioreCento = List.stream()
				.filter(book -> book.getPrice() > 100 && book.getCategory().equals("Books")).toList();
		List<String> bookListMaggioreCentoParsata = bookListMaggioreCento.stream().map(book -> book.toString())
				.toList();
		if (bookListMaggioreCentoParsata.size() > 0) {
			System.out.println(bookListMaggioreCentoParsata);

		} else {
			System.out.println("NESSUN ELEMENTO TROVATO");
		}
		/****** ESERCIZIO2 *********/
		Customer c1 = new Customer("Maria", 1);
		Customer c2 = new Customer("Mario", 2);
		Customer c3 = new Customer("Giiuseppe", 1);
		List<Product> babyListC1 = List.stream()
				.filter(baby -> baby.getCategory().toString().equals("Baby") && baby.getName().equals("Tutina")
						|| baby.getName().equals("Ciuccio"))
				.toList();
		List<Product> babyListC2 = List.stream()
				.filter(baby -> baby.getCategory().toString().equals("Baby") && baby.getPrice() > 20).toList();
		List<Product> babyListC3 = List.stream()
				.filter(baby -> baby.getCategory().toString().equals("Baby") && baby.getPrice() < 10).toList();

		Order o1 = new Order("spedito", babyListC1, c1);
		Order o2 = new Order("spedito", babyListC2, c2);
		Order o3 = new Order("spedito", babyListC3, c3);
		List<Order> listaOrdiniBaby = new ArrayList<>();
		listaOrdiniBaby.add(o1);
		listaOrdiniBaby.add(o2);
		listaOrdiniBaby.add(o3);

		System.out.println(listaOrdiniBaby);

	}

}
