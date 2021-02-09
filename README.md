# DEMO GRAPHQL

This is a simple demo project of graphql based on spring-boot and graphql-java.
It is mostly inspired by the official tutorial of https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/ .

## Build and Launch

Build the project just as a classis spring-boot project, and run it as a classic war/spring-boot war.

## Usage
Once the server is up, you can hit http://localhost:8080/graphql endpoint which is the default graphql endpoint.
Note: you can override this endpoint with the path you want, by defining 'graphql.url' property in the spring properties.

## Keypoints
The main files to watch to understand how graphql works are schema.graphqls, *DataFetcher.java, GraphQLProvider.java.

## Use cases
In this project, there are 2 use cases:
  - Fetch the data from a in-memory map: com.evtech.mdq.ro.graphql.fetcher.InMemoryGraphQLDataFetchers
  - Fetch the data from jpa repositories (from postgres or H2 db): com.evtech.mdq.ro.graphql.fetcher.LoginDataFetcher

## GraphQL Playground
Crafting manually graphql queries are cumbersome. That's why you should use prebuilt graphql playgrounds.
These are either built upon electron, express/nodejs or pure html/js.
The one I recommend is https://www.electronjs.org/apps/graphql-playground which can be installed as a classic application. 
It works like Postman but for graphql. It can parse the graphql schemas and generate docs.

It also be used in other flavours, available here: https://www.electronjs.org/apps/graphql-playground.

## Examples

Query to get a book:

    {
      bookById(id: "book-3") {
        id
        name
        author {
          firstName
          lastName
        }
      }
    }


Query to get a login by id:
    
    {
      loginById(id: 62335273) {
        id
        login
      }
    }
    
Query to get a login by login:

    {
      loginByLogin(login: "7904284N") {
        id
        login
        actif
            expired
      }
    }
    
Query to get a login and the utilisateur associated:

    {
      loginByLogin(login: "7904284N") {
        login
    		expired
        actif
        utilisateur {
          nom
          prenom
          numeroCp
          email
        }
      }
    }