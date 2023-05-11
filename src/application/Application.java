package application;

import java.time.LocalDate;
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
		Product p10 = new Product("Boxer", "Boy", 5.60);
		Product p11 = new Product("Cravatta", "Boy", 26.60);
		Product p12 = new Product("Portafogli", "Boy", 75.80);
		Product p13 = new Product("Scarpe", "Boy", 125.90);
		Product p14 = new Product("Camicia", "Boy", 50);
		Product p15 = new Product("Papillon", "Boy", 35.30);

		List<Product> listaMagazzino = new ArrayList<>();
		listaMagazzino.add(p1);
		listaMagazzino.add(p2);
		listaMagazzino.add(p3);
		listaMagazzino.add(p4);
		listaMagazzino.add(p5);
		listaMagazzino.add(p6);
		listaMagazzino.add(p7);
		listaMagazzino.add(p8);
		listaMagazzino.add(p9);
		listaMagazzino.add(p10);
		listaMagazzino.add(p11);
		listaMagazzino.add(p12);
		listaMagazzino.add(p13);
		listaMagazzino.add(p14);
		listaMagazzino.add(p15);
		System.out.println("ESERCIZIO1");
		List<Product> bookListMaggioreCento = listaMagazzino.stream()
				.filter(book -> book.getPrice() > 100 && book.getCategory().equals("Books")).toList();
		List<String> bookListMaggioreCentoParsata = bookListMaggioreCento.stream().map(book -> book.toString())
				.toList();
		if (bookListMaggioreCentoParsata.size() > 0) {
			System.out.println(bookListMaggioreCentoParsata);

		} else {
			System.out.println("NESSUN ELEMENTO TROVATO");
		}
		System.out.println("ESERCIZIO2");
		Customer c1 = new Customer("Maria", 1);
		Customer c2 = new Customer("Mario", 2);
		Customer c3 = new Customer("Giiuseppe", 2);
		List<Product> babyListC1 = listaMagazzino.stream()
				.filter(baby -> baby.getCategory().toString().equals("Baby") && baby.getName().equals("Tutina")
						|| baby.getName().equals("Ciuccio"))
				.toList();
		List<Product> babyListC2 = listaMagazzino.stream()
				.filter(baby -> baby.getCategory().toString().equals("Baby") && baby.getPrice() > 20).toList();
		List<Product> babyListC3 = listaMagazzino.stream()
				.filter(baby -> baby.getCategory().toString().equals("Baby") && baby.getPrice() < 10).toList();
		LocalDate d1 = LocalDate.of(2021, 1, 01);
		LocalDate d2 = LocalDate.of(2021, 2, 04);

		Order o1 = new Order("spedito", babyListC1, c1);
		Order o2 = new Order("spedito", d1, babyListC2, c2);
		Order o3 = new Order("spedito", d2, babyListC3, c3);
		List<Order> listaOrdiniBaby = new ArrayList<>();
		listaOrdiniBaby.add(o1);
		listaOrdiniBaby.add(o2);
		listaOrdiniBaby.add(o3);

		System.out.println(listaOrdiniBaby);
		System.out.println("ESERCIZIO3");
		List<Product> boysList = listaMagazzino.stream().filter(boys -> boys.getCategory().toString().equals("Boy"))
				.map(boys -> {
					boys.setPrice(boys.getPrice() * 0.9);
					return boys;
				}).toList();
		System.out.println(boysList);
		System.out.println("ESERCIZIO4");
		List<List<Product>> listaProdottiFebbraioAprile = listaOrdiniBaby.stream()
				.filter((order -> order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31))
						&& order.getOrderDate().isBefore(LocalDate.of(2021, 4, 2))
						&& (order.getCustomer().getTier() == 2)))
				.map(order -> order.getProducts()).toList();
		System.out.println(listaProdottiFebbraioAprile);

	}

}
