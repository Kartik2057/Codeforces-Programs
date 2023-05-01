#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Product {
public:
    int product_id;
    float price;
    string name;
    string manufacturing_date;
};

class ConsumableProduct : public Product {
public:
    string expiry_date;
};

class Customer {
public:
    string name;
    string address;
};

class Member : public Customer {
public:
    int membership_id;
};

class NonMember : public Customer {
public:
    int mobile_number;
};

class GroceryShop {
public:
    Member members[10];
    NonMember non_members[10];
    Product products[5];
    int num_members = 0;
    int num_non_members = 0;
    int num_products = 0;

    void add_member(Member member) {
        members[num_members] = member;
        num_members++;
    }

    void add_non_member(NonMember non_member) {
        non_members[num_non_members] = non_member;
        num_non_members++;
    }

    void add_product(Product product) {
        products[num_products] = product;
        num_products++;
    }

    float calculate_discount(Member& member) {
        float total_bill = 0;
        for (int i = 0; i < num_products; i++) {
            total_bill += products[i].price;
        }
        float discount = total_bill * 0.2;
        return discount;
    }

    float calculate_discount(NonMember& non_member) {
        float total_bill = 0;
        float consumable_discount = 0;
        float non_consumable_discount = 0;
        for (int i = 0; i < num_products; i++) {
            total_bill += products[i].price;
            if (typeid(products[i]) == typeid(ConsumableProduct)) {
                consumable_discount += products[i].price * 0.02;
            } else {
                non_consumable_discount += products[i].price * 0.04;
            }
        }
        float discount = consumable_discount + non_consumable_discount;
        return discount;
    }

    void display_max_discount_customer() {
        float max_discount = 0;
        string max_discount_customer_name;
        for (int i = 0; i < num_members; i++) {
            float discount = calculate_discount(members[i]);
            if (discount > max_discount) {
                max_discount = discount;
                max_discount_customer_name = members[i].name;
            }
        }
        for (int i = 0; i < num_non_members; i++) {
            float discount = calculate_discount(non_members[i]);
            if (discount > max_discount) {
                max_discount = discount;
                max_discount_customer_name = non_members[i].name;
            }
        }
        cout << "Customer " << max_discount_customer_name << " has availed the maximum discount of " << max_discount << endl;
    }
};

int main() {
    GroceryShop shop;

    Member member1;
    member1.name = "kartik";
    member1.address = "C-131 Govindpuri Modinagar";
    member1.membership_id = 12345;
    shop.add_member(member1);

    NonMember non_member;
    non_member.name = "Manvi";
    non_member.address = "C-151 Govindpuri Modinagar";
    non_member.mobile_number = 6789;
    shop.add_non_member(non_member);

    Product product1;
    product1.product_id = 1;
    product1.name = "Kurkure";
    product1.price = 20.99;
    product1.manufacturing_date = "2022-01-01";
    shop.add_product(product1);

  

    Product product2;
    product2.product_id = 2;
    product2.name = "Mango dolly";
    product2.price = 10.99;
    product2.manufacturing_date = "2022-01-10";

    ConsumableProduct c_product1;
    c_product1.product_id = 3;
    c_product1.name = "Butter";
    c_product1.price = 14.99;
    c_product1.manufacturing_date = "2022-01-05";
    c_product1.expiry_date = "2022-01-15";

    shop.add_product(product2);
    shop.add_product(c_product1);

    shop.display_max_discount_customer();
    return 0;
}
