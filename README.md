# middleware without Authentication
# To test in post man
i) GET http://localhost:8080/products
ii) PUT http://localhost:8080/products/P001
 Add to body - Raw- JSON
   {
        "id": "P001",
        "name": "icecream"
   }
iii) POST http://localhost:8080/products/P003
 Add to body - Raw- JSON
   {
        "id": "P003",
        "name": "milk"
    }
iv) DELETE http://localhost:8080/products/P003
