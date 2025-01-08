# stockManagementApplication
Stock Management Application

This project is a Spring Boot application for stock management. The application allows you to perform CRUD operations on categories and products.

## Requirements

- Java 17
- Maven 3.6+
- MySQL

## Setup

1. Clone the project:
    ```sh
    git clone https://github.com/adem2817/stockManagementApplication.git
    cd stockManagementApplication
    ```

2. Configure the `application.properties` file:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/stock_management
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Install Maven dependencies:
    ```sh
    mvn clean install
    ```

4. Start the application:
    ```sh
    mvn spring-boot:run
    ```

## Usage

### Add Category

To add a new category, use the following API:
- **URL:** `/categories`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "name": "Electronics"
    }
    ```

### Add Subcategory

To add a subcategory to an existing category, use the following API:
- **URL:** `/categories/{category_id}`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "name": "Phones"
    }
    ```

### Search Products

To search for products, use the following API:
- **URL:** `/products/search`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "name": "iPhone",
        "categoryName": "Phones",
        "minPrice": 5000,
        "maxPrice": 10000
    }
    ```

### Sell Product

To sell a product, use the following API:
- **URL:** `/products/sell`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "productUuid": "123e4567-e89b-12d3-a456-426614174000",
        "quantity": 1
    }
    ```

## Technologies and Libraries

- **Spring Boot:** Framework for building Java-based applications.
- **Spring Data JPA:** Abstraction over JPA to interact with relational databases.
- **Spring Web Services:** Framework for creating web services.
- **MySQL:** Relational database management system.
- **Lombok:** Java library to reduce boilerplate code.
- **Swagger Annotations:** Annotations for documenting APIs.
- **Validation API:** Java API for bean validation.
- **Mockito:** Framework for creating mock objects in tests.

## Running Tests

To run tests:
```sh
mvn test