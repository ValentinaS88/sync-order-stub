## Sync Order Stub — заглушка для нагрузочного тестирования

Базовый путь: `http://localhost:8081/stub`


## Эндпоинты

| Метод | URL | Описание | Пример запроса | Пример ответа |
| :--- | :--- | :--- | :--- | :--- |
| GET | `/stub/health` | Проверка работоспособности | — | `OK` |
| POST | `/stub/order` | Создать новый заказ | `{"productName":"Pen","quantity":14}` | `{"orderId":"xxx","productName":"Pen","status":"CREATED"}` |
| GET | `/stub/order/{id}` | Получить статус заказа | `/stub/order/550e8400-e29b-41d4-a716-446655440000` | `{"orderId":"xxx","productName":"Magazine","status":"SHIPPED"}` |

## 🐳 Docker Image
https://hub.docker.com/r/valentinas88/sync-order-stub
