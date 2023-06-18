```
POST http://localhost:8080/order/api/orders
Content-Type: application/json
Cookie: openid=xxx

{
    "name": "xxx",
    "phone": "13703417792",
    "address": "xxx",
    "openid": "xxx",
    "items": [
      {
        "productId": 1,
        "productQuantity": 1
      },
      {
        "productId": 2,
        "productQuantity": 1
      }
    ]
}

PUT http://localhost:8080/order/api/orders/finish
Content-Type: application/x-www-form-urlencoded
Cookie: token=5c06c64c-a6b3-49a1-8ac9-32674fb57c16

orderId=xxx

GET http://localhost:8080/product/products
GET http://localhost:8080/user-dev.yml
GET http://localhost:8080/user/seller/login?openid=yyy
GET http://localhost:8080/user/customer/login?openid=xxx
```