package com.global.service;

import java.util.List;
import java.util.Scanner;

import com.global.repository.ProductRepository;
import com.global.to.ProductTO;

public class ProductService {

	ProductRepository productRepository = new ProductRepository();
	Scanner sc = new Scanner(System.in);

	public List<ProductTO> getAllProducts() {

		return productRepository.findAllProducts();
	}

	public List<ProductTO> getProductsByProductID() {
		// TODO Auto-generated method stub
		System.out.println("Enter Product ID to search Product");
		int productID = sc.nextInt();

		return productRepository.findAllProductsByID(productID);
	}

	public void addProduct() {
		// TODO Auto-generated method stub
		System.out.println("Enter Product ID ");
		int productID = sc.nextInt();
		System.out.println("Enter Product Price");
		int price = sc.nextInt();
		System.out.println("enter Product Name");
		String productName = sc.next();
		System.out.println("enter Product Category");
		String category = sc.next();

		ProductTO p1 = new ProductTO(productID, price, productName, category);
		productRepository.addProduct(p1);
	}

	public void removeProduct() {
		// TODO Auto-generated method stub
		System.out.println("Enter Product ID to remove Product");
		int productID = sc.nextInt();

		productRepository.rmvProduct(productID);

	}

	public void updateProduct() {
		// TODO Auto-generated method stub
		System.out.println("Enter Product ID to update Product");
		int productID = sc.nextInt();
		System.out.println("Enter price to be updated");
		int price = sc.nextInt();

		productRepository.updateProduct(productID, price);
	}

	public List<ProductTO> getAllProductsByPriceAsc() {

		return productRepository.findAllProductsByPriceAsc();
	}

	public List<ProductTO> getAllProductsByPriceDsc() {

		return productRepository.findAllProductsByPriceDsc();
	}

}
