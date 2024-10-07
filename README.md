# Projet alten-back

Ce projet est une application web développée avec Spring Boot dans le cadre d'un mini-projet pour un recrutement chez Alten.

L'application est développée avec Spring Boot et utilise les technologies suivantes :

* Java 17
* Spring Boot 3.2.4 
    liste des modules springs : 
    * Spring Boot Starter Web
    * Spring Boot Starter Data JPA
    * Spring Boot Starter Security
* sqlite (base de donnée legère embarquée)

## Fonctionnalités

* Fournir une API REST correspondant au front-end d'une application web de vente de produit. 

Le back-end doit gérer les API suivantes : 

| Resource           | POST                  | GET                            | PATCH                                    | PUT | DELETE           |
| ------------------ | --------------------- | ------------------------------ | ---------------------------------------- | --- | ---------------- |
| **/products**      | Create a new product  | Retrieve all products          | X                                        | X   |     X            |
| **/products/:id**  | X                     | Retrieve details for product 1 | Update details of product 1 if it exists | X   | Remove product 1 |

Un produit a les caractéristiques suivantes : 

``` typescript
class Product {
  id: number;
  code: string;
  name: string;
  description: string;
  image: string;
  category: string;
  price: number;
  quantity: number;
  internalReference: string;
  shellId: number;
  inventoryStatus: "INSTOCK" | "LOWSTOCK" | "OUTOFSTOCK";
  rating: number;
  createdAt: number;
  updatedAt: number;
}
```

## Installation

Pour installer le projet, suivez les étapes suivantes :

1. Cloner le dépôt Git 
2. Installer les dépendances Maven : `mvn clean install`

## Lancement

Pour lancer l'application :

`mvn spring-boot:run`

L'application sera disponible à l'adresse `http://localhost:8080`.

## Tests

Des tests d'API avec postman sont disponibles à la racine du projet sous le nom de "requests.postman_collection.json"

