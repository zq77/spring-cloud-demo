```
POST http://localhost:8010/api/orders
Content-Type: application/json

{
    "name": "xxx",
    "phone": "13703417792",
    "address": "xxx",
    "openid": "kdfjskdj",
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

PUT http://localhost:8010/api/orders/finish
Content-Type: application/x-www-form-urlencoded

orderId=xxx
```