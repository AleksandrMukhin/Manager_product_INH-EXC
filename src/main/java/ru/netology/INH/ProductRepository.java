package ru.netology.INH;

public class ProductRepository {

    public Product[] products = new Product[0];

    public void save(Product prod) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = prod;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product prod : products) {
            if (prod.getId() != id) {
                tmp[copyToIndex] = prod;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product findById(int id) {
        for (Product prod : products) {
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }
}


